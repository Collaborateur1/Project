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
@Table(name="Attachment")
public class Attachment  implements Executable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "attaId")
    private String attaId;
    
    @Column(name="attaDescription", length=60) 
    private String attaDescription;
    
    @Column(name="attaUrl", length=80) 
    private String attaUrl;
    
    @Column(name="attaType", length=16) 
    private String attaType;

    public String getAttaId() {
        return attaId;
    }

    public void setAttaId( String attaId ) {
        this.attaId = attaId;
    }

    public String getAttaDescription() {
        return attaDescription;
    }

    public void setAttaDescription( String attaDescription ) {
        this.attaDescription = attaDescription;
    }

    public String getAttaUrl() {
        return attaUrl;
    }

    public void setAttaUrl( String attaUrl ) {
        this.attaUrl = attaUrl;
    }

    public String getAttaType() {
        return attaType;
    }

    public void setAttaType( String attaType ) {
        this.attaType = attaType;
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
        return attaId;
    }


}
