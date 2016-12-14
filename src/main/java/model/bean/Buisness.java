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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import model.dao.Executable;

@Entity
@Table(name="Buisness")
public class Buisness  implements Executable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "buisId")
    private String buisId;
    
    @Column(name = "buisName", length=60) 
    private String buisName;
    
    @Column(name = "buisConfirmation")
    private boolean buisConfirmation;
    
    @Column(name = "buisDescription",length=800) 
    private String buisDescription;
    
    @Column(name = "buisLongitude") 
    private double buisLongitude;
    
    @Column(name = "buisLatitude") 
    private double buisLatitude;
    
    @Column(name="buisAdress1",length=60) 
    private String buisAdress1;
    
    @Column(name="buisAdress2",length=60) 
    private String buisAdress2;
    
    @Column(name="buisZipCode",length=10) 
    private String buisZipCode;
    
    @Column(name="buisCountry",length=20) 
    private String buisCountry;
    
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy="hairBuisness", cascade = { CascadeType.ALL})
    private List<Hairdresser> buisHairdressers;
    
   
    
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name="buisness_attachment", 
    joinColumns=@JoinColumn(name="buisId"),
    inverseJoinColumns=@JoinColumn(name="attaId"))
    private List<Attachment> buisAttachmentBuisness;
    
    @ManyToOne(optional = false)//mandatory
    @JoinColumn(name="buisTypeId")
    private BuisnessType buisBuisType;
    
    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name="buisness_tag", 
    joinColumns=@JoinColumn(name="buisId"),
    inverseJoinColumns=@JoinColumn(name="tagId"))
    private List<Tag> buisTags;

    public String getBuisAdress1() {
        return buisAdress1;
    }

    public void setBuisAdress1( String buisAdress1 ) {
        this.buisAdress1 = buisAdress1;
    }

    public String getBuisAdress2() {
        return buisAdress2;
    }

    public void setBuisAdress2( String buisAdress2 ) {
        this.buisAdress2 = buisAdress2;
    }

    public String getBuisZipCode() {
        return buisZipCode;
    }

    public void setBuisZipCode( String buisZipCode ) {
        this.buisZipCode = buisZipCode;
    }

    public String getBuisCountry() {
        return buisCountry;
    }

    public void setBuisCountry( String buisCountry ) {
        this.buisCountry = buisCountry;
    }

    public String getBuisId() {
        return buisId;
    }

    public void setBuisId( String buisId ) {
        this.buisId = buisId;
    }

    public String getBuisName() {
        return buisName;
    }

    public void setBuisName( String buisName ) {
        this.buisName = buisName;
    }

    public boolean isBuisConfirmation() {
        return buisConfirmation;
    }

    public void setBuisConfirmation( boolean buisConfirmation ) {
        this.buisConfirmation = buisConfirmation;
    }

    public String getBuisDescription() {
        return buisDescription;
    }

    public void setBuisDescription( String buisDescription ) {
        this.buisDescription = buisDescription;
    }

    public List<Hairdresser> getBuisHairdressers() {
        return buisHairdressers;
    }

    public void setBuisHairdressers( List<Hairdresser> buisHairdressers ) {
        this.buisHairdressers = buisHairdressers;
    }

    public List<Attachment> getBuisAttachmentBuisness() {
        return buisAttachmentBuisness;
    }

    public void setBuisAttachmentBuisness( List<Attachment> buisAttachmentBuisness ) {
        this.buisAttachmentBuisness = buisAttachmentBuisness;
    }

    public BuisnessType getBuisBuisType() {
        return buisBuisType;
    }

    public void setBuisBuisType( BuisnessType buisBuisType ) {
        this.buisBuisType = buisBuisType;
    }

    public List<Tag> getBuisTags() {
        return buisTags;
    }

    public void setBuisTags( List<Tag> buisTags ) {
        this.buisTags = buisTags;
    }

    public double getBuisLongitude() {
        return buisLongitude;
    }

    public void setBuisLongitude( double buisLongitude ) {
        this.buisLongitude = buisLongitude;
    }

    public double getBuisLatitude() {
        return buisLatitude;
    }

    public void setBuisLatitude( double buisLatitude ) {
        this.buisLatitude = buisLatitude;
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
        return buisId;
    }
    
    
}
