package model.job;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.custom.UserCustom;
import model.dao.InterfaceUserDao;
import model.webappStat.WebAppStatistique;



@Service("userJob")
public class UserJobImpl implements UserJob{
    public static final String  CHAMP_PRENOM    = "prenom";
    public static final String  CHAMP_ADRESSE   = "adresseClient";
    public static final String  CHAMP_TELEPHONE = "telephoneClient";

    /*à automatiser car sa doit etre paramétrable depuis l'extérieur*/
    private String              UserEnvironement="/fichiers/";
    private String              prefixDir                 = "C:";
    private static Logger logger = Logger.getLogger( UserJobImpl.class);
    
    
    @Autowired(required=true)
    WebAppStatistique statistique;
    
    @Autowired(required=true)
    private InterfaceUserDao userDao;
    
    


    
    public  synchronized boolean ValidateAndCreateUser(String lastName, String firstName, String email, String tel, String mdp,String adresse) throws Exception
    {
        

        /*
         * 
         * Création du bean Client et initialisation avec les données récupérées
         * 
         */ 
        UserCustom user=new UserCustom();
       
        try {
            CheckEmail( email );
            user.setDusEmail( email );
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
          //  erreurs.put( CHAMP_EMAIL, e.getMessage() );
            
            throw new Exception(e.getMessage());
            
        }

        try {
            CheckName( lastName );
            user.setDusName( lastName );
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
           // erreurs.put( CHAMP_NOM, e.getMessage() );
            
            throw new Exception(e.getMessage());
        }

        //    try {
        //        CheckTelephone( telephone );
        //    } catch ( Exception e ) {
        //        // TODO Auto-generated catch block
        //        erreurs.put( CHAMP_TELEPHONE, e.getMessage() );
        //    }

        try {
            CheckPrenom(firstName);
            user.setDusSurname( firstName );
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
           // erreurs.put( CHAMP_PRENOM, e.getMessage() );
            
            throw new Exception(e.getMessage());
        }

        try {
            CheckMdp(mdp);
            user.setDusMdp( mdp );
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
           // erreurs.put( CHAMP_PRENOM, e.getMessage() );
            throw new Exception(e.getMessage());
          
        }
     
       
            
        try {
            IsNew(email);
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
           // erreurs.put( "IsNew", e.getMessage() );
           
            throw new Exception( "this user already exist in database (email) please use a valide mail"+ e.getMessage());
           
        }
        

 user.setDusPict("/puls/inc/pictures/default.png");
 
        logger.info("New user informations is conform");
        return userDao.create( user);
              
  
        
    }
    public boolean UpdatePicture(File file, UserCustom user){
        
        if(file!=null)
        {
            user.setDusPict( file.toString().replace( "\\", "/" ).substring(2));
            
            userDao.UpdateUser( user );
            return true;
        }
        
        
        return false;
    }
    
    public UserCustom getUser(String login, String mdp) throws Exception
    {
        CheckEmail( login );
        CheckMdp( mdp );
        
        if(!IsNew(login))
        return userDao.getUser( login, mdp);
        
        return null;
    }
    
    public UserCustom ConnectUser(String login,String mdp){


            try{

              logger.info( "User Trying authentication  ");
              UserCustom user = userDao.getUser(login , mdp );
                if(user!=null)
                {logger.info( "User  authentication succed ");
                   return user;
                }else
                {
                    logger.info( "User authentication fail ");
                }
               
                
                
               
            } catch(Exception e)
            {
                e.printStackTrace();
            }

        
        return null;
    }
    
   public boolean  updatUser(UserCustom user)
   {
       return userDao.update(user,null);  
   }

    public void CheckMdp( String mdp2 ) throws Exception {
        // TODO Auto-generated method stub
        if ( mdp2.trim().isEmpty() ) {
            throw new Exception( "Le champs password doit etre remplis !" );
        } else if ( mdp2.trim().length() <= 3 ) {
            throw new Exception( "Le champs password doit avoir plus de 3 caractères !" );
        }

    }


    public void CheckName( String name ) throws Exception {
        if ( name.trim().isEmpty() ) {
            throw new Exception( "Le champs nom doit etre remplis !" );
        } else if ( name.trim().length() <= 3 ) {
            throw new Exception( "Le champs nom doit avoir plus de 3 caractères !" );
        }
       

    }

    public void CheckPrenom( String prenom ) throws Exception {
        if ( prenom.trim().isEmpty() ) {
            throw new Exception( "Le champs nom doit etre remplis !" );
        } else if ( prenom.trim().length() <= 3 ) {
            throw new Exception( "Le champs nom doit avoir plus de 3 caractères !" );
        }
        

    }

    public void CheckAdress( String adress ) throws Exception {
        if ( adress.trim().isEmpty() ) {
            throw new Exception( "Le champs adresse doit etre remplis !" );
        } else if ( adress.length() <= 3 ) {
            throw new Exception( "Le champs Adresse avoir plus de 3 caractères  !" );
        }
        
    }

    public void CheckTelephone( String tel ) throws Exception {
        if ( tel.trim().isEmpty() ) {
            throw new Exception( "Le champs tel doit etre remplis !" );
        } else if ( tel.trim().length() != 10 ) {
            throw new Exception( "Le champs tel doit avoir 10 caractères  !" );
        }

       
    }

   
    public void CheckEmail( String email ) throws Exception {

        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }


    }
    
  

    public boolean IsNew(String email)throws Exception{
        //true pour lui dire de laisser la connexion ouverte
      
        return !userDao.UserExiste2( email);
           
        
        
    }
    
    public void createSpace( UserCustom user ) {

        File file = new File( prefixDir + UserEnvironement );

        if ( file.exists() ) {
            file = new File( prefixDir + UserEnvironement + "\\" + user.getDusEmail() );
            file.mkdirs();
        } else {
            file.mkdirs();
            file = new File( prefixDir + UserEnvironement + "\\" + user.getDusEmail() );
            file.mkdirs();

        }

    }
   
}
