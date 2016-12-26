package model.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import json.Jsonmap;
import model.dao.Executable;
import model.dao.InterfaceCenter;
@Service("genericJob")
public class GenericJobImpl implements GenericJob{
    @Autowired(required=true)
    private InterfaceCenter daoCenter;
    @Override
    public boolean createObject( Executable obj ) {
        // TODO Auto-generated method stub
        return daoCenter.create( obj, null );
    }

    @Override
    public boolean deleteObject( Executable obj ) {
        // TODO Auto-generated method stub
        return daoCenter.delete( obj,null );
    }

    @Override
    public boolean deleteObject( Class cls, String id ) {
        // TODO Auto-generated method stub
        return daoCenter.delete( cls, id, null );
    }

    @Override
    public Object getObject( Class cls, String id,boolean lazyLoad ) {
        // TODO Auto-generated method stub
       
        return daoCenter.read( cls, id ,lazyLoad);
    }

    @Override
    public Object getObject( Executable obj,boolean lazyLoad ) {
        // TODO Auto-generated method stub
        return daoCenter.read( obj,lazyLoad);
    }

    @Override
    public List<Object> getListObjectV1( Class cls, String[][] restriction,String[][] order,String[][] alias ) {
        // TODO Auto-generated method stub
        return daoCenter.list( cls, restriction, order,alias );
        
    }

    @Override
    public List<Object> getListObjectV2( Class cls, String restriction ) {
        // TODO Auto-generated method stub
        
        //throw error si st2%3 est different de 0
        
        String[] st2=restriction.split(":");
        String[][] st=new String[(st2.length/3)][3];
        //just transform a String to a String[?][3]
        for(int i=0; i<(st2.length/3);i+=3)
        {
            st[i][0]=st2[i].trim();
            st[i][1]=st2[i+1].trim();
            st[i][2]=st2[i+2].trim();
        }
        
        return getListObjectV1( cls, st ,null,null);
    }

    @Override
    public List getList( Class cls, String[][] alias, String[][] restriction, String[][] order,
            String[][] projection, int firstResult ,int maxResult) {
        // TODO Auto-generated method stub
        return daoCenter.complexList( cls, alias, restriction, order, projection,firstResult,maxResult );
    }

    @Override
    public List getList( Class cls, String alias, String restriction, String order, String[] projection ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List getListObject( Class cls, Jsonmap param ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List getList( Class cls, Jsonmap param ) {
        // TODO Auto-generated method stub
        return daoCenter.complexList( cls, param );
    }

    @Override
    public List<String> getList(String request,String[][] params, int firstResult,int maxResult) {
        // TODO Auto-generated method stub
       return daoCenter.complexList( request,params ,firstResult,maxResult);
        
    }

    @Override
    public boolean updateObject( Executable obj ) {
        // TODO Auto-generated method stub
        return daoCenter.update( obj, null );
    }

    @Override
    public void loadLazyCollection(Executable obj) {
        daoCenter.loadLazyCollection( obj );
        
    }

}
