package controller.routePro;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.monitorjbl.json.JsonView;
import com.monitorjbl.json.JsonViewSerializer;
import com.monitorjbl.json.Match;

import model.custom.UserCustom;
import other.SpringFactory;
import other.WebContext;

@Path( "/user" )
public class UserDataProvider extends WebContext {
    private static Logger   logger       = Logger.getLogger( UserDataProvider.class );
    
    public UserDataProvider(@Context SecurityContext securityContext ) {
        super( securityContext );
        // TODO Auto-generated constructor stub
    }
    
    @javax.annotation.security.RolesAllowed( { "Connected" } )
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserData(@PathParam("id") String id){
     
        long userId;
        try{
            userId=Long.parseLong( id );
        
        }catch( Exception ex){
            
            logger.info( "Bad format for user ID",ex );
            return Response.status( Response.Status.PRECONDITION_FAILED ).entity( "{\"message\":\"" + "Bad format for user ID" + "\"}").build();
        }
        
        UserCustom user=null;
        if(getUser().getDusID().equals( userId ))
        user=getUser();
        else
        user=(UserCustom) SpringFactory.getGenericJob().getObject(UserCustom.class,id, false );
        
         if(user==null)
         return Response.noContent().build();
         //must be optimized
         ObjectMapper mapper = new ObjectMapper();
         SimpleModule module = new SimpleModule();
         module.addSerializer(JsonView.class, new JsonViewSerializer());
         mapper.registerModule(module);
         
         
         String jsonUser=null;
        try {
            jsonUser = mapper.writeValueAsString(JsonView.with(user).onClass(UserCustom.class, Match.match().exclude("dusDossier").
                    exclude("section").exclude("dusMdp").exclude( "dusToken" ).exclude( "dusRoles" ).exclude( "dusParameters" )));
        } catch ( JsonProcessingException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
          return Response.status(Response.Status.OK).entity(jsonUser).build();
        
    }
    
    @javax.annotation.security.RolesAllowed( { "Connected" } )
    @GET
    @Path("/all/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUserData(@PathParam("id") String id){
     
        
        try{
        Long.parseLong( id );
        
        }catch( Exception ex){
            
            logger.info( "Bad format for user ID",ex );
            return Response.status( Response.Status.PRECONDITION_FAILED ).entity( "{\"message\":\"" + "Bad format for user ID" + "\"}").build();
        }
        UserCustom user=(UserCustom) SpringFactory.getGenericJob().getObject(UserCustom.class,id, true );
         if(user==null)
         return Response.noContent().build();
        
     
          return Response.status(Response.Status.OK).entity(user).build();
        
    }
}
