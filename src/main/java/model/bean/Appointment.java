package model.bean;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import model.dao.Executable;

@Entity
@Table(name="Appointment")
public class Appointment  implements Executable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "appoId")
    private String appoId;
    
    @Column(name="appostartDate") 
    private Date appoStartDate;
    
    @Column(name="appoEndDate") 
    private Date appoEndDate;
    
    @Column(name="appoCreationDate") 
    private Date appoCreationDate;
    
    @Column(name="appoConfirmationDate") 
    private Date appoConfirmationDate;
    
    @Column(name="appoCancelDate") 
    private Date appoCancelDate;
    
    @Column(name="appoNote", length=80) 
    private String appoNote;
    
    @Column(name="appoType", length=16) 
    private String appoType;
    
    @ManyToOne(cascade = CascadeType.MERGE,optional = false)
    @JsonBackReference
    private Hairdresser   appoHairdresser;
    
    @ManyToOne(optional = true)//no mandatory
    @JoinColumn(name="servId")
    private Service appoService;
    
    @ManyToOne(cascade = CascadeType.MERGE,optional = true)
    @JsonBackReference
    private Custumer appoCustumer;

    public String getAppoId() {
        return appoId;
    }

    public void setAppoId( String appoId ) {
        this.appoId = appoId;
    }

    public Date getAppoStartDate() {
        return appoStartDate;
    }

    public void setAppoStartDate( Date appoStartDate ) {
        this.appoStartDate = appoStartDate;
    }

    public Date getAppoEndDate() {
        return appoEndDate;
    }

    public void setAppoEndDate( Date appoEndDate ) {
        this.appoEndDate = appoEndDate;
    }

    public Date getAppoCreationDate() {
        return appoCreationDate;
    }

    public void setAppoCreationDate( Date appoCreationDate ) {
        this.appoCreationDate = appoCreationDate;
    }

    public Date getAppoConfirmationDate() {
        return appoConfirmationDate;
    }

    public void setAppoConfirmationDate( Date appoConfirmationDate ) {
        this.appoConfirmationDate = appoConfirmationDate;
    }

    public Date getAppoCancelDate() {
        return appoCancelDate;
    }

    public void setAppoCancelDate( Date appoCancelDate ) {
        this.appoCancelDate = appoCancelDate;
    }

    public String getAppoNote() {
        return appoNote;
    }

    public void setAppoNote( String appoNote ) {
        this.appoNote = appoNote;
    }

    public String getAppoType() {
        return appoType;
    }

    public void setAppoType( String appoType ) {
        this.appoType = appoType;
    }

    public Hairdresser getAppoHairdresser() {
        return appoHairdresser;
    }

    public void setAppoHairdresser( Hairdresser appoHairdresser ) {
        this.appoHairdresser = appoHairdresser;
    }

    public Service getAppoService() {
        return appoService;
    }

    public void setAppoService( Service appoService ) {
        this.appoService = appoService;
    }

    public Custumer getAppoCustumer() {
        return appoCustumer;
    }

    public void setAppoCustumer( Custumer appoCustomer ) {
        this.appoCustumer = appoCustomer;
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
        return appoId;
    }
    
}
