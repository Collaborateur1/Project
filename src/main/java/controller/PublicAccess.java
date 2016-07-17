package controller;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.sun.jersey.api.view.Viewable;

import view.handlebars.HandlebarsManager;


@Controller
@Path( "/public" )
public class PublicAccess {
private Handlebars publicTemplate=HandlebarsManager.get();


    @javax.annotation.security.PermitAll
    @GET
    @Path("/login")
    public Response get(@QueryParam(value = "fowardTo") String foward) {
      
        
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
            return Response.ok( template.apply(foward)).cookie( new NewCookie( "cookie",randomUUIDString  ) ).header("test", "wopapa" ).build();
           
        } catch (IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            return Response.ok(new Viewable("/WEB-INF/htmlFile/login.html")).cookie( new NewCookie( "cookie",randomUUIDString ) ).build();
        }
    }
}
