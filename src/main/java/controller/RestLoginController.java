package controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;
import org.glassfish.jersey.server.mvc.Viewable;

import filter.security.HttpHeaderNames;
import filter.security.SecureTool;
import model.bean.DefaultUser.Role;
import model.custom.UserCustom;
import other.DefaultProperties;
import other.SpringFactory;
import other.WebContext;
import other.token.TokenBuilder;
import other.token.Utils;

@Path( "/login" )
public class RestLoginController extends WebContext {

    public RestLoginController( @Context SecurityContext securityContext ) {
        super( securityContext );
        // TODO Auto-generated constructor stub
    }

    private static Logger logger         = Logger.getLogger( RestLoginController.class );
    

    @javax.annotation.security.PermitAll
    @GET
    public Response get( @QueryParam( value = "fowardTo" ) String foward, @Context HttpServletRequest httpRequest) {

        
        try {
            String loginPage=DefaultProperties.getProperties( "connexionPage" );
            return Response.ok( SpringFactory.getHandlebarsManager().getTemplate( loginPage).apply( foward ) ).build();

        } catch (  Exception e ) {
            // TODO Auto-generated catch block
            logger.error( e );

            return Response.ok( new Viewable( "/WEB-INF/htmlFile/login.html" ) ).build();

        }
    }

    @javax.annotation.security.PermitAll
    @GET
    @Path( "/logout" )
    public Response logout( @Context HttpServletRequest httpRequest ) throws URISyntaxException {

        try {
            if("true".equals( DefaultProperties.getOption( "actorCache" ).toLowerCase()))
            SpringFactory.getUsersProvider().revokeUser(getUser().getDusToken());
            
            URI targetURIForRedirection = new URI( DefaultProperties.getProperties( "login" ) );
            
            
            return Utils.setCookie( HttpHeaderNames.AUTH_TOKEN,"offine", 1,
                    targetURIForRedirection, true );
        } catch ( Exception ex ) {
            return Response.status( Response.Status.BAD_REQUEST )
                    .entity( new Viewable( "/failure" ) ).build();
        }

    }

