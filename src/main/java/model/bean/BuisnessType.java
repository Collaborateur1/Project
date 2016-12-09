package model.bean;

import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import model.dao.Executable;

@Entity
@Table(name="BuisnessType")
public class BuisnessType  implements Executable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "buisTypeId")
    private String buisTypeId;
    
    @Column(name = "buisTypeName", length=50)
    private String buisTypeName;

    public String getBuisTypeId() {
        return buisTypeId;
    }

    public void setBuisTypeId( String buisTypeId ) {
        this.buisTypeId = buisTypeId;
    }

    public String getBuisTypeName() {
        return buisTypeName;
    }

    public void setBuisTypeName( String buisTypeName ) {
        this.buisTypeName = buisTypeName;
    }

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
        return buisTypeId;
    }
    
    
    
}
