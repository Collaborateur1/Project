package model.bean;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.annotate.JsonBackReference;

import model.custom.CustomerCustom;
import model.custom.UserCustom;
import model.dao.Executable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class DefaultDossier implements Executable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long              dosID;
    
    @Column(name="dosName") 
    private String              dosName;
    
    @Column(name="dosCreation") 
    private Date                dosCreation;
   
    
    @Column(name="dosUpdate") 
    private Date                dosUpdate;
   
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private UserCustom            dosCreator;
    
    @Column(name="dosHistory") 
    private String              dosHistory;
    
    @ManyToOne(cascade = CascadeType.MERGE) 
    private CustomerCustom dosCustomer;
    
   
   
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "dusDossier" )
    @JsonBackReference
    private List<UserCustom> dosResponsible;

    

    public long getDosID() {
        return dosID;
    }

    public void setDosID( long dosID ) {
        this.dosID = dosID;
    }

    public String getDosName() {
        return dosName;
    }

    public void setDosName( String dosName ) {
        this.dosName = dosName;
    }

    public Date getDosCreation() {
        return dosCreation;
    }

    public void setDosCreation( Date dosCreation ) {
        this.dosCreation = dosCreation;
    }

    public Date getDosUpdate() {
        return dosUpdate;
    }

    public void setDosUpdate( Date dosUpdate ) {
        this.dosUpdate = dosUpdate;
    }

    public UserCustom getDosCreator() {
        return dosCreator;
    }

    public void setDosCreator( UserCustom dosCreator ) {
        this.dosCreator = dosCreator;
    }

    public String getDosHistory() {
        return dosHistory;
    }

    public void setDosHistory( String dosHistory ) {
        this.dosHistory = dosHistory;
    }

    public CustomerCustom getDosCustomer() {
        return dosCustomer;
    }

    public void setDosCustomer( CustomerCustom dosCustomer ) {
        this.dosCustomer = dosCustomer;
    }

    public List<UserCustom> getDosResponsible() {
        return dosResponsible;
    }

    public void setDosResponsible( List<UserCustom> dosResponsible ) {
        this.dosResponsible = dosResponsible;
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
    public long getID() throws Exception {
        // TODO Auto-generated method stub
        return getDosID();
    }

}
