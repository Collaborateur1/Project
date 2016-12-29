package model.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import com.javaetmoi.core.persistence.hibernate.LazyLoadingUtil;

import json.Alia;
import json.Jsonmap;
import json.Param;
import model.custom.UserCustom;
@Transactional
public class DaoCenter<T extends Executable> implements InterfaceCenter<T> {
    private static Logger  logger = Logger.getLogger( DaoCenter.class );
    private SessionFactory sessionFactory;

    public boolean exist( T object ) {
        boolean transaction = false;
        Session session = null;
        try {
            session = GetSession();
            Transaction tx = session.beginTransaction();

            Object obj = session.get( object.getClass(), object.getID() );
            tx.commit();
            if ( obj != null ) {
                logger.info( "object from class: " + object.getClass() + " and id: " + object.getID() + " exist" );
                return true;
            }

            logger.info( "object from class: " + object.getClass() + " and id: " + object.getID() + " don't exist" );

        } catch ( Exception e ) {
            logger.error( "fail to check if  object exist " + e.getMessage() );

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return false;

    }

    public boolean create( T object, ConcurrentHashMap<String, Object> item ) {
        boolean transaction = false;
        Session session = null;
        // try catch a prévoir
        object.presave( item );
        try {
            session = GetSession();
            Transaction tx = session.beginTransaction();

            session.persist( object );
            tx.commit();
            transaction = tx.wasCommitted();
            logger.info( "New " + object.getClass() + " is create and the transaction is commited ? :" + transaction );

        } catch ( Exception e ) {
            logger.error( "fail to create new " + object.getClass() + " " + e.getMessage() );

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if ( item == null )
            item = new ConcurrentHashMap<String, Object>();
        item.put( "Transaction", transaction );
        // try catch a prévoir
        object.postsave( item );
        return transaction;

    }

    public boolean update( T object, ConcurrentHashMap<String, Object> item ) {

        boolean transaction = false;

        Session session = null;

        // try catch a prévoir
        object.presave( item );

        try {
            // open session
            session = GetSession();

            // open transaction
            Transaction tx = session.beginTransaction();

            session.saveOrUpdate( object );

            // commit transaction
            tx.commit();

            transaction = tx.wasCommitted();
            logger.info( object.getClass() + " is updated and the transaction is commited ? :" + transaction );

        } catch ( Exception e ) {
            logger.error( "fail to  update " + object.getClass() + " " + e.getMessage() );

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if ( item == null )
            item = new ConcurrentHashMap<String, Object>();
        item.put( "Transaction", transaction );
        // try catch a prévoir
        object.postsave( item );
        return transaction;
    }

    public boolean delete( T object, ConcurrentHashMap<String, Object> item ) {

        object.presave( item );

        boolean transaction = false;
        Session session = null;
        try {
            // Ouverture Session
            session = GetSession();

            // Ouverture Transaction
            Transaction tx = session.beginTransaction();

            session.delete( object );
            tx.commit();
            transaction = tx.wasCommitted();

            logger.info( "object from class: " + object.getClass() + " and id: " + object.getID() + " is now delete" );

        } catch ( Exception e ) {
            logger.error( "fail to delete  object :" + e.getMessage() );

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if ( item == null )
            item = new ConcurrentHashMap<String, Object>();
        item.put( "Transaction", transaction );
        // try catch a prévoir
        object.postsave( item );
        return transaction;
    }

    public void CloseConnexion( Session s ) throws Exception {
        try {
            s.close();
        } catch ( HibernateException e ) {
            e.printStackTrace();
        }

    }

    public Session GetSession() {
        Session s;

        try {
            s = getSessionFactory().getCurrentSession();
        } catch ( Exception e ) {
            s = getSessionFactory().openSession();

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
    public Object read( Class<T> object, String[][] restriction ) {
        // TODO Auto-generated method stub
        boolean transaction = false;
        Session session = null;

        // ici on doit vérifier si les restriction et autre truck que tu
        // ajoutera plus tard, si il sont tous null retourné directement null
        try {
            // Ouverture Session
            session = GetSession();
            Criteria criter = session.createCriteria( object );

            if ( restriction != null )
                addRestrinction( criter, restriction );

            return criter.uniqueResult();

        } catch ( Exception e ) {
            logger.error( "fail to fetch  object :" + e.getMessage() );

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Object> list( Class<T> object, String[][] restriction, String[][] order,String[][] alias ) {
        boolean transaction = false;
        Session session = null;

        // ici on doit vérifier si les restriction et autre truck que tu
        // ajoutera plus tard, si il sont tous null retourné directement null
        try {
            // Ouverture Session
            session = GetSession();
            Criteria criter = session.createCriteria( object );

            if ( restriction != null )
                addRestrinction( criter, restriction );
            if(alias!=null)
                addAlias( criter, alias ); 

            List<Object> lst = criter.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY ).list();

            return lst;

        } catch ( Exception e ) {
            logger.error("fail to fetch  object List, "+ e.getStackTrace()[0].getMethodName(),e);
         

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List complexList( Class<?> object, String[][] alias, String[][] restriction, String[][] order,
            String[][] projection, int firstResult,int maxResult) {
        // TODO Auto-generated method stub
        boolean transaction = false;
        Session session = null;

        // ici on doit vérifier si les restriction et autre truck que tu
        // ajoutera plus tard, si il sont tous null retourné directement null
        try {
            // Ouverture Session
            session = GetSession();
            Criteria criter = session.createCriteria( object );

            if ( alias != null )
                addAlias( criter, alias );

            if ( order != null )
                addOrder( criter, order );

            if ( restriction != null )
                addRestrinction( criter, restriction );

            if ( projection != null )
                addProjection( criter, projection );
// List list=criter.setFirstResult( 10 ).list();
            if(maxResult!=0)
                criter.setMaxResults( maxResult);
            if(firstResult!=0)
                criter.setFirstResult(firstResult);
            List list=criter.setResultTransformer( Criteria.DISTINCT_ROOT_ENTITY ).setResultTransformer( Criteria.ALIAS_TO_ENTITY_MAP ).list();
            return list;
           

        } catch ( Exception e ) {
           
            logger.error("fail to fetch List, "+ e.getStackTrace()[0].getMethodName(),e);
            

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public void addRestrinction( Criteria criter, String[][] restriction ) {
        for ( int i = 0; i < restriction.length; i++ ) {
            switch ( restriction[i][1].toUpperCase() ) {

            case "=":
            case "EQ":
                criter.add( Restrictions.eq( restriction[i][0], restriction[i][2] ) );
                break;
                
            case "=B":
            case "EQB":
                criter.add( Restrictions.eq( restriction[i][0], "true".equals(restriction[i][2]) ) );
                break;
                
            case "=I":
            case "EQI":
                criter.add( Restrictions.eq( restriction[i][0], Integer.parseInt(restriction[i][2]) ) );
                break;

            case "<=":
            case "LE":
               
                criter.add( Restrictions.le( restriction[i][0], Long.parseLong(restriction[i][2]) ) );
                break;
                
            case "<=D":
            case "LED":
               
                criter.add( Restrictions.le( restriction[i][0], DateTime.parse(restriction[i][2]).toDate())  );
                break;
                
            case "<=DT":
            case "LEDT":
               
                criter.add( Restrictions.le( restriction[i][0], DateTime.parse(restriction[i][2]))  );
                break;

            case "<":
            case "LT":
             
                criter.add( Restrictions.lt( restriction[i][0], Long.parseLong(restriction[i][2])) );
                break;

            case ">=":
            case "GE":
                criter.add( Restrictions.ge( restriction[i][0], Long.parseLong(restriction[i][2]) ) );
                break;
                
            case ">=D":
            case "GED":
                criter.add( Restrictions.ge( restriction[i][0],DateTime.parse(restriction[i][2]).toDate() ) );
                break;
                
            case ">=DT":
            case "GEDT":
                criter.add( Restrictions.ge( restriction[i][0],DateTime.parse(restriction[i][2]) ) );
                break;

            case ">":
            case "GT":
                criter.add( Restrictions.gt( restriction[i][0], Long.parseLong(restriction[i][2]) ) );
                break;

            case "LIKE":
                criter.add( Restrictions.like( restriction[i][0], restriction[i][2] + "%" ) );
                break;

            default:
                criter.add( Restrictions.eq( restriction[i][0], restriction[i][2] ) );
                break;

            }
        }
    }

    public void addOrder( Criteria criter, String[][] order ) {
        for ( int i = 0; i < order.length; i++ ) {
            switch ( order[i][1].toUpperCase() ) {

            case "DESC":
                criter.addOrder( Order.desc( order[i][0] ) );
                break;

            case "ASC":
                criter.addOrder( Order.desc( order[i][0] ) );
                break;
            }

        }

    }

    public void addAlias( Criteria criter, String[][] alias ) {
        for ( int i = 0; i < alias.length; i++ ) {
            criter.createAlias( alias[i][0], alias[i][1],JoinType.LEFT_OUTER_JOIN );
        }
    }

    public void addProjection( Criteria criter, String[][] projection ) {
        boolean haveProperty = false;
       ProjectionList projList=Projections.projectionList();
       
        for ( int i = 0; i < projection.length; i++ ) {

            switch ( projection[i][0].toUpperCase() ) {

            case "PROPERTY":
                projList.add(Projections.property( projection[i][1] ).as( projection[i][1] ) );
                if ( !haveProperty )
                    haveProperty = true;
                break;

            case "ROWCOUNT":
                projList.add( Projections.rowCount() );
                if ( haveProperty )
                    logger.debug( "Warning : ROWCOUNT must be use without PROPERTY check your projection" );
                break;

            case "COUNT":
                projList.add(Projections.count( projection[i][1] ) );
                break;

            case "GROUPBY":
                projList.add(Projections.groupProperty( projection[i][1] ) );
                break;

            }
        }
        if(projList.getLength()!=0){
            criter.setProjection( projList ); 
            
        }
         
       
    }

    @Override
    public boolean delete( Class<T> object, String id, ConcurrentHashMap<String, Object> item ) {
        // TODO Auto-generated method stub
        Session session = null;
        boolean transaction = false;
        T obj = null;
        try {
            // Ouverture Session
            session = GetSession();

            // Ouverture Transaction
            Transaction tx = session.beginTransaction();

            obj = object.cast( session.load( object, id ) );
            tx.commit();
            transaction = tx.wasCommitted();

        } catch ( Exception e ) {
            logger.error( "fail to delete  object with id :" + id + "from class: " + object.getName() + " "
                    + e.getMessage() );

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if ( transaction && obj != null )
            return delete( obj, null );

        return false;
    }

    @Override
    public Object read( T object ,boolean lazyLoad) {
       
           String lg="-1";
        try {
            lg = object.getID();
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
      return read((Class<T>) object.getClass(),String.valueOf(lg),lazyLoad);
    }

    @Override
    public Object read( Class<T> object, Jsonmap param ) {
        // TODO Auto-generated method stub
        boolean transaction = false;
        Session session = null;

        // ici on doit vérifier si les restriction et autre truck que tu
        // ajoutera plus tard, si il sont tous null retourné directement null
        try {
            // Ouverture Session
            session = GetSession();
            Criteria criter = session.createCriteria( object );

            addJsonParam(criter,param);

            return criter.uniqueResult();

        } catch ( Exception e ) {
            logger.error( "fail to fetch  object :" + e.getMessage() );

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        
        return null;
    }

    @Override
    public List complexList( Class<?> object, Jsonmap param ) {
        // TODO Auto-generated method stub
        
        boolean transaction = false;
        Session session = null;

        // ici on doit vérifier si les restriction et autre truck que tu
        // ajoutera plus tard, si il sont tous null retourné directement null
        try {
            // Ouverture Session
            session = GetSession();
            Criteria criter = session.createCriteria( object );
            if(param!=null)
            addJsonParam(criter,param);

            return criter.setResultTransformer( Transformers.ALIAS_TO_ENTITY_MAP ).list();

        } catch ( Exception e ) {
            logger.error( "fail to fetch  object List :" + e.getMessage() );

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public void addJsonParam( Criteria criter, Jsonmap param ) {

        if ( param.getAlias() != null ) {
            List<Alia> listAlias = param.getAlias();
            Alia alias;
            for ( int i = 0; i < listAlias.size(); i++ ) {
                alias = listAlias.get( i );
                criter.createAlias( alias.getField(), alias.getAlias() );

            }

        }

        if ( param.getOrder() != null ) {
            List<json.Order> listOrder = param.getOrder();

            json.Order order;
            Iterator<String> values;
            for ( int i = 0; i < listOrder.size(); i++ ) {
                order = listOrder.get( i );

                switch ( order.getOpe().trim().toUpperCase() ) {

                case "DESC":

                    values = order.getValue().iterator();

                    while ( values.hasNext() )
                        criter.addOrder( Order.desc( values.next() ) );

                    break;

                case "ASC":

                    values = order.getValue().iterator();
                    while ( values.hasNext() )
                        criter.addOrder( Order.asc( values.next() ) );

                    break;
                }

            }

        }
        if ( param.getProjection() != null )

        {
            List<json.Projection> listProj = param.getProjection();
            json.Projection proj;
            Iterator<String> values;
            boolean haveProperty = false;
            boolean rowCount = false;

            for ( int i = 0; i < listProj.size(); i++ ) {
                proj = listProj.get( i );
                switch ( proj.getName().trim().toUpperCase() ) {

                case "PROPERTY":
                    values = proj.getValue().iterator();
                    while ( values.hasNext() ){
                        String tmpValue=values.next().trim();
                        criter.setProjection( Projections.property(  tmpValue).as( tmpValue ) );
                    }
                    if ( rowCount )
                        logger.debug(
                                "Warning : PROPERTY must be use without ROWCOUNT check your projection configuration" );

                    if ( !haveProperty )
                        haveProperty = true;
                    break;

                case "ROWCOUNT":
                    if ( !rowCount )
                        rowCount = true;

                    criter.setProjection( Projections.rowCount() );
                    if ( haveProperty )
                        logger.debug(
                                "Warning : ROWCOUNT must be use without PROPERTY check your projection configuration" );
                    break;

                case "COUNT":
                    values = proj.getValue().iterator();
                    while ( values.hasNext() )
                        criter.setProjection( Projections.count( values.next().trim() ) );
                    break;

                case "GROUPBY":
                    values = proj.getValue().iterator();
                    while ( values.hasNext() )
                        criter.setProjection( Projections.groupProperty( values.next().trim() ) );
                    break;

                }
            }
        }

        if ( param.getParam() != null ) {
            List<Param> listParam = param.getParam();
            Param para;
            for ( int i = 0; i < listParam.size(); i++ ) {
                para = listParam.get( i );

                switch ( para.getOperation().trim().toUpperCase() ) {

                case "=":
                case "EQ":
                    criter.add( Restrictions.eq( para.getField().trim(), para.getValue() ) );
                    break;

                case "<=":
                case "LE":
                    criter.add( Restrictions.le( para.getField().trim(), para.getValue() ) );
                    break;

                case "<":
                case "LT":
                    criter.add( Restrictions.lt( para.getField().trim(), para.getValue() ) );
                    break;

                case ">=":
                case "GE":
                    criter.add( Restrictions.ge( para.getField().trim(), para.getValue() ) );
                    break;

                case ">":
                case "GT":
                    criter.add( Restrictions.gt( para.getField().trim(), para.getValue() ) );
                    break;

                case "LIKE":
                    criter.add( Restrictions.like( para.getField().trim(), para.getValue() ) );
                    break;

                default:
                    criter.add( Restrictions.eq( para.getField().trim(), para.getValue() ) );
                    break;

                }

            }
        }

    }

    @Override
    public List<String> complexList(String request,String[][] params, int firstResult,int maxResults ) {
        // TODO Auto-generated method stub
        boolean transaction = false;
        Session session = null;

        // ici on doit vérifier si les restriction et autre truck que tu
        // ajoutera plus tard, si il sont tous null retourné directement null
        try {
            // Ouverture Session
            session = GetSession();
            org.hibernate.Query query = session.createSQLQuery(request);
          if(firstResult!=0)
              query.setFirstResult( firstResult );
          if(maxResults!=0)
              query.setMaxResults( maxResults ); 
            
            if(params!=null){
               
               for(int i=0;i<params.length;i++)
               {
                  
                           
                           switch ( params[i][1].toLowerCase() ) {
                           case "int":
                               
                               query.setInteger(params[i][0] , Integer.parseInt( params[i][1] ) );
                               break;
                           case "string":
                               query.setParameter(params[i][0] ,  params[i][1]  );
                               break;
                               
                           case "date":
                               query.setDate(params[i][0] ,  new Date(Long.parseLong(params[i][1])) );
                               break;
                           case "float":
                               query.setFloat(params[i][0] ,  Float.parseFloat(params[i][1]));
                               break;
                               
                           case "double":
                               query.setDouble(params[i][0] , Double.parseDouble( params[i][1] ) );
                               break;
                               
                           case "boolean":
                               query.setBoolean(params[i][0] , "true".equals(params[i][1]));
                               break;
                               
                               default:
                                   query.setParameter(params[i][0] ,  params[i][1]  );
                           }
               }
               
               
           }
            List<String> result = query.setResultTransformer( Transformers.ALIAS_TO_ENTITY_MAP ).list();

            return result;

        } catch ( Exception e ) {
            logger.error( "fail to fetch  object List :" + e.getMessage() );

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Object read( Class<T> object, String id,boolean lazyLoad ) {
        boolean transaction = false;
        Session session = null;

        // ici on doit vérifier si les restriction et autre truck que tu
        // ajoutera plus tard, si il sont tous null retourné directement null
        try {
            // Ouverture Session
            session = GetSession();
           Object tmp= session.get(object, id);
           if(!lazyLoad)
           loadLazyCollection((T) tmp);
          return tmp;

        } catch ( Exception e ) {
           
            logger.error( "fail to fetch  object :"+object.getName() +", "+e.getStackTrace()[0].getMethodName(),e );

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void loadLazyCollection( T object ) {
        boolean transaction = false;
        Session session = null;

        // ici on doit vérifier si les restriction et autre truck que tu
        // ajoutera plus tard, si il sont tous null retourné directement null
        try {
            // Ouverture Session
            session = GetSession();
            UserCustom user=(UserCustom) object;
            LazyLoadingUtil.deepHydrate(session, object);
          
          

        } catch ( Exception e ) {
            logger.error( "fail to loadLazyCollection  object :"+object.getClass() +", "+ e.getMessage() );

        } finally {
            try {
                CloseConnexion( session );
            } catch ( Exception e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       
    }
    
    
}
