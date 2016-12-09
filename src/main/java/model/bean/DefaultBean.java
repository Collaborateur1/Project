package model.bean;

import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import model.dao.Executable;
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DefaultBean implements Executable{

    @Override
    public boolean presave( ConcurrentHashMap<String, Object> item ) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean postsave( ConcurrentHashMap<String, Object> item ) {
        // TODO Auto-generated method stub
        return false;
    }

   
    @Override
    public String getID() throws Exception {
        // TODO Auto-generated method stub
        throw new Exception("ERROR you must implement getID() in your custom object");
    }

}
