package controller.route;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import model.job.GenericJob;
import other.SpringFactory;


@Path( "/appointment" )
public class RouteAppointment {
    private static Logger logger = Logger.getLogger( RouteAppointment.class);
    @javax.annotation.security.PermitAll
    @GET
    @Path("{id}")
    @Produces( MediaType.APPLICATION_JSON )
    public Response get(@PathParam("id") String id,@QueryParam(value = "startdate") String startdate,@QueryParam(value = "endtdate") String enddate) throws JsonProcessingException {
        
        if(id==null||"".equals( id ))
            return Response.noContent().build();
     try{   
        GenericJob test= SpringFactory.getGenericJob();
       
       return Response.status(Response.Status.OK).entity(null).build();  
       
 }catch(Exception ex){
        
        logger.error( ex.getStackTrace()[0].getMethodName(),ex);
        return Response.serverError().entity(ex.toString()).build();
    }
    }
}
