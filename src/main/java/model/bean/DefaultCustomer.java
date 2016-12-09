package model.bean;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import model.custom.EnterpriseCustom;
import model.dao.Executable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DefaultCustomer implements Executable{
    private static Logger logger = Logger.getLogger( DefaultCustomer.class);
    public enum civility  {
        Mr, Mrs, Ms
    };
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "cusID")
    private String             cusID;

    @Column( name = "cusCivility" )
    private String           cusCivility;

    @Column( name = "cusName" )
    private String             cusName;

    @Column( name = "cusFirstName" )
    private String             cusFirstName;

    @Column( name = "cusNumber" )
    private String             cusNumber;

    @Column( name = "cusMail" )
    private String             cusMail;

    @Column( name = "cusAddresse" )
    private String             cusAddresse;

    @Column( name = "cusBith" )
    private Date               cusBith;

    @Column( name = "cusCreation" )
    private Date               cusCreation;

    @Column( name = "cusUpdate" )
    private Date               cusUpdate;

    @Column( name = "cusHistory" )
    private String             cusHistory;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "entCustomers")
    private List<EnterpriseCustom> cusEnterprise;

  

   
    public String getCusID() {
        return cusID;
    }

    public void setCusID( String cusID ) {
        this.cusID = cusID;
    }

    public String getCusCivility() {
        return cusCivility;
    }

    public void setCusCivility( String cusCivility ) {
        try{
            civility.valueOf( cusCivility );
            this.cusCivility = cusCivility;
        }catch(IllegalArgumentException ilarge){
            logger.error( "Civility argument: "+cusCivility+ " don't match with autorized values  Mr, Mrs or Ms "+ilarge );
        }catch(NullPointerException nulpte){
            logger.error(nulpte);
        }
       
        
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName( String cusName ) {
        this.cusName = cusName;
    }

    public String getCusFirstName() {
        return cusFirstName;
    }

    public void setCusFirstName( String cusFirstName ) {
        this.cusFirstName = cusFirstName;
    }

    public String getCusNumber() {
        return cusNumber;
    }

    public void setCusNumber( String cusNumber ) {
        this.cusNumber = cusNumber;
    }

    public String getCusMail() {
        return cusMail;
    }

    public void setCusMail( String cusMail ) {
        this.cusMail = cusMail;
    }

    public String getCusAddresse() {
        return cusAddresse;
    }

    public void setCusAddresse( String cusAddresse ) {
        this.cusAddresse = cusAddresse;
    }

    public Date getCusBith() {
        return cusBith;
    }

    public void setCusBith( Date cusBith ) {
        this.cusBith = cusBith;
    }

    public Date getCusCreation() {
        return cusCreation;
    }

    public void setCusCreation( Date cusCreation ) {
        this.cusCreation = cusCreation;
    }

    public Date getCusUpdate() {
        return cusUpdate;
    }

    public void setCusUpdate( Date cusUpdate ) {
        this.cusUpdate = cusUpdate;
    }

    public String getCusHistory() {
        return cusHistory;
    }

    public void setCusHistory( String cusHistory ) {
        this.cusHistory = cusHistory;
    }

    public List<EnterpriseCustom> getCusEnterprise() {
        return cusEnterprise;
    }

    public void setCusEnterprise( List<EnterpriseCustom> cusEnterprise ) {
        this.cusEnterprise = cusEnterprise;
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
        return null;
    }

}
