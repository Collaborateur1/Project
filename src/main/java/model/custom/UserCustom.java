package model.custom;

import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Entity;
import javax.persistence.Table;

import model.bean.DefaultUser;
@Entity
@Table(name="User")
public class UserCustom extends DefaultUser {

    @Override
    public boolean presave( ConcurrentHashMap<String, Object> item ) {
        // TODO Auto-generated method stub
        System.out.println( "*********************************************************************************************************************" );
        return false;
    }

    @Override
    public boolean postsave( ConcurrentHashMap<String, Object> item ) {
        // TODO Auto-generated method stub
        
        return false;
    }

    @Override
    public String toString() {
        return  "to update";
    }

    
    
}
