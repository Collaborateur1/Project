package controller.route;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.bean.Appointment;
import model.bean.Availability;
import model.bean.Buisness;
import model.bean.BuisnessType;
import model.bean.Custumer;
import model.bean.Hairdresser;
import model.bean.Schedule;
import model.bean.ScheduleDay;
import model.bean.Service;
import model.job.GenericJob;
import other.SpringFactory;



@Controller
@Path( "/public" )
public class RoutePublicAccess {
    
    
    @javax.annotation.security.PermitAll
    @GET
    @Path("/test")
    @Produces( MediaType.APPLICATION_JSON )
    public Response getTest(@QueryParam( value = "mail" ) String mail) throws JsonProcessingException,Exception {
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
                                                           null,null,
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


    public void voidAdd20hairdresserAnd10busness() throws Exception{
        
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
            test.updateObject( hairdresser );
            voidAddschedule(hairdresser);
         
            Buisness biz= new Buisness();
            BuisnessType bizt= new BuisnessType();
            
            bizt.setBuisTypeName( "Salon" );
            biz.setBuisName( "Bernas coiffure");
            biz.setBuisAdress1("Livry-Gargan");
            biz.setBuisZipCode( "93190");
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
              biz.setBuisAdress1( "12 Rue de Laghouat" );
              biz.setBuisZipCode( "75018");
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
                    biz.setBuisZipCode( "92220");
                    biz.setBuisAdress1( "22 Rue Salvador Allende Bagneux" );
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
                     biz.setBuisAdress1( "1 Chemin de Mezouls À Bosc-Viel" );
                     biz.setBuisAdress2( "Mauguio" );
                     biz.setBuisZipCode( "34130");
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
    
    public void voidAddschedule( Hairdresser hairdresser)throws Exception{
        
        
        GenericJob service= SpringFactory.getGenericJob();
        if(hairdresser==null)
           
        if(hairdresser.getHairId()==null)
            return;
        
        
        List<Schedule> schedules= new ArrayList();
        Schedule schedule= new Schedule();
        schedule.setScheName( "sche"+hairdresser.getHairId().substring(10) );
        schedules.add( schedule );
        schedule.setScheHairdresser( hairdresser );
        hairdresser.setHairSchedules( schedules );
        
        service.updateObject( hairdresser );
        
        List<ScheduleDay> listScheDay= new ArrayList();
        List<Availability> listAva= null;
        ScheduleDay scheduleDay;
        
        for(int i=0;i<7;i++){
            listAva=new ArrayList();
            scheduleDay= new ScheduleDay();
            scheduleDay.setScheDay(i+1);
            scheduleDay.setScheDaySchedule( schedule );  
            service.updateObject( scheduleDay );
            
            
            Availability availability= new Availability();
            availability.setavaiStartDate( DateTime.now().plusMinutes( i+1 ) );
            availability.setavaiEndDate( DateTime.now().plusMinutes( 10*(i+1) ) );
            availability.setavaiScheduleDay( scheduleDay );
            service.createObject( availability );
            listAva.add(availability );
            
            
            
            
            availability= new Availability();
            availability.setavaiStartDate( DateTime.now().plusMinutes(11*(i+1) ) );
            availability.setavaiEndDate( DateTime.now().plusMinutes( 12*(i+1) ) );
            availability.setavaiScheduleDay( scheduleDay );
            service.createObject( availability );
            
            listAva.add(availability );
            
            //delete to see
           // scheduleDay.setScheDayAvailability( listAva );
            
            listScheDay.add( scheduleDay );
            
            
        }
        schedule.setScheScheDays( listScheDay );
        service.updateObject( schedule );
        voidAddAppointment( hairdresser);
    }
    
    public void voidAddAppointment( Hairdresser hairdresser)throws Exception{
        GenericJob service= SpringFactory.getGenericJob();
        if(hairdresser==null)
            
            if(hairdresser.getHairId()==null)
                return;
        
        
        Service serviceSnap=(Service) service.getListObjectV1( Service.class, null, null, null ).get( 0 );
        Custumer custumer= new Custumer(); 
        custumer.setCustFirstName( UUID.randomUUID().toString().substring( 15 ) );
        custumer.setCustLastName( UUID.randomUUID().toString().substring( 15 ));
        custumer.setCustEmail("test@test.com");
        service.createObject( custumer );
        Appointment appointment = new Appointment();
        appointment.setAppoService( serviceSnap );
        appointment.setAppoHairdresser( hairdresser );
        appointment.setAppoCustumer( custumer );
        service.createObject( appointment );
        
        
    }
    
 
    

        
   private static String serialize(Object object) throws JsonProcessingException {
       String serialized = null;
       ObjectMapper mapper = new ObjectMapper();
       serialized = mapper.writeValueAsString(object);
       return serialized;
   }      
    
}
