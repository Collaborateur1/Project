package controller.route;

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

import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.bean.Attachment;
import model.bean.Buisness;
import model.bean.BuisnessType;
import model.bean.DefaultCustomer;
import model.bean.Hairdresser;
import model.bean.Schedule;
import model.bean.Service;
import model.bean.Tag;
import model.custom.CustomerCustom;
import model.custom.EnterpriseCustom;
import model.custom.UserCustom;
import model.job.GenericJob;
import other.SpringFactory;



@Controller
@Path( "/public" )
public class RoutePublicAccess {



    @javax.annotation.security.PermitAll
    @GET
    @Path("/login")
    public Response get(@QueryParam(value = "fowardTo") String foward) {
      
        
      
        
        try {
            
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            return Response.ok( SpringFactory.getHandlebarsManager().getTemplate( "login" ).apply(foward)).cookie( new NewCookie( "cookie",randomUUIDString  ) ).header("test", "wopapa" ).build();
           
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
    public Response getTest(@QueryParam( value = "mail" ) String mail) throws JsonProcessingException {
        voidAdd100hairdresser();
        
        GenericJob test= SpringFactory.getGenericJob();
        //List<String> result= test.getList( UserCustom.class,null,new String[][]{{"nom","like","magkilapuls"}}, null, null);
        
       // List<String> result= test.getList( Hairdresser.class, null,null, null, new String[][]{{"PROPERTY","hairFirstName"}},10000,-1);
      //  List<Hairdresser>result= test.getListObjectV1( Hairdresser.class, new String[][]{{"service.servManager","=","true"}},new String[][]{{"hairServices","service"}});
       // List<Hairdresser>result= test.getListObjectV1( Hairdresser.class, null,null);
        //List<String> result= test.getList( Hairdresser.class,  new String[][]{{"hairAttachmentHairdressers","attachment"}},null, null, new String[][]{{"PROPERTY","hairLastName"},{"PROPERTY","attachment.attaType"}},10000,-1);
       
       // List<Hairdresser>result= test.getListObjectV1( Hairdresser.class, 
        //                                              new String[][]{{"service.servManager","=B","true"}},
         //                                             new String[][]{{"hairServices","service"}});
        List<Hairdresser>result= test.getListObjectV1( Hairdresser.class, 
                                                           null,
                                                             null);
      
        
        /*
       
        voidAdd100Person();
        voidAdd100Person();
        voidAdd200Dossier();
         
        voidAdd100Enterprise();
       
       
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
        
        return Response.ok().entity( serialize(result.get( 0 ))).build();
    }
    
    public RoutePublicAccess() {
        super();
        // TODO Auto-generated constructor stub
    }


    public void voidAdd100hairdresser(){
        
        GenericJob test= SpringFactory.getGenericJob();
        for (int i=0;i<10;i++){
            Hairdresser hairdresser=new Hairdresser();
            hairdresser.setHairBirthDate( new Date() );
            hairdresser.setHairFirstName ("sfsfsdfdsfsdfsdf" );
            hairdresser.setHairEmail( UUID.randomUUID().toString() );
            hairdresser.setHairIsActif( true);
            hairdresser.setHairLastName( "qsqdqsdqsdqs" );
            
            
            List<Service> list= new ArrayList();
            
            Service serv= new Service();
            Service serv2= new Service();
            serv.setServDesciption(  UUID.randomUUID().toString() );
            serv.setServName( "nameserv1" );
            serv.setServManager( i==1 );
            test.createObject(serv);
            list.add( serv );
           
            serv2.setServDesciption(  UUID.randomUUID().toString() );
            serv2.setServName(  "service"+i );
            serv2.setServManager( i==2 );
            list.add( serv2 );
            test.createObject(serv2);
            hairdresser.setHairServices( list );
            
            Attachment atta= new Attachment();
            Attachment atta2= new Attachment();
            atta.setAttaType( "png" );
            atta.setAttaUrl( UUID.randomUUID().toString() );
            
            atta2.setAttaType( "usd" );
            atta2.setAttaUrl(  UUID.randomUUID().toString() );
            
            List<Attachment> list2= new ArrayList();
            list2.add( atta );
            list2.add( atta2 );
          
            List<Schedule> list3= new ArrayList();
            Schedule sche= new Schedule();
            sche.setScheDate( new Date() );
            sche.setScheName( "namehahaha" );
            list3.add( sche );
            sche.setScheHairdresser( hairdresser );
          //  test.createObject( sche );
            hairdresser.setHairSchedules( list3 );
            
            
            hairdresser.setHairAttachmentHairdressers( list2 );
            
            
            
            test.createObject( hairdresser );
            
            
            
            
            
        }
        
        List<Hairdresser>result= test.getListObjectV1( Hairdresser.class, 
                                                            new String[][]{{"service.servManager","=B","true"}},
                                                            new String[][]{{"hairServices","service"}});
        for(int i=0;i<2;i++){
            
            Buisness biz= new Buisness();
            BuisnessType bizt= new BuisnessType();
            
            bizt.setBuisTypeName( "Salon" );
            biz.setBuisName(  UUID.randomUUID().toString() );
            biz.setBuisZipCode( "3100"+i);
            biz.setBuisBuisType( bizt );
            biz.setBuisConfirmation( false );
            biz.setBuisDescription( UUID.randomUUID().toString()  );
            
result.get(i).setHairBuisness( biz );
            biz.setBuisHairdressers( result );
            Tag tg= new Tag();
            tg.setTagName( "myCompany"+i );
            List<Tag> list4= new ArrayList(); 
            
            test.createObject( bizt );
            
            list4.add( tg );
            Attachment atta= new Attachment();
            atta.setAttaType( "zip" );
            atta.setAttaUrl( UUID.randomUUID().toString() );
            
            List<Attachment> list2= new ArrayList();
            list2.add( atta );
            
            biz.setBuisAttachmentBuisness( list2 );
        biz.setBuisTags( list4 );
        test.updateObject( biz );
  
        }
        
        
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
        List<HashMap> result= test.getList( UserCustom.class, null,null, null, new String[][]{{"PROPERTY","id"}},-1,20);
        for (int i=0;i<result.size();i++){
            String id="";
             id=result.get( i ).get( "id" ).toString();
             
            /*
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
            */
            
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
        
   private static String serialize(Object object) throws JsonProcessingException {
       String serialized = null;
       ObjectMapper mapper = new ObjectMapper();
       serialized = mapper.writeValueAsString(object);
       return serialized;
   }      
    
}
