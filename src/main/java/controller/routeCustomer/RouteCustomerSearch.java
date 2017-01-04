package controller.routeCustomer;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.monitorjbl.json.JsonView;
import com.monitorjbl.json.JsonViewSerializer;
import com.monitorjbl.json.Match;

import model.bean.Hairdresser;
import model.job.GenericJob;
import other.SpringFactory;

@Path( "/search" )
public class RouteCustomerSearch {
    private static Logger logger = Logger.getLogger( RouteCustomerSearch.class);
    @javax.annotation.security.PermitAll
    @GET
    @Produces( MediaType.APPLICATION_JSON)
    public Response search( @QueryParam( value = "service" ) String service,
            @QueryParam( value = "salonOrStylist" ) String salonOrStylist,
            @QueryParam( value = "longitude" ) BigDecimal longitude,
            @QueryParam( value = "latitude" ) BigDecimal latitude) throws URISyntaxException, JsonProcessingException {
       
      
       try{
        
        if(isNullOrEmpty(longitude)&&isNullOrEmpty(latitude)){
            longitude =BigDecimal.valueOf( 2.346268 );
            latitude=BigDecimal.valueOf(48.849355 );
        }
  
        BigDecimal addLatitudee=latitude.add(BigDecimal.valueOf(  0.04506 ) );
        BigDecimal addLongitudee=longitude.add(BigDecimal.valueOf( 0.065172 ) );
        BigDecimal  rmLatitude=latitude.subtract(BigDecimal.valueOf(  0.04506 ) );
        BigDecimal  rmLongitude=longitude.subtract(BigDecimal.valueOf( 0.065172 ) );
        
        StringBuilder request=new StringBuilder();
        request.append( Hairdresser.getHairSearchRequest() );

        GenericJob test= SpringFactory.getGenericJob();
      
        
            request.append(" LEFT OUTER JOIN Service_Hairdresser Service_Hairdresser ON hairdresser.hairId=Service_Hairdresser.hairId"
                    +" LEFT OUTER JOIN Service Service ON Service_Hairdresser.servId=Service.servId"
                    + " WHERE buisness.buisLongitude BETWEEN "+rmLongitude+" AND "+ addLongitudee
                    +" AND  buisness.buisLatitude BETWEEN "+rmLatitude+" AND "+addLatitudee ); 
            
    
        
        if(!isNullOrEmpty(service)){
            
            request.append(" AND Service.servName LIKE\""+service+"%\"");
                   
           
        }
           

        
        if(!isNullOrEmpty(salonOrStylist)){
            request.append(" AND (buisness.buisname LIKE \"%"+salonOrStylist+"%\" OR hairdresser.hairlastname LIKE \"%"+salonOrStylist+"%\")");
        }
        
       
    
        List<String> result=test.getList( request.toString(), null, 0, 10 );
        return Response.ok().entity( serialize(result)).build();
       }catch(Exception ex){
           
           logger.error( ex.getStackTrace()[0].getMethodName(),ex);
           return Response.serverError().entity(ex.toString()).build();
       }

    }
    
    public String mapper(Object object,Match match){
        
        
      
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(JsonView.class, new JsonViewSerializer());
        mapper.registerModule(module);
        
        
        String json=null;
       try {
           json= mapper.writeValueAsString(JsonView.with(object).onClass(object.getClass(),match));
       } catch ( JsonProcessingException e ) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return json;
    }
    
    private static String serialize(Object object) throws JsonProcessingException {
        String serialized = null;
        ObjectMapper mapper = new ObjectMapper();
        serialized = mapper.writeValueAsString(object);
        return serialized;
    }   
    
    private boolean  isNullOrEmpty(Object object) throws JsonProcessingException {
       if(object==null)
           return true;
       if (object instanceof String)
       {
           String st=(String) object;
           return st.equals( "" );
       }
           
        return false;
    }  
}
