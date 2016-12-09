package model.custom;

import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Entity;
import javax.persistence.Table;

import model.bean.DefaultCustomer;
@Entity
@Table(name="Customer2")
public class CustomerCustom extends DefaultCustomer{
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
}
