package controller;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.context.JavaBeanValueResolver;
import com.github.jknack.handlebars.context.MapValueResolver;

import model.custom.UserCustom;
import other.DefaultProperties;
import other.WebContext;
import view.handlebars.HandlebarsManager;

@Path( "/menu" )
public class RestMenuController extends WebContext {
    private Handlebars      menuTemplate = HandlebarsManager.get();
    private static Logger   logger       = Logger.getLogger( RestMenuController.class );
    @Autowired
    private Jaxb2Marshaller marshaller;

    public RestMenuController( @Context SecurityContext sc ) {

        super( sc );
    }

    @javax.annotation.security.RolesAllowed( { "Connected" } )
    @GET
    @Path( "/acceuil" )
    @Produces( MediaType.TEXT_HTML )
    public Response checkSignup( @Context SecurityContext sc ) {

        UserCustom user = getUser();
        //provide a multi context environment to the handlebar template, add object to map and use context helper with the first option= key of the map
        ConcurrentHashMap<String, UserCustom> multiContext= new ConcurrentHashMap<String,UserCustom>();
        com.github.jknack.handlebars.Context context = com.github.jknack.handlebars.Context.newBuilder( user )
                .combine( multiContext).resolver( MapValueResolver.INSTANCE, JavaBeanValueResolver.INSTANCE ).build();
        
        if ( !DefaultProperties.getOption( "multiDesk" ).equals( "True" ) ) {
            user.setDefaultpage( DefaultProperties.getMapping( "default" ) );
            return reloadPage( user, context );
        }
        
        try {
            // à commenter
           

            Template template = null;
            template = menuTemplate.compile( "index2" );
            return Response.ok( template.apply( context ) ).build();

        } catch ( IOException e1 ) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            context.destroy();
        }

        return null;
    }

    @javax.annotation.security.RolesAllowed( { "Connected" } )
    @GET
    @Path( "{url}" )
    @Produces( MediaType.TEXT_HTML )
    public Response loadPage( @PathParam( "url" ) String url, @QueryParam( value = "param" ) String param,
            @QueryParam( value = "argu" ) String argu, @QueryParam( value = "currentPage" ) String currentPage)
                    throws IOException {
        UserCustom user = getUser();
        
      //provide a multi context environment to the handlebar template, add object to map and use context helper with the first option= key of the map
        ConcurrentHashMap<String, UserCustom> multiContext= new ConcurrentHashMap<String,UserCustom>();
        
        //load the user by default in the context and optionally the others context with multiContext
        com.github.jknack.handlebars.Context context = com.github.jknack.handlebars.Context.newBuilder( user )
                .combine( multiContext).resolver( MapValueResolver.INSTANCE, JavaBeanValueResolver.INSTANCE ).build();
        //update the current user page in ajax mode
        if ( currentPage != null & !"".equals( currentPage ) ) {
            user.setCurrentpage( currentPage );

        } else {
          //Actualize the current user page (refresh navigator) 
            user.setCurrentpage( url );
            return reloadPage( user, context );
        }
        
        Template template = null;
        
        try {
            
            //try to compile the url send by the user
            template = menuTemplate.compile( url );
            return Response.ok( template.apply( context ) ).build();
        } catch ( IOException e1 ) {
            // TODO Auto-generated catch block
            //the user url don't map with any html file so we look the mapping properties
            logger.info( "Page" + url + " don't exist default or custom page will load" );
            
            //we look if the user url have any mapping properties if not we charge the default white page
            template = menuTemplate.compile( DefaultProperties.getMapping( url ) );
            return Response.ok( template.apply( context ) ).build();
        }
        finally{
            context.destroy(); 
        }

      
        
    }

    public Response reloadPage( UserCustom user, com.github.jknack.handlebars.Context context ) {

        try {

            Template template = menuTemplate.compile( "index2" );
            return Response.ok( template.apply( context ) ).build();

        } catch ( IOException e1 ) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            context.destroy();
        }

        return null;
    }
}
