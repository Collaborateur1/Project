package controller.routePro;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import model.bean.Buisness;
import other.SpringFactory;
@Path( "/business" )
public class RouteBuisness {
    private static Logger logger = Logger.getLogger( RouteBuisness.class);
    @javax.annotation.security.PermitAll
    @POST
    @Path("create")
    @Produces( MediaType.APPLICATION_JSON )
    public Response create(@FormParam( "buisZipCode" ) String buisZipCode,@FormParam( "buisName" ) String buisName,
            @FormParam( "longitude" ) Double longitude, @FormParam( "latitude" ) Double latitude ) throws JsonProcessingException {
        boolean save=false;
        Buisness bs= new Buisness();
        
        if(buisZipCode!=null&&!"".equals( buisZipCode )){
            bs.setBuisZipCode( buisZipCode );
            save=true;
        }
        
        if(longitude!=null&&!"".equals( longitude )){
            bs.setBuisLongitude( longitude );
            save=true;
        }
        
        if(latitude!=null&&!"".equals( latitude )){
            bs.setBuisLatitude( latitude );
            save=true;
        }
        
        if(buisName!=null&&!"".equals( buisName )){
            bs.setBuisName( buisName );
            save=true;
        }
       try{
           
        if(save)
         SpringFactory.getGenericJob().createObject( bs );
        
        return Response.status(Response.Status.OK).build();  
       }catch(Exception ex){
           
           logger.error( ex.getStackTrace()[0].getMethodName(),ex);
           return Response.serverError().entity(ex.toString()).build();
       }
   }
}