    @javax.annotation.security.PermitAll
    @POST
    @Path( "/signin" )
    public Response login( @FormParam( "username" ) String userName,
            @FormParam( "password" ) String password,
            @Context HttpServletRequest httpRequest,
            @FormParam( "fowardTo" ) String foward) throws URISyntaxException {

        // @CookieParam(HttpHeaderNames.AUTH_TOKEN) Cookie cookie
        boolean valideToken = (boolean) httpRequest.getAttribute( "valideToken" );
        boolean actorCache="true".equals( DefaultProperties.getOption( "actorCache" ).toLowerCase());
        
        String userIp = SecureTool.getClientIpAddress( httpRequest );

        logger.info( userIp + " " + DefaultProperties.getProperties( "ipconnect" ) );

        try {

            if ( userName == null || password == null ) {
                return Response.status( Response.Status.PRECONDITION_FAILED ).build();
            }

            UserCustom user = SpringFactory.getUserJob().getUser( userName, password );

        
            

                String sessionId = "", newSessionId = "";

                

                sessionId = (String) httpRequest.getAttribute( "Token" );
                       
                if ( user != null) {
                    
                long maxAge;
                try {
                    maxAge = Long.valueOf( DefaultProperties.getOption( "tokenMaxAge" ) );
                } catch ( Exception ex ) {
                    logger.error( "option TockenMaxAge must be a int value default=2000", ex );
                    maxAge = 2000;
                } 
                
                if ( !valideToken ) {

                    try {
                        sessionId = TokenBuilder.createAuthToken( String.valueOf( user.getID() ), user.getDusEmail(),
                                HttpHeaderNames.AUTH_TOKEN, user.getDusMdp(), maxAge * 1000 );
                    } catch ( Exception e ) {
                        logger.error( e.getStackTrace()[0].getMethodName(),e);
                        sessionId=null;
                        Response.status( Response.Status.INTERNAL_SERVER_ERROR ).build();
                    }

                }

                user.setDusIp( userIp );
                user.addRole( Role.Connected );
             // temporaire, pour charger le menu
                user.getDusParameters();
                URI targetURIForRedirection = new URI(
                        "".equals( foward ) || foward == null ? "menu/acceuil" : foward );

                UserCustom userTemp=null;
                //now we look if user already connect
               if(actorCache)
                userTemp =  SpringFactory.getUsersProvider().userCacheIsAlreadyConnected( userName );
               
                if ( userTemp != null ) {
                    //if user already connect we check the tocken
                    boolean tokenUserTempValide = false;
                    try {

                        tokenUserTempValide = Utils.AuthTokenIsValide( user, userTemp.getDusToken() );
                    } catch ( Exception ex ) {
                        tokenUserTempValide = false;
                    }
                    
                    if ( !tokenUserTempValide ) {
                         //if the cache token is not valid we change it with the new  
                        SpringFactory.getUsersProvider().revokeUser( userTemp.getDusToken() );
                        user.setDusToken( sessionId );
                        
                        
                        SpringFactory.getUsersProvider().setUserInCache( user.getDusToken(), user );
                       

                        SpringFactory.getGenericJob().updateObject( user );

                    } else {
                        //if the user in the cache is valid we use it
                        user.setDusToken(userTemp.getDusToken());
                        
                    }
                    SpringFactory.getGenericJob().updateObject( user );
                    SpringFactory.getUsersProvider().setUserInCache( sessionId, user );
                    return Utils.setCookie( HttpHeaderNames.AUTH_TOKEN, user.getDusToken(), maxAge,
                            targetURIForRedirection, true );
                }
            
                return Utils.setCookie( HttpHeaderNames.AUTH_TOKEN, sessionId, maxAge * 1000,
                        targetURIForRedirection, true );
            } else {

                return Response.status( Response.Status.PRECONDITION_FAILED ).build();
            }

        } catch ( Exception ex ) {
            logger.error( ex.getStackTrace()[0].getMethodName(),ex);
            return Response.status( Response.Status.PRECONDITION_FAILED ).build();
        }

    }

    @GET
    @Path( "/checkSignup" )
    @Produces( MediaType.APPLICATION_JSON )
    public String checkSignup( @QueryParam( value = "email" ) String email,
            @QueryParam( value = "password" ) String password) {
        String variable = "{signEmailInput:true,signPasswordInput :true";

        try {
            SpringFactory.getUserJob().CheckEmail( email );
            SpringFactory.getUserJob().IsNew( email );
            variable = "{\"signEmailInput\":\"true\",";
        } catch ( Exception ex ) {
            variable = "{\"signEmailInput\":\"false\",";
        }

        try {
            SpringFactory.getUserJob().CheckMdp( password );

            variable += "\"signPasswordInput\":\"true\"}";
        } catch ( Exception ex ) {
            variable += "\"signPasswordInput\":\"false\"}";
        }

        // ObjectMapper jackson= new ObjectMapper(); java to json

        return variable;
    }

    @GET
    @Path( "signup" )
    @Produces( MediaType.TEXT_HTML )
    public Response signup( @QueryParam( value = "email" ) String email,
            @QueryParam( value = "password" ) String password,
            @QueryParam( "firstName" ) String firstName,
            @QueryParam( "lastName" ) String lastName) {
        // toUpdate
        try {
            if ( SpringFactory.getUserJob().ValidateAndCreateUser( lastName, firstName, email, "", password, "" ) )
                return Response.ok().build();
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            logger.error( e );
            return Response.status( Response.Status.PRECONDITION_FAILED ).entity(" email "+email+" already exist").build();
        }

        return Response.status( Response.Status.PRECONDITION_FAILED ).build();
    }

}
