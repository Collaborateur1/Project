package model.dao;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

public class DaoCenter<T extends Executable > implements InterfaceCenter<T> {
    private static Logger logger = Logger.getLogger(DaoCenter.class);
    private SessionFactory sessionFactory;
    
    public boolean exist(T object)
    {
        boolean transaction =false;
        Session session =null;
        try{
            session=GetSession();
            Transaction tx = session.beginTransaction();
            
      
              Object obj= session.get( object.getClass(),object.getID());
             tx.commit();
             if(obj!=null)
             { 
                 logger.info( "object from class: "+object.getClass()+" and id: " +object.getID()+ " exist" );
                 return true;
             }
            
             logger.info( "object from class: "+object.getClass()+" and id: " +object.getID()+ " don't exist" );
         
        } catch(Exception e)
        { 
            logger.error( "fail to check if  object exist " +e.getMessage() );
           
        }finally{
            try {
                CloseConnexion(session);
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }

    
       
        return false;
        
    }
    public boolean create(T object ,ConcurrentHashMap<String, Object> item)
    {
        boolean transaction =false;
        Session session =null;
      //try catch a prévoir
        object.presave(item);
        try{
            session=GetSession();
            Transaction tx = session.beginTransaction();
          
                session.persist(object);
             tx.commit();
             transaction=tx.wasCommitted();
             logger.info( "New "+object.getClass()+" is create and the transaction is commited ? :" +transaction );
            
         
        } catch(Exception e)
        { 
            logger.error( "fail to create new "+object.getClass()+" " +e.getMessage() );
           
        }finally{
            try {
                CloseConnexion(session);
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }
        
        if(item==null)
            item=new ConcurrentHashMap<String, Object>();
        item.put( "Transaction", transaction );
        //try catch a prévoir
        object.postsave( item );
        return transaction;
        
    }
    public boolean update(T object ,ConcurrentHashMap<String, Object> item){
       
        boolean transaction =false;
        
        Session session =null;
        
        //try catch a prévoir
        object.presave(item);
        
        try{
            //open session
            session=GetSession();
            
            //open transaction
            Transaction tx = session.beginTransaction();
          
             session.saveOrUpdate(object);
             
             //commit transaction
             tx.commit();
             
             transaction=tx.wasCommitted();
             logger.info(object.getClass()+" is updated and the transaction is commited ? :" +transaction );
            
         
        } catch(Exception e)
        { 
            logger.error( "fail to  update "+object.getClass()+" " +e.getMessage() );
           
        }finally{
            try {
                CloseConnexion(session);
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }
        if(item==null)
            item=new ConcurrentHashMap<String, Object>();
        item.put( "Transaction", transaction );
        //try catch a prévoir
        object.postsave( item );
        return transaction;
    }
    
    public boolean delete(T object ){
       
        
        
        boolean transaction =false;
        Session session =null;
        try{
         // Ouverture Session
            session=GetSession();
            
            // Ouverture Transaction
            Transaction tx = session.beginTransaction();
            
      
            session.delete(object);
             tx.commit();
             transaction=tx.wasCommitted();
             
             
 logger.info( "object from class: "+object.getClass()+" and id: " +object.getID()+ " is now delete" );
         
        } catch(Exception e)
        { 
            logger.error( "fail to delete  object :" +e.getMessage() );
           
        }finally{
            try {
                CloseConnexion(session);
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }

       return true;
    }
    
    
    public void CloseConnexion(Session s) throws Exception
    {
        try{
            s.close();
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
   
    }

public Session GetSession()
{
    Session s;
    
        
        try{
            s=getSessionFactory().getCurrentSession();
             }
            catch(Exception e){
              s= getSessionFactory().openSession();
                
            }
        return s;
}


public SessionFactory getSessionFactory() {
    return sessionFactory;
}
public void setSessionFactory( SessionFactory sessionFactory ) {
    this.sessionFactory = sessionFactory;
}
public static Logger getLogger() {
    return logger;
}
public static void setLogger( Logger logger ) {
    DaoCenter.logger = logger;
}

@Override
public Object read( Class<?> object, String[][] restriction) {
    // TODO Auto-generated method stub
    boolean transaction =false;
    Session session =null;
    
    //ici on doit vérifier si les restriction et autre truck que tu ajoutera plus tard, si il sont tous null retourné directement null
    try{
     // Ouverture Session
        session=GetSession();
        Criteria criter=session.createCriteria( object );
        
        if(restriction!=null)
        for (int i=0;i<restriction.length;i++)
        {
            switch(restriction[i][2]){
        
        case "=":
        case "eq":
            criter.add(Restrictions.eq( restriction[i][0],restriction[i][1] ));   
        break;
        
        case "<=":
        case "le":
            criter.add(Restrictions.le( restriction[i][0],restriction[i][1] ));     
            break;
            
        case "<":
        case "lt":
            criter.add(Restrictions.lt( restriction[i][0],restriction[i][1] ));     
            break;    
        
        case ">=":
        case "ge":
            criter.add(Restrictions.ge( restriction[i][0],restriction[i][1] ));  
            break;
            
        case ">":
        case "gt":
            criter.add(Restrictions.gt( restriction[i][0],restriction[i][1] ));  
            break;
        case "like":
        case "LIKE":
            criter.add(Restrictions.like( restriction[i][0],restriction[i][1]+"%" ));  
            break;     
            
            
            
            
        }
        }
        
         
        
        return criter.uniqueResult();
       
     
    } catch(Exception e)
    { 
        logger.error( "fail to fetch  object :" +e.getMessage() );
       
    }finally{
        try {
            CloseConnexion(session);
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }
    return null;
}
@Override
public List<Object> list( Class<?> object, String[][] restriction, String[][] order ) {
    boolean transaction =false;
    Session session =null;
    
    //ici on doit vérifier si les restriction et autre truck que tu ajoutera plus tard, si il sont tous null retourné directement null
    try{
     // Ouverture Session
        session=GetSession();
        Criteria criter=session.createCriteria( object );
        
        if(restriction!=null)
            addRestrinction( criter, restriction );
         
        
        List<Object> lst =criter.list();
       
     return lst;
     
    } catch(Exception e)
    { 
        logger.error( "fail to fetch  object List :" +e.getMessage() );
       
    }finally{
        try {
            CloseConnexion(session);
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }
    return null;
}
@Override
public List complexList( Class<?> object, String[][] alias, String[][] restriction, String[][] order,
        String[][] projection ) {
    // TODO Auto-generated method stub
    boolean transaction =false;
    Session session =null;
    
    //ici on doit vérifier si les restriction et autre truck que tu ajoutera plus tard, si il sont tous null retourné directement null
    try{
     // Ouverture Session
        session=GetSession();
        Criteria criter=session.createCriteria( object );
        
        if(alias!=null) 
         addAlias( criter, alias );   
   
        
        if(order!=null)
        addOrder( criter, order );
        
        if(restriction!=null)
        addRestrinction( criter, restriction );
        
        if(projection!=null)
            addProjection(criter,projection);
        
        return criter.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
       
     
    } catch(Exception e)
    { 
        logger.error( "fail to fetch  object List :" +e.getMessage() );
       
    }finally{
        try {
            CloseConnexion(session);
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }
    return null;
}

public void addRestrinction(Criteria criter, String[][] restriction)
{
    for (int i=0;i<restriction.length;i++)
    {
        switch(restriction[i][2].toUpperCase()){
    
    case "=":
    case "EQ":
        criter.add(Restrictions.eq( restriction[i][0],restriction[i][1] ));   
    break;
    
    case "<=":
    case "LE":
        criter.add(Restrictions.le( restriction[i][0],restriction[i][1] ));     
        break;
        
    case "<":
    case "LT":
        criter.add(Restrictions.lt( restriction[i][0],restriction[i][1] ));     
        break;    
    
    case ">=":
    case "GE":
        criter.add(Restrictions.ge( restriction[i][0],restriction[i][1] ));  
        break;
        
    case ">":
    case "GT":
        criter.add(Restrictions.gt( restriction[i][0],restriction[i][1] ));  
        break;
    
    case "LIKE":
        criter.add(Restrictions.like( restriction[i][0],restriction[i][1]+"%" ));  
        break;     
      
        
    }
    }   
}

public void addOrder(Criteria criter, String[][] order){
    for (int i=0;i<order.length;i++)
    {
        switch(order[i][0].toUpperCase()){
        
        
        case "DESC":
        criter.addOrder( Order.desc(order[i][1] ));
           break;
           
        case "ASC":
        criter.addOrder( Order.desc(order[i][1] ));
           break;
        }
        
        
        
    }  
    
   
}

public void addAlias(Criteria criter, String[][] alias){
    for (int i=0;i<alias.length;i++)
    {
        criter.createAlias( alias[i][0], alias[i][1] );
    }    
}
public void addProjection(Criteria criter, String[][] projection){
   boolean haveProperty=false;
   
    for (int i=0;i<projection.length;i++)
    {
        
switch(projection[i][0].toUpperCase()){
        
        
        case "PROPERTY":
        criter.setProjection( Projections.property( projection[i][1] ));
        if(!haveProperty)
        haveProperty=true;
           break;
           
        case "ROWCOUNT":
        criter.setProjection( Projections.rowCount());
        if(haveProperty)
        logger.debug( "Warning : ROWCOUNT must be use without PROPERTY check your projection" );
           break;
           
        case "COUNT":
            criter.setProjection( Projections.count( projection[i][1]));
            break;
            
        case "GROUPBY":
            criter.setProjection( Projections.groupProperty( projection[i][1]));
            break;
           
           
           
        }  
    }
}
}
