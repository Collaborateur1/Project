package model.bean;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import model.dao.Executable;

@Entity
@Table(name="Service")
public class Service implements Executable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "servId")
    private String servId;
    
    @Column(name = "servName", length=25)
    private String servName;
    
    @Column(name = "servDesciption", length=200)
    private String servDesciption;
    
    @JsonBackReference //don't serialize hairdresser in service
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "hairServices")
    private List<Hairdresser> servHairdressers;

    @Column(name = "servManager")
    private boolean servManager;
    
   
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinTable(name="service_attachment", 
    joinColumns=@JoinColumn(name="servId"),
    inverseJoinColumns=@JoinColumn(name="attaId"))
    private List<Attachment> servAttachmentServices;


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
        return servId;
    }


    public String getServId() {
        return servId;
    }


    public void setServId( String servId ) {
        this.servId = servId;
    }


    public String getServName() {
        return servName;
    }


    public void setServName( String servName ) {
        this.servName = servName;
    }


    public String getServDesciption() {
        return servDesciption;
    }


    public void setServDesciption( String servDesciption ) {
        this.servDesciption = servDesciption;
    }


    public List<Hairdresser> getServHairdressers() {
        return servHairdressers;
    }


    public void setServHairdressers( List<Hairdresser> servHairdressers ) {
        this.servHairdressers = servHairdressers;
    }


    public boolean isServManager() {
        return servManager;
    }


    public void setServManager( boolean servManager ) {
        this.servManager = servManager;
    }


    public List<Attachment> getServAttachmentServices() {
        return servAttachmentServices;
    }


    public void setServAttachmentServices( List<Attachment> servAttachmentServices ) {
        this.servAttachmentServices = servAttachmentServices;
    }
    

}
