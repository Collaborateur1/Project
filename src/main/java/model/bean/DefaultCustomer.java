package model.bean;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import model.custom.DossierCustom;
import model.custom.EnterpriseCustom;
import model.dao.Executable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DefaultCustomer implements Executable{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long             customerId;

    @Column( name = "customerCivility" )
    private String             customerCivility;

    @Column( name = "customerName" )
    private String             customerName;

    @Column( name = "customerFirstName" )
    private String             customerFirstName;

    @Column( name = "customerNumber" )
    private String             customerNumber;

    @Column( name = "customerMail" )
    private String             customerMail;

    @Column( name = "customerAddresse" )
    private String             customerAddresse;

    @Column( name = "customerBith" )
    private Date               customerBith;

    @Column( name = "customerCreation" )
    private Date               customerCreation;

    @Column( name = "customerUpdate" )
    private Date               customerUpdate;

    @Column( name = "customerHistory" )
    private String             customerHistory;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "enterpriseCustomers")
    private List<EnterpriseCustom> customerEnterprise;

  
    @OneToMany(mappedBy="dossierCustomer")
    private List<DossierCustom> customerDossier;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId( long customerId ) {
        this.customerId = customerId;
    }

    public String getCustomerCivility() {
        return customerCivility;
    }

    public void setCustomerCivility( String customerCivility ) {
        this.customerCivility = customerCivility;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName( String customerName ) {
        this.customerName = customerName;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName( String customerFirstName ) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber( String customerNumber ) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail( String customerMail ) {
        this.customerMail = customerMail;
    }

    public String getCustomerAddresse() {
        return customerAddresse;
    }

    public void setCustomerAddresse( String customerAddresse ) {
        this.customerAddresse = customerAddresse;
    }

    public Date getCustomerBith() {
        return customerBith;
    }

    public void setCustomerBith( Date customerBith ) {
        this.customerBith = customerBith;
    }

    public Date getCustomerCreation() {
        return customerCreation;
    }

    public void setCustomerCreation( Date customerCreation ) {
        this.customerCreation = customerCreation;
    }

    public Date getCustomerUpdate() {
        return customerUpdate;
    }

    public void setCustomerUpdate( Date customerUpdate ) {
        this.customerUpdate = customerUpdate;
    }

    public String getCustomerHistory() {
        return customerHistory;
    }

    public void setCustomerHistory( String customerHistory ) {
        this.customerHistory = customerHistory;
    }

    public List<DossierCustom> getCustomerDossier() {
        return customerDossier;
    }

    public void setCustomerDossier( List<DossierCustom> customerDossier ) {
        this.customerDossier = customerDossier;
    }

    public List<EnterpriseCustom> getCustomerEnterprise() {
        return customerEnterprise;
    }

    public void setCustomerEnterprise( List<EnterpriseCustom> customerEnterprise ) {
        this.customerEnterprise = customerEnterprise;
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
        return customerId;
    }

}
