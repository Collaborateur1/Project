package model.bean;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import model.dao.Executable;

@Entity
@Table(name="Hairdresser")
public class Hairdresser implements Executable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "hairId")
    private String hairId;
    
    @Column(name="hairFirstName",length=30) 
    private String hairFirstName;
    
    @Column(name="hairLastName",length=30) 
    private String hairLastName;
    
    
    @Column(name="hairNumber",length=16) 
    private String hairNumber;
    
    @Column(name="hairEmail",length=50) 
    private String hairEmail;
    
    @Column(name="hairPict",length=80) 
    private String hairPict;
    
    @Column(name="hairAdress1",length=60) 
    private String hairAdress1;
    
    @Column(name="hairAdress2",length=60) 
    private String hairAdress2;
    
    @Column(name="hairZipCode",length=10) 
    private String hairZipCode;
    
    @Column(name="hairCountry",length=20) 
    private String hairCountry;
    
    @Column(name="hairIsManager") 
    private boolean hairIsManager;
    
    @Column(name="hairIsActif") 
    private boolean hairIsActif;
    
    @Column(name="hairBirthDate")
    private Date hairBirthDate;
    
    @JsonIgnore
    @Column(name="hairParameters",length=4000)
    StringBuffer hairParameters;
    
    @JsonIgnore
    @Column(name="hairToken",length=100)
    private String hairToken;
    
    @Transient
    @JsonIgnore
    private String hairIp;
    
    @Transient
    @JsonIgnore
    private static String hairSearchRequest=searchRequest();
    
   
    public String getHairAdress1() {
        return hairAdress1;
    }

    public void setHairAdress1( String hairAdress1 ) {
        this.hairAdress1 = hairAdress1;
    }

    public String getHairAdress2() {
        return hairAdress2;
    }

    public void setHairAdress2( String hairAdress2 ) {
        this.hairAdress2 = hairAdress2;
    }

    public String getHairZipCode() {
        return hairZipCode;
    }

    public void setHairZipCode( String hairZipCode ) {
        this.hairZipCode = hairZipCode;
    }

    public String getHairCountry() {
        return hairCountry;
    }

    public void setHairCountry( String hairCountry ) {
        this.hairCountry = hairCountry;
    }

    //@BatchSize(size=10)
    @JsonManagedReference
    @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.MERGE )//if the service don't exist we don't save 
    @JoinTable( name = "Service_Hairdresser", joinColumns = {
            @JoinColumn( name = "hairId", nullable = false, updatable = false ) }, inverseJoinColumns = {
                    @JoinColumn( name = "servId", nullable = false, updatable = false ) })
    private List<Service> hairServices;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy="scheHairdresser",cascade = CascadeType.ALL)
    private List<Schedule> hairSchedules;
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="hairBuisId")
    @JsonBackReference
    private Buisness   hairBuisness;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy="appoHairdresser")
    private List<Appointment> hairAppointments;
    
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name="hairdresser_attachment", 
    joinColumns=@JoinColumn(name="hairid"),
    inverseJoinColumns=@JoinColumn(name="attaId"))
    private List<Attachment> hairAttachmentHairdressers;
    
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name="hairdresser_tag", 
    joinColumns=@JoinColumn(name="hairid"),
    inverseJoinColumns=@JoinColumn(name="tagId"))
    private List<Tag> hairTags;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="reviHairdresser")
    private List<Review> hairReviews;
    
    public String getHairLastName() {
        return hairLastName;
    }

    public void setHairLastName( String hairLastName ) {
        this.hairLastName = hairLastName;
    }

    public List<Tag> getHairTags() {
        return hairTags;
    }

    public void setHairTags( List<Tag> hairTags ) {
        this.hairTags = hairTags;
    }

    public List<Review> getHairReviews() {
        return hairReviews;
    }

    public void setHairReviews( List<Review> hairReviews ) {
        this.hairReviews = hairReviews;
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
    
    @JsonIgnore
    @Override
    public String getID() throws Exception {
        // TODO Auto-generated method stub
        return hairId;
    }
    
    public String getBussnessName() throws Exception {
        // TODO Auto-generated method stub
       if(hairBuisness!=null)
        return hairBuisness.getBuisName();
       return"";
    }
    
    public String getBussnessId() throws Exception {
        if(hairBuisness!=null)
            return hairBuisness.getBuisId();
           return"";
    }

    public String getHairId() {
        return hairId;
    }

    public void setHairId( String hairId ) {
        this.hairId = hairId;
    }

    public String getHairFirstName() {
        return hairFirstName;
    }

    public void setHairFirstName( String hairFirstName ) {
        this.hairFirstName = hairFirstName;
    }


    public String getHairNumber() {
        return hairNumber;
    }

    public void setHairNumber( String hairNumber ) {
        this.hairNumber = hairNumber;
    }

    public String getHairEmail() {
        return hairEmail;
    }

    public void setHairEmail( String hairEmail ) {
        this.hairEmail = hairEmail;
    }

    public String getHairPict() {
        return hairPict;
    }

    public void setHairPict( String hairPict ) {
        this.hairPict = hairPict;
    }

    public boolean isHairIsManager() {
        return hairIsManager;
    }

    public void setHairIsManager( boolean hairIsManager ) {
        this.hairIsManager = hairIsManager;
    }

    public boolean isHairIsActif() {
        return hairIsActif;
    }

    public void setHairIsActif( boolean hairIsActif ) {
        this.hairIsActif = hairIsActif;
    }

    public Date getHairBirthDate() {
        return hairBirthDate;
    }

    public void setHairBirthDate( Date hairBirthDate ) {
        this.hairBirthDate = hairBirthDate;
    }

    public StringBuffer getHairParameters() {
        return hairParameters;
    }

    public void setHairParameters( StringBuffer hairParameters ) {
        this.hairParameters = hairParameters;
    }

    public String getHairToken() {
        return hairToken;
    }

    public void setHairToken( String hairToken ) {
        this.hairToken = hairToken;
    }

    public String getHairIp() {
        return hairIp;
    }

    public void setHairIp( String hairIp ) {
        this.hairIp = hairIp;
    }

    public List<Service> getHairServices() {
        return hairServices;
    }

    public void setHairServices( List<Service> hairServices ) {
        this.hairServices = hairServices;
    }

    public List<Schedule> getHairSchedules() {
        return hairSchedules;
    }

    public void setHairSchedules( List<Schedule> hairSchedules ) {
        this.hairSchedules = hairSchedules;
    }

    public Buisness getHairBuisness() {
        return hairBuisness;
    }

    public void setHairBuisness( Buisness hairBuisness ) {
        this.hairBuisness = hairBuisness;
    }

    public List<Appointment> getHairAppointments() {
        return hairAppointments;
    }

    public void setHairAppointments( List<Appointment> hairAppointments ) {
        this.hairAppointments = hairAppointments;
    }

    public List<Attachment> getHairAttachmentHairdressers() {
        return hairAttachmentHairdressers;
    }

    public void setHairAttachmentHairdressers( List<Attachment> hairAttachmentHairdressers ) {
        this.hairAttachmentHairdressers = hairAttachmentHairdressers;
    }
private static String searchRequest(){
   
        
        StringBuffer st=new StringBuffer();
        st.append("SELECT distinct(hairdresser.hairid) AS hairid, hairdresser.hairfirstname      AS hairfirstname,"
                + " hairdresser.hairlastname AS hairlastname, hairdresser.hairpict           AS hairpict, "
                + "hairdresser.hairzipcode        AS hairzipcode, buisness.buisname    AS buisname,"
                + "buisness.buisadress1 AS buisadress1, buisness.buisadress2 AS buisadress2, "
                + "buisness.buiszipcode AS buiszipcode FROM Hairdresser hairdresser"
                + " LEFT OUTER JOIN Buisness buisness ON  hairdresser.hairbuisid=buisness.buisid " );
        
    
    return st.toString();
}
 
public static String getHairSearchRequest(){

return hairSearchRequest;
}
}
