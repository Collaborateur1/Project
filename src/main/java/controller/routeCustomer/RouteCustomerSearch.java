package controller.routeCustomer;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;

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
    @javax.annotation.security.PermitAll
    @GET
    @Produces( MediaType.APPLICATION_JSON)
    public Response search( @QueryParam( value = "service" ) String service,
            @QueryParam( value = "salonOrStylist" ) String salonOrStylist,
            @QueryParam( value = "location" ) String location,
            @QueryParam( value = "date" ) Date date) throws URISyntaxException, JsonProcessingException {
                
      
        
        StringBuilder request=new StringBuilder();
        request.append( Hairdresser.getHairSearchRequest() );
        
        
        
        GenericJob test= SpringFactory.getGenericJob();
        String[][] chaine1;
        String[][] chaine2;
       
        //Or where hairFirstName=value or hairLastName=value ..
        Junction restric= Restrictions.disjunction()
        .add(Restrictions.eq("hairFirstName", salonOrStylist))
        .add(Restrictions.eq("hairLastName", salonOrStylist))
        .add(Restrictions.eq("hairBuisness.buisName", salonOrStylist));
        
        if(location==null)
            location="";
        
        
        if(!"".equals(service)&&service!=null){
            
            request.append(" LEFT OUTER JOIN Service_Hairdresser Service_Hairdresser ON hairdresser.hairId=Service_Hairdresser.hairId"
                    +" LEFT OUTER JOIN Service Service ON Service_Hairdresser.servId=Service.servId"
                    + " WHERE buisness.buiszipcode LIKE \""+location+"%\""+
                    "AND Service.servName LIKE\""+service+"%\"");
            

         
        }else
        {
            request.append(" WHERE buisness.buiszipcode like \""+location+"%\"");
           
        }
        
        
        if(!"".equals(salonOrStylist)&&salonOrStylist!=null){
            request.append(" AND (buisness.buisname LIKE \"%"+salonOrStylist+"%\" OR hairdresser.hairlastname LIKE \"%"+salonOrStylist+"%\")");
        }
        
       
        
     /*   chaine1= new String[][]{{"hairBuisness","hairBuisness"}};
        chaine2= new String[][]{{"hairBuisness.buisZipCode","=",location.trim()}};
        
        chaine1= new String[][]{{"hairBuisness","hairBuisness"},{"hairServices","hairServices"}}; 
        chaine2= new String[][]{{"hairBuisness.buisZipCode","=",location.trim()},{"hairServices.servName","like",service}}; 
        List<String> result= test.getList( Hairdresser.class, 
                chaine1, //alias (left join)
                chaine2,// where
                null,
                new String[][]{{"PROPERTY","hairId"},{"PROPERTY","hairFirstName"},{"PROPERTY","hairLastName"}, //select
            {"PROPERTY","hairPict"},{"PROPERTY","hairZipCode"},{"PROPERTY","hairBuisness.buisName"}
            ,{"PROPERTY","hairBuisness.buisAdress1"},{"PROPERTY","hairBuisness.buisAdress2"}
            ,{"PROPERTY","hairBuisness.buisZipCode"}}
            ,-1
            ,5);*/
        List<String> result=test.getList( request.toString(), null, 0, 10 );
        return Response.ok().entity( serialize(result)).build();

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
}
