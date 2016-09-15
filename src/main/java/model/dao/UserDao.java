package model.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.custom.UserCustom;

public class UserDao extends DaoCenter implements InterfaceUserDao{
    private static Logger logger = Logger.getLogger( UserDao.class);
    


    

    
    public boolean UpdateUser(UserCustom user)
    { 
        return super.update( user, null);
      
    }
    
   
    
    
   
    
 

    @Override
    public UserCustom getUserById( int id ) {
        //to update!
        return (UserCustom) super.read( UserCustom.class, String.valueOf(id), false );
    }

    @Override
    public UserCustom getUserByLogin( String login ) {
        // TODO Auto-generated method stub
        Session s=null;
        try{
            s=GetSession();
           
            Criteria criteria=s.createCriteria( UserCustom.class );
            criteria.add( Restrictions.eq( "email", login ) );
            UserCustom user=(UserCustom)criteria.uniqueResult();
         
            
            if(user!=null)
            {
               return user; 
            }else 
            {
                return null;
            }
           
            
            
            
           
        } catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            try {
                CloseConnexion(s);
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }
        return null;
      
    }

    @Override
    public int getUsersCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<UserCustom> getUsers() {
        // TODO Auto-generated method stub
        List<UserCustom> list=null;
        Session s=null;
        
        try{
            s=GetSession();
            Criteria criteria=s.createCriteria( UserCustom.class );
            criteria.setMaxResults(50);
            list=criteria.list();
        
        s.close();
        } catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            try {
                CloseConnexion(s);
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }
        return list;
    }

    @Override
    public boolean create( UserCustom user ) {
        return super.create( user, null );
       /* boolean transaction =false;
        Session s = null;
        try{
            s=GetSession();
            Transaction tx = s.beginTransaction();
          
                s.persist( user );
             tx.commit();
             transaction=tx.wasCommitted();
             logger.info( "New user is create and the transaction is commited ? :" +transaction );
            
         
        } catch(Exception e)
        { 
            logger.error( "fail to create new user :" + e.getMessage() );
           
        }finally{
            try {
                CloseConnexion(s);
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }
        
        return transaction;
        */
    }

    @Override
    public UserCustom getUser( String email, String mdp ) {
        // TODO Auto-generated method stub
        Session s=null; 
        try{
            s= GetSession();
            
             Criteria criteria=s.createCriteria( UserCustom.class );
             criteria.add( Restrictions.eq( "dusEmail", email ) );
             criteria.add( Restrictions.eq( "dusMdp", mdp ) );
             UserCustom user=(UserCustom)criteria.uniqueResult();
           
             
             
             if(user!=null)
             {
                return user; 
             }else 
             {
                 return null;
             }
            
             
             
             
            
         } catch(Exception e)
         {
             e.printStackTrace();
         }finally{
             try {
                 CloseConnexion(s);
             } catch ( Exception e ) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }   
         }
         
        
         return null;
       
    }


    @Override
    public boolean AuthorizerUser( String email, String mdp ) {
        // TODO Auto-generated method stub
        Session s=null;
        try{
           
            
            s=GetSession();
                try{
                    s=getSessionFactory().getCurrentSession();
                     }
                    catch(Exception e){
                      s= getSessionFactory().openSession();
                        
                    }
            
            Criteria criteria=s.createCriteria( UserCustom.class );
            criteria.add( Restrictions.eq( "email", email ) );
            criteria.add( Restrictions.eq( "mdp", mdp.getBytes() ) );
            UserCustom user=(UserCustom)criteria.uniqueResult();
           
            
            if(user!=null)
            {
               return true; 
            }else 
            {
                return false;
            }
           
            
            
            
           
        } catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            try {
                CloseConnexion(s);
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }
        
        return false;
    }

    @Override
    public boolean UserExiste2( String email) {
        // TODO Auto-generated method stub
        Session  s=null;
        try{
            
             s=GetSession();
            //a modif
            Criteria criteria=s.createCriteria( UserCustom.class );
            criteria.add(Restrictions.eq( "dusEmail", email ));
            UserCustom user=(UserCustom)criteria.uniqueResult();
            
            
            if(user!=null)
            {
               return true; 
            }else 
            {
                return false;
            }
   
           
        } catch(Exception e)
        {
           logger.debug( e );
        }finally{
            try {
                CloseConnexion(s);
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }
        return false;
    }
    
   
    
}
