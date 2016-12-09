package controller.routePro;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.bean.Hairdresser;
import other.SpringFactory;


@Path( "/hairdresser" )
public class RouteHairDresser {

    
    
    @javax.annotation.security.PermitAll
    @GET
    @Path("{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response get(@PathParam("id") String id) throws JsonProcessingException {
        
        if(id==null||"".equals( id ))
            return null;
        
       Hairdresser hr= (Hairdresser) SpringFactory.getGenericJob().getObject(Hairdresser.class,id, false );
       
       return Response.status(Response.Status.OK).entity(serialize(hr)).build();  
    }
    private static String serialize(Object object) throws JsonProcessingException {
        String serialized = null;
        ObjectMapper mapper = new ObjectMapper();
        serialized = mapper.writeValueAsString(object);
        return serialized;
    }   
   
}
