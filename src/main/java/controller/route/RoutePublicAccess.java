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

import model.bean.Buisness;
import model.bean.BuisnessType;
import model.bean.DefaultCustomer;
import model.bean.Hairdresser;
import model.bean.Service;
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
        voidAdd20hairdresserAnd10busness();
        
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


    public void voidAdd20hairdresserAnd10busness(){
        
        GenericJob test= SpringFactory.getGenericJob();
       
           
        
        
        //1
        
            Hairdresser hairdresser=new Hairdresser();
            hairdresser.setHairBirthDate( new Date() );
            hairdresser.setHairFirstName ("albert" );
            hairdresser.setHairEmail( UUID.randomUUID().toString() );
            hairdresser.setHairIsActif( true);
            hairdresser.setHairLastName( "jean Francois" );
            
            
            List<Service> list= new ArrayList();
            
            Service serv= new Service();
            Service serv2= new Service();
            serv.setServDesciption(  UUID.randomUUID().toString() );
            serv.setServName( "coiffure" );
            serv.setServManager( true);
            test.createObject(serv);
            list.add( serv );
           
            serv2.setServDesciption(  UUID.randomUUID().toString() );
            serv2.setServName(  "autre" );
            serv2.setServManager( false);
            list.add( serv2 );
            test.createObject(serv2);
            hairdresser.setHairServices( list );
            test.createObject( hairdresser );
            
            
            
            Buisness biz= new Buisness();
            BuisnessType bizt= new BuisnessType();
            
            bizt.setBuisTypeName( "Salon" );
            biz.setBuisName( "Bernas coiffure");
            biz.setBuisZipCode( "75018");
            biz.setBuisBuisType( bizt );
            biz.setBuisConfirmation( false );
            biz.setBuisDescription( UUID.randomUUID().toString()  );
            biz.setBuisLatitude( 48.922499  );
            biz.setBuisLongitude(2.557068);
            hairdresser.setHairBuisness( biz );
            test.createObject( bizt );
            test.updateObject( biz );
            test.updateObject( hairdresser );
            
            
           
           
            
            
            
            //2
           hairdresser=new Hairdresser();
            hairdresser.setHairBirthDate( new Date() );
            hairdresser.setHairFirstName ("albert" );
            hairdresser.setHairEmail( UUID.randomUUID().toString() );
            hairdresser.setHairIsActif( true);
            hairdresser.setHairLastName( "jean Francois" );
            
            
            list= new ArrayList();
            
            serv= new Service();
             serv2= new Service();
            serv.setServDesciption(  UUID.randomUUID().toString() );
            serv.setServName( "shampoing" );
            serv.setServManager( true);
            test.createObject(serv);
            list.add( serv );
           
            serv2.setServDesciption(  UUID.randomUUID().toString() );
            serv2.setServName(  "défrisage" );
            serv2.setServManager( false);
            list.add( serv2 );
            test.createObject(serv2);
            hairdresser.setHairServices( list );
            hairdresser.setHairBuisness( biz );
            test.createObject( hairdresser );
            
            
            
            
            
            
            //3
            hairdresser=new Hairdresser();
             hairdresser.setHairBirthDate( new Date() );
             hairdresser.setHairFirstName ("guillaume" );
             hairdresser.setHairEmail( UUID.randomUUID().toString() );
             hairdresser.setHairIsActif( true);
             hairdresser.setHairLastName( "zilbertu" );
            
             
             
             list= new ArrayList();
             
             serv= new Service();
              serv2= new Service();
             serv.setServDesciption(  UUID.randomUUID().toString() );
             serv.setServName( "rasage" );
             serv.setServManager( true);
             test.createObject(serv);
             list.add( serv );
            
             serv2.setServDesciption(  UUID.randomUUID().toString() );
             serv2.setServName(  "contour" );
             serv2.setServManager( false);
             list.add( serv2 );
             test.createObject(serv2);
             hairdresser.setHairServices( list );
             test.createObject( hairdresser );
             
              biz= new Buisness();
              bizt= new BuisnessType();
             bizt.setBuisTypeName( "Salon2" );
             biz.setBuisName( "Cabinet Lesne-Bernat  coiffure");
             biz.setBuisZipCode( "75007");
             biz.setBuisBuisType( bizt );
             biz.setBuisConfirmation( false );
             biz.setBuisDescription( UUID.randomUUID().toString()  );
             hairdresser.setHairBuisness( biz );
             test.createObject( bizt );
             test.updateObject( biz );
             test.updateObject( hairdresser );
             
             //4
             hairdresser=new Hairdresser();
              hairdresser.setHairBirthDate( new Date() );
              hairdresser.setHairFirstName ("Nicolas" );
              hairdresser.setHairEmail( UUID.randomUUID().toString() );
              hairdresser.setHairIsActif( true);
              hairdresser.setHairLastName( "Pierre charle" );
              
              
              list= new ArrayList();
              
              serv= new Service();
               serv2= new Service();
              serv.setServDesciption(  UUID.randomUUID().toString() );
              serv.setServName( "react coiffure" );
              serv.setServManager( true);
              test.createObject(serv);
              list.add( serv );
             
              serv2.setServDesciption(  UUID.randomUUID().toString() );
              serv2.setServName(  "javascript barber" );
              serv2.setServManager( false);
              list.add( serv2 );
              test.createObject(serv2);
              hairdresser.setHairServices( list );
              test.createObject( hairdresser );
              
              
              hairdresser.setHairBuisness( biz );
              test.updateObject( hairdresser );
              
              
              //5
              hairdresser=new Hairdresser();
               hairdresser.setHairBirthDate( new Date() );
               hairdresser.setHairFirstName ("gigi" );
               hairdresser.setHairEmail( UUID.randomUUID().toString() );
               hairdresser.setHairIsActif( true);
               hairdresser.setHairLastName( "stessie" );
               
               
               list= new ArrayList();
               
               serv= new Service();
                serv2= new Service();
               serv.setServDesciption(  UUID.randomUUID().toString() );
               serv.setServName( "coiffure" );
               serv.setServManager( true);
               test.createObject(serv);
               list.add( serv );
              
               serv2.setServDesciption(  UUID.randomUUID().toString() );
               serv2.setServName("autre");
               serv2.setServManager( false);
               list.add( serv2 );
               test.createObject(serv2);
               hairdresser.setHairServices( list );
               test.createObject( hairdresser );
               
               
               
               biz= new Buisness();
               bizt= new BuisnessType();
              bizt.setBuisTypeName( "Salon2" );
              biz.setBuisName( " Bernat Denis coiffure");
              biz.setBuisZipCode( "92310");
              biz.setBuisBuisType( bizt );
              biz.setBuisConfirmation( false );
              biz.setBuisDescription( UUID.randomUUID().toString()  );
              biz.setBuisLatitude( 48.888198  );
              biz.setBuisLongitude(2.355194);
              hairdresser.setHairBuisness( biz );
              test.createObject( bizt );
              test.updateObject( biz );
              test.updateObject( hairdresser );
               
               
               //6
               hairdresser=new Hairdresser();
                hairdresser.setHairBirthDate( new Date() );
                hairdresser.setHairFirstName ("dimitri" );
                hairdresser.setHairEmail( UUID.randomUUID().toString() );
                hairdresser.setHairIsActif( true);
                hairdresser.setHairLastName( "locadore" );
                
                
                list= new ArrayList();
                
                serv= new Service();
                 serv2= new Service();
                serv.setServDesciption(  UUID.randomUUID().toString() );
                serv.setServName( "boule a zero" );
                serv.setServManager( true);
                test.createObject(serv);
                list.add( serv );
               
                serv2.setServDesciption(  UUID.randomUUID().toString() );
                serv2.setServName(  "épilation" );
                serv2.setServManager( false);
                list.add( serv2 );
                test.createObject(serv2);
                hairdresser.setHairServices( list );
                test.createObject( hairdresser );
                
                hairdresser.setHairBuisness( biz );
                test.updateObject( hairdresser );
                
                
                //7
                hairdresser=new Hairdresser();
                 hairdresser.setHairBirthDate( new Date() );
                 hairdresser.setHairFirstName ("pulsi" );
                 hairdresser.setHairEmail( UUID.randomUUID().toString() );
                 hairdresser.setHairIsActif( true);
                 hairdresser.setHairLastName( "el bad boy" );
                 
                 
                 list= new ArrayList();
                 
                 serv= new Service();
                  serv2= new Service();
                 serv.setServDesciption(  UUID.randomUUID().toString() );
                 serv.setServName( "curle" );
                 serv.setServManager( true);
                 test.createObject(serv);
                 list.add( serv );
                
                 serv2.setServDesciption(  UUID.randomUUID().toString() );
                 serv2.setServName(  "défrisage" );
                 serv2.setServManager( false);
                 list.add( serv2 );
                 test.createObject(serv2);
                 hairdresser.setHairServices( list );
                 test.createObject( hairdresser );
                 
                 hairdresser.setHairBuisness( biz );
                 test.updateObject( hairdresser );
                 
                 
                 //8
                 hairdresser=new Hairdresser();
                  hairdresser.setHairBirthDate( new Date() );
                  hairdresser.setHairFirstName ("béatrice" );
                  hairdresser.setHairEmail( UUID.randomUUID().toString() );
                  hairdresser.setHairIsActif( true);
                  hairdresser.setHairLastName( "péroné" );
                  
                  
                  list= new ArrayList();
                  
                  serv= new Service();
                   serv2= new Service();
                  serv.setServDesciption(  UUID.randomUUID().toString() );
                  serv.setServName( "snapCoupe" );
                  serv.setServManager( true);
                  test.createObject(serv);
                  list.add( serv );
                 
                  serv2.setServDesciption(  UUID.randomUUID().toString() );
                  serv2.setServName(  "instabarbe" );
                  serv2.setServManager( false);
                  list.add( serv2 );
                  test.createObject(serv2);
                  hairdresser.setHairServices( list );
                  test.createObject( hairdresser );
                  
                  hairdresser.setHairBuisness( biz );
                  test.updateObject( hairdresser );
                  
                  
                  //9
                  hairdresser=new Hairdresser();
                   hairdresser.setHairBirthDate( new Date() );
                   hairdresser.setHairFirstName ("anais" );
                   hairdresser.setHairEmail( UUID.randomUUID().toString() );
                   hairdresser.setHairIsActif( true);
                   hairdresser.setHairLastName( "jean charle" );
                   
                   
                   list= new ArrayList();
                   
                   serv= new Service();
                    serv2= new Service();
                   serv.setServDesciption(  UUID.randomUUID().toString() );
                   serv.setServName( "improvisation" );
                   serv.setServManager( true);
                   test.createObject(serv);
                   list.add( serv );
                  
                   serv2.setServDesciption(  UUID.randomUUID().toString() );
                   serv2.setServName(  "coupe femme" );
                   serv2.setServManager( false);
                   list.add( serv2 );
                   test.createObject(serv2);
                   hairdresser.setHairServices( list );
                   test.createObject( hairdresser );
                   
                   hairdresser.setHairBuisness( biz );
                   test.updateObject( hairdresser );
                   
                   
                   //10
                   hairdresser=new Hairdresser();
                    hairdresser.setHairBirthDate( new Date() );
                    hairdresser.setHairFirstName ("lolita" );
                    hairdresser.setHairEmail( UUID.randomUUID().toString() );
                    hairdresser.setHairIsActif( true);
                    hairdresser.setHairLastName( "elPédro" );
                    
                    
                    list= new ArrayList();
                    
                    serv= new Service();
                     serv2= new Service();
                    serv.setServDesciption(  UUID.randomUUID().toString() );
                    serv.setServName( "lissage" );
                    serv.setServManager( true);
                    test.createObject(serv);
                    list.add( serv );
                   
                    serv2.setServDesciption(  UUID.randomUUID().toString() );
                    serv2.setServName(  "coloration" );
                    serv2.setServManager( false);
                    list.add( serv2 );
                    test.createObject(serv2);
                    hairdresser.setHairServices( list );
                    test.createObject( hairdresser );
                    
                    
                    
                    
                    //11
                    hairdresser=new Hairdresser();
                     hairdresser.setHairBirthDate( new Date() );
                     hairdresser.setHairFirstName ("donavane" );
                     hairdresser.setHairEmail( UUID.randomUUID().toString() );
                     hairdresser.setHairIsActif( true);
                     hairdresser.setHairLastName( "dubois" );
                     
                     
                     list= new ArrayList();
                     
                     serv= new Service();
                      serv2= new Service();
                     serv.setServDesciption(  UUID.randomUUID().toString() );
                     serv.setServName( "curly" );
                     serv.setServManager( true);
                     test.createObject(serv);
                     list.add( serv );
                    
                     serv2.setServDesciption(  UUID.randomUUID().toString() );
                     serv2.setServName(  "autre" );
                     serv2.setServManager( false);
                     list.add( serv2 );
                     test.createObject(serv2);
                     hairdresser.setHairServices( list );
                     test.createObject( hairdresser );
                     
                     biz= new Buisness();
                     bizt= new BuisnessType();
                    bizt.setBuisTypeName( "Salon2" );
                    biz.setBuisName( "Philippe Bernard");
                    biz.setBuisZipCode( "92500");
                    biz.setBuisBuisType( bizt );
                    biz.setBuisConfirmation( false );
                    biz.setBuisDescription( UUID.randomUUID().toString()  );
                    biz.setBuisLatitude( 48.796009  );
                    biz.setBuisLongitude(2.300262);
                    hairdresser.setHairBuisness( biz );
                    test.createObject( bizt );
                    test.updateObject( biz );
                    test.updateObject( hairdresser );
                     
                     
                     //12
                     hairdresser=new Hairdresser();
                      hairdresser.setHairBirthDate( new Date() );
                      hairdresser.setHairFirstName ("JEE" );
                      hairdresser.setHairEmail( UUID.randomUUID().toString() );
                      hairdresser.setHairIsActif( true);
                      hairdresser.setHairLastName( "Java" );
                      
                      
                      list= new ArrayList();
                      
                      serv= new Service();
                       serv2= new Service();
                      serv.setServDesciption(  UUID.randomUUID().toString() );
                      serv.setServName( "reference" );
                      serv.setServManager( true);
                      test.createObject(serv);
                      list.add( serv );
                     
                      serv2.setServDesciption(  UUID.randomUUID().toString() );
                      serv2.setServName(  "objet" );
                      serv2.setServManager( false);
                      list.add( serv2 );
                      test.createObject(serv2);
                      hairdresser.setHairServices( list );
                      test.createObject( hairdresser );
                      
                      biz= new Buisness();
                      bizt= new BuisnessType();
                     bizt.setBuisTypeName( "Salon2" );
                     biz.setBuisName( " Artisan Bernard  coiffure");
                     biz.setBuisZipCode( "92100");
                     biz.setBuisBuisType( bizt );
                     biz.setBuisConfirmation( false );
                     biz.setBuisDescription( UUID.randomUUID().toString()  );
                     biz.setBuisLatitude( 43.604262  );
                     biz.setBuisLongitude(3.99353);
                     hairdresser.setHairBuisness( biz );
                     test.createObject( bizt );
                     test.updateObject( biz );
                     test.updateObject( hairdresser );
                      
                      
                      //13
                      hairdresser=new Hairdresser();
                       hairdresser.setHairBirthDate( new Date() );
                       hairdresser.setHairFirstName ("rudolpho" );
                       hairdresser.setHairEmail( UUID.randomUUID().toString() );
                       hairdresser.setHairIsActif( true);
                       hairdresser.setHairLastName( "marie louis" );
                       
                       
                       list= new ArrayList();
                       
                       serv= new Service();
                        serv2= new Service();
                       serv.setServDesciption(  UUID.randomUUID().toString() );
                       serv.setServName( "style" );
                       serv.setServManager( true);
                       test.createObject(serv);
                       list.add( serv );
                      
                       serv2.setServDesciption(  UUID.randomUUID().toString() );
                       serv2.setServName(  "autre" );
                       serv2.setServManager( false);
                       list.add( serv2 );
                       test.createObject(serv2);
                       hairdresser.setHairServices( list );
                       test.createObject( hairdresser );
                       
                       hairdresser.setHairBuisness( biz );
                       test.updateObject( hairdresser );
                       
                       //14
                       hairdresser=new Hairdresser();
                        hairdresser.setHairBirthDate( new Date() );
                        hairdresser.setHairFirstName ("stephanie" );
                        hairdresser.setHairEmail( UUID.randomUUID().toString() );
                        hairdresser.setHairIsActif( true);
                        hairdresser.setHairLastName( "locidor" );
                        
                        
                        list= new ArrayList();
                        
                        serv= new Service();
                         serv2= new Service();
                        serv.setServDesciption(  UUID.randomUUID().toString() );
                        serv.setServName( "décoloration" );
                        serv.setServManager( true);
                        test.createObject(serv);
                        list.add( serv );
                       
                        serv2.setServDesciption(  UUID.randomUUID().toString() );
                        serv2.setServName(  "chignon" );
                        serv2.setServManager( false);
                        list.add( serv2 );
                        test.createObject(serv2);
                        hairdresser.setHairServices( list );
                        test.createObject( hairdresser );
                        
                        hairdresser.setHairBuisness( biz );
                        test.updateObject( hairdresser );
                        
                        //15
                        hairdresser=new Hairdresser();
                         hairdresser.setHairBirthDate( new Date() );
                         hairdresser.setHairFirstName ("jerry" );
                         hairdresser.setHairEmail( UUID.randomUUID().toString() );
                         hairdresser.setHairIsActif( true);
                         hairdresser.setHairLastName( "insore" );
                         
                         
                         list= new ArrayList();
                         
                         serv= new Service();
                          serv2= new Service();
                         serv.setServDesciption(  UUID.randomUUID().toString() );
                         serv.setServName( "barbe" );
                         serv.setServManager( true);
                         test.createObject(serv);
                         list.add( serv );
                        
                         serv2.setServDesciption(  UUID.randomUUID().toString() );
                         serv2.setServName(  "sourcil" );
                         serv2.setServManager( false);
                         list.add( serv2 );
                         test.createObject(serv2);
                         hairdresser.setHairServices( list );
                         test.createObject( hairdresser );
                         
                         hairdresser.setHairBuisness( biz );
                         test.updateObject( hairdresser );
      
        
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
