package controller.route;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

import model.job.GenericJob;
import other.SpringFactory;


@Path( "/appointment" )
public class RouteAppointment {
    @javax.annotation.security.PermitAll
    @GET
    @Path("{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response get(@PathParam("id") String id,@QueryParam(value = "startdate") String startdate,@QueryParam(value = "endtdate") String enddate) throws JsonProcessingException {
        
        if(id==null||"".equals( id ))
            return null;
        
        GenericJob test= SpringFactory.getGenericJob();
       
       return Response.status(Response.Status.OK).entity(null).build();  
    }
}
