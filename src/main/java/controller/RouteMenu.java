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

import com.github.jknack.handlebars.context.JavaBeanValueResolver;
import com.github.jknack.handlebars.context.MapValueResolver;

import model.custom.UserCustom;
import other.DefaultProperties;
import other.SpringFactory;
import other.WebContext;

@Path( "/menu" )
public class RouteMenu extends WebContext {
   
    private static Logger   logger       = Logger.getLogger( RouteMenu.class );
    @Autowired
    private Jaxb2Marshaller marshaller;

    public RouteMenu( @Context SecurityContext sc ) {

        super( sc );
    }

    @javax.annotation.security.RolesAllowed( { "Connected" } )
    @GET
    @Path( "/acceuil" )
    @Produces( MediaType.TEXT_HTML )
    public Response checkSignup( @Context SecurityContext sc ) {

        UserCustom user = getUser();
        //provide a multi contexts environment to the handlebars template, add object to map and use context helper with the first option= key of the map
        ConcurrentHashMap<String, UserCustom> multiContext= new ConcurrentHashMap<String,UserCustom>();
        com.github.jknack.handlebars.Context context = com.github.jknack.handlebars.Context.newBuilder( user )
                .combine( multiContext).resolver( MapValueResolver.INSTANCE, JavaBeanValueResolver.INSTANCE ).build();
        
        if ( !DefaultProperties.getOption( "multiDesk" ).equals( "True" ) ) {
            user.setDefaultpage( DefaultProperties.getMapping( "default" ) );
            return reloadPage( user, context );
        }
        
        try {
            // à commenter
           

            
            
            return Response.ok( SpringFactory.getHandlebarsManager().getTemplate( "html/template/mainPage/index" ).apply( context ) ).build();

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
        

        
        try {
            
            //try to compile the url send by the user
        
            return Response.ok( SpringFactory.getHandlebarsManager().getTemplate( url ).apply( context ) ).build();
        } catch ( IOException e1 ) {
            // TODO Auto-generated catch block
            //the user url don't map with any html file so we look the mapping properties
            logger.info( "Page" + url + " don't exist default or custom page will load" );
            
            //we look if the user url have any mapping properties if not we charge the default white page
            ;
            return Response.ok( SpringFactory.getHandlebarsManager().getTemplate( DefaultProperties.getMapping( url ) ).apply( context ) ).build();
        }
        finally{
            context.destroy(); 
        }

      
        
    }

    public Response reloadPage( UserCustom user, com.github.jknack.handlebars.Context context ) {

        try {

     
            return Response.ok(  SpringFactory.getHandlebarsManager().getTemplate("html/template/mainPage/index").apply( context ) ).build();

        } catch ( IOException e1 ) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            context.destroy();
        }

        return null;
    }
}
