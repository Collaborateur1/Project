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

import model.custom.CustomerCustom;
import model.custom.UserCustom;
import model.dao.Executable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DefaultDossier implements Executable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long              dossierId;
    
    @Column(name="enterpriseName") 
    private String              dossierName;
    
    @Column(name="dossierCreation") 
    private Date                dossierCreation;
    
    @Column(name="dossierUpdate") 
    private Date                dossierUpdate;
   
    @Column(name="dossierCreator") 
    private UserCustom            dossierCreator;
    
    @Column(name="dossierHistory") 
    private String              dossierHistory;
    
    @ManyToOne(cascade = CascadeType.ALL) 
    private CustomerCustom dossierCustomer;
    
   

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userDossier" )
    private List<UserCustom> dossierResponsible;

    public long getDossierId() {
        return dossierId;
    }

    public void setDossierId( long dossierId ) {
        this.dossierId = dossierId;
    }

    public String getDossierName() {
        return dossierName;
    }

    public void setDossierName( String dossierName ) {
        this.dossierName = dossierName;
    }

    public Date getDossierCreation() {
        return dossierCreation;
    }

    public void setDossierCreation( Date dossierCreation ) {
        this.dossierCreation = dossierCreation;
    }

    public Date getDossierUpdate() {
        return dossierUpdate;
    }

    public void setDossierUpdate( Date dossierUpdate ) {
        this.dossierUpdate = dossierUpdate;
    }

    public UserCustom getDossierCreator() {
        return dossierCreator;
    }

    public void setDossierCreator( UserCustom dossierCreator ) {
        this.dossierCreator = dossierCreator;
    }

    public String getDossierHistory() {
        return dossierHistory;
    }

    public void setDossierHistory( String dossierHistory ) {
        this.dossierHistory = dossierHistory;
    }

    public List<UserCustom> getDossierResponsible() {
        return dossierResponsible;
    }

    public void setDossierResponsible( List<UserCustom> dossierResponsible ) {
        this.dossierResponsible = dossierResponsible;
    }
    public CustomerCustom getDossierCustomer() {
        return dossierCustomer;
    }

    public void setDossierCustomer( CustomerCustom dossierCustomer ) {
        this.dossierCustomer = dossierCustomer;
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
        return dossierId;
    }

}
