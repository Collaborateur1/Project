package controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.core.ResourceContext;
import com.sun.jersey.api.view.Viewable;

import filter.security.SecureTool;
import model.bean.DefaultUser.Role;
import model.custom.UserCustom;
import model.session.UserSession;
import other.DefaultProperties;
import other.SpringFactory;
import view.handlebars.HandlebarsManager;


@Path( "/login" )
public class RestLoginController {

    private static Logger logger = Logger.getLogger( RestLoginController.class );
   
    
    private Handlebars publicTemplate=HandlebarsManager.get();

    @Context private ResourceContext rc;
    
    @javax.annotation.security.PermitAll
    @GET
    @Path("/page")
    public Response get(@QueryParam(value = "fowardTo") String foward,@Context HttpServletRequest httpRequest) {
      
        
        Template template = null;
        try {
  
            
            template=publicTemplate.compile("login");
        } catch ( IOException e1 ) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        try {
            
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            return Response.ok( template.apply(foward)).cookie( new NewCookie( new Cookie( "cookie",randomUUIDString,"/",null),"nocomment",2000,false  ) ).header("test", "wopapa" ).build();
           
        } catch (IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            return Response.ok(new Viewable("/WEB-INF/htmlFile/login.html")).cookie( new NewCookie( new Cookie( "cookie",randomUUIDString,"/",null),"nocomment",2000,false  ) ).header("test", "wopapa" ).build();
        }
    }
    
    
    @javax.annotation.security.PermitAll
    @GET
    @Path("/logout")
   public Response logout(@Context HttpServletRequest httpRequest) throws URISyntaxException {
        
        
        try{
            final String sessionId = httpRequest.getHeader( "cookie" ).split("=")[1];
            SpringFactory.getUsersProvider().removeUser( sessionId );
            URI targetURIForRedirection = new URI( DefaultProperties.getProperties("login"));
            return Response.seeOther(targetURIForRedirection).build();
        }catch (Exception ex)
        {
            return Response.status(Status.BAD_REQUEST)
                    .entity(new Viewable("/failure")).build();
        }
        
       
       
    }

    @javax.annotation.security.PermitAll
    @POST
    @Path( "/signin" )
    public Response login( @FormParam( "email" ) String userName,
            @FormParam( "password" ) String password,
            @Context HttpServletRequest httpRequest,
            @FormParam( "fowardTo" ) String foward,@CookieParam("cookie") Cookie cookie) throws URISyntaxException {
        
        
        logger.info(SecureTool.getClientIpAddress(httpRequest) +DefaultProperties.getProperties( "ipconnect" ));
      
       
           
            
        
       
        try {
            String sessionId = "";
            if ( httpRequest != null )
                {
                
                
                sessionId =cookie.getValue();
                
                
                
                }

            if ( userName == null || password == null ) {
                return Response.status( Status.PRECONDITION_FAILED ).build();
            }

            UserCustom user = SpringFactory.getUserJob().getUser( userName, password );
            
           
           // DefaultUser user = userjob.getUser( "makilapuls@msn.com", "makilapuls@msn.com" );
            if ( null != user ) {
                URI targetURIForRedirection = new URI(
                        "".equals( foward ) || foward == null ? "menu/acceuil": foward );
                
                if(DefaultProperties.getOption( "multiDesk").equals( "True"))
                {UserCustom userTemp;
                    userTemp=SpringFactory.getUsersProvider().userIsAlreadyConnected( userName );
                    if(userTemp!=null){
                        
                    UserSession userSess =new UserSession( sessionId, userTemp, true, false, new DateTime(), new DateTime() );
                    SpringFactory.getUsersProvider().setUserSession( sessionId, userSess );
                    return Response.seeOther( targetURIForRedirection ).build();
                    }
                }

                // si l'utilisateur est c'est deja connecté et que son token est
                // valide
                // prévoir system d'automatisation de la connexion
                if ( SpringFactory.getUsersProvider().userIsValidForConnect( sessionId, true ) ) {
//                    RestMenuController restM= rc.getResource(RestMenuController.class);
//                    return restM.checkSignup();
                   
                    return Response.seeOther( targetURIForRedirection ).build();
                    // return Response.ok().entity(new
                    // Viewable("/WEB-INF/htmlFile/body.html")).header( "testé",
                    // "test" ).build();
                }

                user.addRole( Role.Connected );
                //temporaire, pour charger le menu
                user.getDusParameters();
                UserSession userSess =new UserSession( sessionId, user, true, false, new DateTime(), new DateTime() );
                SpringFactory.getUsersProvider().setUserSession( sessionId, userSess );
//                RestMenuController restM= rc.getResource(RestMenuController.class);
//                return restM.checkSignup();
                return Response.ok().build();
            } else {
                // return Response.status(Status.BAD_REQUEST)
                // .entity(new Viewable("/failure")).build();
                return Response.status( Status.PRECONDITION_FAILED ).build();
            }

        } catch ( Exception ex ) {
            logger.error( ex.getMessage() );
            return Response.status( Status.PRECONDITION_FAILED ).build();
        }

    }
    
   

    @GET
    @Path("/checkSignup")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkSignup( @QueryParam(value="email")String email,@QueryParam(value="password") String  password ) {
        String variable="{signEmailInput:true,signPasswordInput :true";
       
       
        try{
            SpringFactory.getUserJob().CheckEmail( email );
            SpringFactory.getUserJob().IsNew(email);
           variable="{\"signEmailInput\":\"true\",";
        }catch(Exception ex)
        {
            variable="{\"signEmailInput\":\"false\",";    
        }
        
        try{
            SpringFactory.getUserJob().CheckMdp( password );
            
           variable+="\"signPasswordInput\":\"true\"}";
        }catch(Exception ex)
        {
            variable+="\"signPasswordInput\":\"false\"}";    
        }
        
       // ObjectMapper jackson= new ObjectMapper(); java to json 
       
        return variable;
    }
    
    @GET
    @Path("signup")
    @Produces(MediaType.TEXT_HTML)
    public Response signup(@QueryParam(value="email")String email,
            @QueryParam(value="password") String  password, 
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName) {
        //toUpdate
        if(SpringFactory.getUserJob().ValidateAndCreateUser(lastName, firstName, email,"",password,""))
        return Response.ok().build();
        
        return Response.status(Status.BAD_REQUEST).build();
    }
    

    
}
