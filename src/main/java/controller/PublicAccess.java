package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.sun.jersey.api.view.Viewable;

import model.bean.DefaultCustomer;
import model.custom.CustomerCustom;
import model.custom.DossierCustom;
import model.custom.EnterpriseCustom;
import model.custom.UserCustom;
import model.job.GenericJob;
import other.SpringFactory;
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
    
    @javax.annotation.security.PermitAll
    @GET
    @Path("/test")
    @Produces( MediaType.APPLICATION_JSON )
    public Response get() throws JsonProcessingException {
      
      
        GenericJob test= SpringFactory.getGenericJob();
        voidAdd100Person();
        voidAdd100Person();
        voidAdd200Dossier();
         
        voidAdd100Enterprise();
        DossierCustom dossier=(DossierCustom) test.getObject( DossierCustom.class,"1",false);
       
        //test.loadLazyCollection( user );
        /*
       List<String> result= test.getList( UserCustom.class, new String[][]{{"userDossier","dossier"}},new String[][]{{"dossier.dossierHistory","=","ae97d5d9-cafe-45bc-83c7-51c74dd501f3"}}, null, new String[][]{{"PROPERTY","email"},{"PROPERTY","nom"},{"PROPERTY","prenom"},{"PROPERTY","dossier.dossierHistory"}},10000,-1);
       // List<String> result= test.getList( UserCustom.class,null,new String[][]{{"nom","like","magkilapuls"}}, null, null);
       return Response.ok().entity( result).build();
      
      
        voidAdd100Person();
        voidAdd100Person();
        voidAdd200Dossier();
         
        voidAdd100Enterprise();
          
        */
        
        return Response.ok().entity( dossier).build();
    }
    
    
    public void voidAdd100Person(){
       
        GenericJob test= SpringFactory.getGenericJob();
        for (int i=0;i<10;i++){
            UserCustom user=new UserCustom();
            user.setDusName( UUID.randomUUID().toString() );
            user.setDusSurname( UUID.randomUUID().toString() );
            user.setDusAddress( UUID.randomUUID().toString() );
            user.setDusEmail(UUID.randomUUID().toString()+"@msn.com");
            user.setDusMdp( "123456789".getBytes().toString() );
            user.setDusNumber( UUID.randomUUID().toString());
            user.setDusToken( UUID.randomUUID().toString() );
            test.createObject( user );
            
        }
        
    }
    
    public void voidAdd200Dossier(){
        
        
        GenericJob test= SpringFactory.getGenericJob();
        List<HashMap> result= test.getList( UserCustom.class, null,null, null, new String[][]{{"PROPERTY","id"}},20,-1);
        for (int i=0;i<result.size();i++){
            String id="";
             id=result.get( i ).get( "id" ).toString();
             
            
            DossierCustom dossier=new DossierCustom();
            dossier.setDosCreation( new Date() );
            UserCustom testt=(UserCustom)test.getObject( UserCustom.class, id ,false);
           
            dossier.setDosCreator( testt);
            dossier.setDosHistory( UUID.randomUUID().toString() );
            test.createObject( dossier );
            ArrayList arr= new ArrayList();
            arr.add( dossier );
            testt.setDusDossier( arr );
            test.updateObject(testt);
            
        }
        
    }
    
   public void voidAdd100Enterprise(){
        
        
       GenericJob test= SpringFactory.getGenericJob();
       for (int i=0;i<100;i++){
           EnterpriseCustom ent=new EnterpriseCustom();
           ent.setEntBirth( new Date() );
           ent.setEntName( UUID.randomUUID().toString() );
           ent.setEntUpdate(new Date() );
      
           
           CustomerCustom cust=new CustomerCustom();
           cust.setCusBith( new Date() );
           cust.setCusCivility( DefaultCustomer.civility.Mr.toString());
           cust.setCusFirstName( UUID.randomUUID().toString() );
           cust.setCusMail( UUID.randomUUID().toString() );
           cust.setCusNumber( UUID.randomUUID().toString() );
           ArrayList arr= new ArrayList();
           arr.add( cust );
        
           ent.setEntCustomers( arr );
           test.createObject(cust ); 
           test.createObject(ent );
           
     
           
       }
       
      
            
        }
        
       
    
}
