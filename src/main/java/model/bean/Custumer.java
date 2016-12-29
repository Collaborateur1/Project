package model.bean;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import model.dao.Executable;

@Entity
@Table(name="Custumer")
@DynamicUpdate
public class Custumer  implements Executable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "custId")
    private String custId;
    
    @Column(name="custFirstName",length=30)
    private String custFirstName;
    
    @Column(name="custLastName",length=30)
    private String custLastName;
    
    
    @Column(name="custNumber",length=16)
    private String custNumber;
    
    @Column(name="custEmail",length=50) 
    private String custEmail;
    
    @JsonIgnore
    @Column(name="custMdp",length=50)
    private String custMdp;
    
    @Column(name="custPict",length=80)
    private String custPict;
    
    
    @JsonIgnore
    @Column(name="custToken",length=100)
    private String custToken;
    
    @Transient
    @JsonIgnore
    private String custIp;
    
    @BatchSize(size=10)
    @OneToMany(fetch = FetchType.LAZY,mappedBy="appoCustumer",cascade = CascadeType.MERGE)
    private List<Appointment> custAppointments;

    public String getCustId() {
        return custId;
    }

    public void setCustId( String custId ) {
        this.custId = custId;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName( String custFirstName ) {
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName( String custLastName ) {
        this.custLastName = custLastName;
    }

    public String getCustNumber() {
        return custNumber;
    }

    public void setCustNumber( String custNumber ) {
        this.custNumber = custNumber;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail( String custEmail ) {
        this.custEmail = custEmail;
    }

    public String getCustMdp() {
        return custMdp;
    }

    public void setCustMdp( String custMdp ) {
        this.custMdp = custMdp;
    }

    public String getCustPict() {
        return custPict;
    }

    public void setCustPict( String custPict ) {
        this.custPict = custPict;
    }

    public String getCustToken() {
        return custToken;
    }

    public void setCustToken( String custToken ) {
        this.custToken = custToken;
    }

    public String getCustIp() {
        return custIp;
    }

    public void setCustIp( String custIp ) {
        this.custIp = custIp;
    }

    public List<Appointment> getCustAppointments() {
        return custAppointments;
    }

    public void setCustAppointments( List<Appointment> custAppointments ) {
        this.custAppointments = custAppointments;
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
        return custId;
    }
    
}
