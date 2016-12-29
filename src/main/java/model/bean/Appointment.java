package model.bean;

import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

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
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime appoStartDate;
    
    @Column(name="appoEndDate")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime appoEndDate;
    
    @Column(name="appoCreationDate")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime appoCreationDate;
    
    @Column(name="appoConfirmationDate")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime appoConfirmationDate;
    
    @Column(name="appoCancelDate")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime appoCancelDate;
    
    @Column(name="appoNote", length=80) 
    private String appoNote;
    
    @Column(name="appoType", length=16) 
    private String appoType;
    
    @ManyToOne(cascade = CascadeType.MERGE,optional = false,fetch = FetchType.LAZY)
    @JsonBackReference
    private Hairdresser   appoHairdresser;
    
    @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = CascadeType.MERGE)//no mandatory
    @JoinColumn(name="servId")
    private Service appoService;
    
    @ManyToOne(cascade = CascadeType.MERGE,optional = true,fetch = FetchType.LAZY)
    @JsonBackReference
    private Custumer appoCustumer;

    public String getAppoId() {
        return appoId;
    }

    public void setAppoId( String appoId ) {
        this.appoId = appoId;
    }

    public DateTime getAppoStartDate() {
        return appoStartDate;
    }

    public void setAppoStartDate( DateTime appoStartDate ) {
        this.appoStartDate = appoStartDate;
    }

    public DateTime getAppoEndDate() {
        return appoEndDate;
    }

    public void setAppoEndDate( DateTime appoEndDate ) {
        this.appoEndDate = appoEndDate;
    }

    public DateTime getAppoCreationDate() {
        return appoCreationDate;
    }

    public void setAppoCreationDate( DateTime appoCreationDate ) {
        this.appoCreationDate = appoCreationDate;
    }

    public DateTime getAppoConfirmationDate() {
        return appoConfirmationDate;
    }

    public void setAppoConfirmationDate( DateTime appoConfirmationDate ) {
        this.appoConfirmationDate = appoConfirmationDate;
    }

    public DateTime getAppoCancelDate() {
        return appoCancelDate;
    }

    public void setAppoCancelDate( DateTime appoCancelDate ) {
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
