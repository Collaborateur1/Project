package controller;

import java.io.IOException;
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
import org.joda.time.DateTime;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import filter.security.HttpHeaderNames;
import filter.security.SecureTool;
import model.bean.DefaultUser.Role;
import model.custom.UserCustom;
import model.session.UserSession;
import other.DefaultProperties;
import other.SpringFactory;
import other.WebContext;
import other.token.TokenBuilder;
import other.token.Utils;
import view.handlebars.HandlebarsManager;

@Path( "/login" )
public class RestLoginController extends WebContext {

    public RestLoginController( @Context SecurityContext securityContext ) {
        super( securityContext );
        // TODO Auto-generated constructor stub
    }

    private static Logger logger         = Logger.getLogger( RestLoginController.class );

    private Handlebars    publicTemplate = HandlebarsManager.get();

    @javax.annotation.security.PermitAll
    @GET
    @Path( "/page" )
    public Response get( @QueryParam( value = "fowardTo" ) String foward, @Context HttpServletRequest httpRequest) {

        Template template = null;
        try {

            template = publicTemplate.compile( "login" );
        } catch ( IOException e1 ) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {

            return Response.ok( template.apply( foward ) ).build();

        } catch ( IOException e ) {
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

            SpringFactory.getUsersProvider().removeUser( getUser().getDusToken() );
            URI targetURIForRedirection = new URI( DefaultProperties.getProperties( "login" ) );
            return Response.seeOther( targetURIForRedirection ).build();
        } catch ( Exception ex ) {
            return Response.status( Response.Status.BAD_REQUEST )
                    .entity( new Viewable( "/failure" ) ).build();
        }

    }

    @javax.annotation.security.PermitAll
    @POST
    @Path( "/signin" )
    public Response login( @FormParam( "email" ) String userName,
            @FormParam( "password" ) String password,
            @Context HttpServletRequest httpRequest,
            @FormParam( "fowardTo" ) String foward) throws URISyntaxException {

        // @CookieParam(HttpHeaderNames.AUTH_TOKEN) Cookie cookie
        boolean valideToken = (boolean) httpRequest.getAttribute( "valideToken" );

        String userIp = SecureTool.getClientIpAddress( httpRequest );

        logger.info( userIp + " " + DefaultProperties.getProperties( "ipconnect" ) );

        try {

            if ( userName == null || password == null ) {
                return Response.status( Response.Status.PRECONDITION_FAILED ).build();
            }

            UserCustom user = SpringFactory.getUserJob().getUser( userName, password );

        
            if ( null != user ) {

                String sessionId = "", newSessionId = "";

                long maxAge;
                try {
                    maxAge = Long.valueOf( DefaultProperties.getOption( "tokenMaxAge" ) );
                } catch ( Exception ex ) {
                    logger.error( "option TockenMaxAge must be a int value default=2000", ex );
                    maxAge = 2000;
                }

                sessionId = (String) httpRequest.getAttribute( "Token" );

                try {
                    if ( valideToken )
                        valideToken = Utils.AuthTokenIsValide( user, sessionId );
                } catch ( Exception ex ) {
                    valideToken = false;
                }

                if ( !valideToken ) {

                    try {
                        sessionId = TokenBuilder.createAuthToken( String.valueOf( user.getID() ), user.getDusEmail(),
                                HttpHeaderNames.AUTH_TOKEN, user.getDusMdp(), maxAge * 1000 );
                    } catch ( Exception e ) {
                        logger.info( "can't generate the tocken" + e );
                    }

                }

                user.setDusIp( userIp );
                user.addRole( Role.Connected );
             // temporaire, pour charger le menu
                user.getDusParameters();
                URI targetURIForRedirection = new URI(
                        "".equals( foward ) || foward == null ? "menu/acceuil" : foward );

                UserCustom userTemp;
                //now we look if user already connect
                userTemp = SpringFactory.getUsersProvider().userIsAlreadyConnected( userName );
               
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
                        SpringFactory.getUsersProvider().removeUser( userTemp.getDusToken() );
                        user.setDusToken( sessionId );
                        
                        UserSession userSess = new UserSession(user.getDusToken(), user, true, false,
                                new DateTime(),
                                new DateTime() );
                        SpringFactory.getUsersProvider().setUserSession( user.getDusToken(), userSess );

                        SpringFactory.getGenericJob().updateObject( user );

                    } else {
                        //if the user in the cache is valid we use it
                        user.setDusToken(userTemp.getDusToken());
                        SpringFactory.getUsersProvider().userIsValidForConnect( userTemp.getDusToken(), true );// nom
                                                                                                               // à
                                                                                                               // changer
                    }
                    return Utils.setCookie( HttpHeaderNames.AUTH_TOKEN, user.getDusToken(), maxAge,
                            targetURIForRedirection, true );
                }

                //

                user.setDusToken( sessionId );               
                UserSession userSess = new UserSession( sessionId, user, true, false, new DateTime(),
                        new DateTime() );
                SpringFactory.getUsersProvider().setUserSession( sessionId, userSess );
                SpringFactory.getGenericJob().updateObject( user );
                return Utils.setCookie( HttpHeaderNames.AUTH_TOKEN, user.getDusToken(), maxAge * 1000,
                        targetURIForRedirection, true );
            } else {

                return Response.status( Response.Status.PRECONDITION_FAILED ).build();
            }

        } catch ( Exception ex ) {
            logger.error( ex );
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
