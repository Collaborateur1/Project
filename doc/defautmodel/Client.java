/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9.8
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2016/12/01 ap. J.-C. at 15:46:40 CST
*/
package defaultroot.defautmodel.domain.defautmodel;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import java.io.Serializable;
import javax.persistence.*;
import defaultroot.defautmodel.domain.defautmodel.Avis;
import defaultroot.defautmodel.domain.defautmodel.Notification;
import defaultroot.defautmodel.domain.defautmodel.ReservationClient;
import defaultroot.defautmodel.domain.defautmodel.Adress;
import defaultroot.defautmodel.domain.defautmodel.Adress;
import defaultroot.defautmodel.domain.defautmodel.Attachment;

/**
 *
 * <p>Title: Client</p>
 *
 * <p>Description: Domain Object describing a Client entity</p>
 *
 */
@Entity (name="Client")
@Table (name="\"client\"")
@NamedQueries ({
	 @NamedQuery(name="Client.findAll", query="SELECT a FROM Client a")
	,@NamedQuery(name="Client.findByEmail", query="SELECT a FROM Client a WHERE a.email = :email")
	,@NamedQuery(name="Client.findByEmailContaining", query="SELECT a FROM Client a WHERE a.email like :email")

	,@NamedQuery(name="Client.findByPassword", query="SELECT a FROM Client a WHERE a.password = :password")
	,@NamedQuery(name="Client.findByPasswordContaining", query="SELECT a FROM Client a WHERE a.password like :password")

	,@NamedQuery(name="Client.findByFirstname", query="SELECT a FROM Client a WHERE a.firstname = :firstname")
	,@NamedQuery(name="Client.findByFirstnameContaining", query="SELECT a FROM Client a WHERE a.firstname like :firstname")

	,@NamedQuery(name="Client.findByLastname", query="SELECT a FROM Client a WHERE a.lastname = :lastname")
	,@NamedQuery(name="Client.findByLastnameContaining", query="SELECT a FROM Client a WHERE a.lastname like :lastname")

	,@NamedQuery(name="Client.findByTelephone", query="SELECT a FROM Client a WHERE a.telephone = :telephone")
	,@NamedQuery(name="Client.findByTelephoneContaining", query="SELECT a FROM Client a WHERE a.telephone like :telephone")

	,@NamedQuery(name="Client.findByBirthdate", query="SELECT a FROM Client a WHERE a.birthdate = :birthdate")

})

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Client.findAll";
    public static final String FIND_BY_EMAIL = "Client.findByEmail";
    public static final String FIND_BY_EMAIL_CONTAINING ="Client.findByEmailContaining";
    public static final String FIND_BY_PASSWORD = "Client.findByPassword";
    public static final String FIND_BY_PASSWORD_CONTAINING ="Client.findByPasswordContaining";
    public static final String FIND_BY_FIRSTNAME = "Client.findByFirstname";
    public static final String FIND_BY_FIRSTNAME_CONTAINING ="Client.findByFirstnameContaining";
    public static final String FIND_BY_LASTNAME = "Client.findByLastname";
    public static final String FIND_BY_LASTNAME_CONTAINING ="Client.findByLastnameContaining";
    public static final String FIND_BY_TELEPHONE = "Client.findByTelephone";
    public static final String FIND_BY_TELEPHONE_CONTAINING ="Client.findByTelephoneContaining";
    public static final String FIND_BY_BIRTHDATE = "Client.findByBirthdate";
	
    @Id @Column(name="idclient" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idclient;

//MP-MANAGED-ADDED-AREA-BEGINNING @email-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @email-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-email@
    @Column(name="email"  , length=45 , nullable=false , unique=false)
    private String email; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @password-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @password-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-password@
    @Column(name="password"  , length=45 , nullable=false , unique=false)
    private String password; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @firstname-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @firstname-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-firstname@
    @Column(name="firstname"  , length=45 , nullable=false , unique=false)
    private String firstname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @lastname-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @lastname-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-lastname@
    @Column(name="lastname"  , length=45 , nullable=false , unique=false)
    private String lastname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @telephone-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @telephone-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-telephone@
    @Column(name="telephone"  , length=45 , nullable=true , unique=false)
    private String telephone; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @birthdate-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @birthdate-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-birthdate@
    @Column(name="birthdate"   , nullable=true , unique=false)
    private Date birthdate; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="idhome_address", referencedColumnName = "idadress" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Adress idhomeAddress;  

    @Column(name="idhome_address"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer idhomeAddress_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="idwork_address", referencedColumnName = "idadress" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private Adress idworkAddress;  

    @Column(name="idwork_address"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer idworkAddress_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @avisClientViaIdclient-field-client@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Avis.class, fetch=FetchType.LAZY, mappedBy="idclient", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Avis> avisClientViaIdclient = new HashSet<Avis>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @notificationClientViaClientIdclient-field-client@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Notification.class, fetch=FetchType.LAZY, mappedBy="clientIdclient", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Notification> notificationClientViaClientIdclient = new HashSet<Notification>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reservationClientClientViaIdclient-field-client@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.ReservationClient.class, fetch=FetchType.LAZY, mappedBy="idclient", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <ReservationClient> reservationClientClientViaIdclient = new HashSet<ReservationClient>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-attachmentClientHasAttachmentViaIdattachment-client@
    @ManyToMany
    @JoinTable(name="CLIENT_HAS_ATTACHMENT", 
        joinColumns=@JoinColumn(name="client_idclient"), 
        inverseJoinColumns=@JoinColumn(name="attachment_idattachment") 
    )
    private Set <Attachment> attachmentClientHasAttachmentViaIdattachment = new HashSet <Attachment> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Client() {
    }

	/**
	* All field constructor 
	*/
    public Client(
       Integer idclient,
       String email,
       String password,
       String firstname,
       String lastname,
       String telephone,
       Date birthdate,
       Integer idhomeAddress,
       Integer idworkAddress) {
	 this(
       idclient,
       email,
       password,
       firstname,
       lastname,
       telephone,
       birthdate,
       idhomeAddress,
       idworkAddress
	 ,true);
	}
    
	public Client(
       Integer idclient,
       String email,
       String password,
       String firstname,
       String lastname,
       String telephone,
       Date birthdate,
       Integer idhomeAddress,
       Integer idworkAddress	
    , boolean setRelationship) {
       //primary keys
       setIdclient (idclient);
       //attributes
       setEmail (email);
       setPassword (password);
       setFirstname (firstname);
       setLastname (lastname);
       setTelephone (telephone);
       setBirthdate (birthdate);
       //parents
       if (setRelationship && idhomeAddress!=null) {
          this.idhomeAddress = new Adress();
          this.idhomeAddress.setIdadress(idhomeAddress);
	      setIdhomeAddress_ (idhomeAddress);
       }
       if (setRelationship && idworkAddress!=null) {
          this.idworkAddress = new Adress();
          this.idworkAddress.setIdadress(idworkAddress);
	      setIdworkAddress_ (idworkAddress);
       }
    }

	public Client flat() {
	   return new Client(
          getIdclient(),
          getEmail(),
          getPassword(),
          getFirstname(),
          getLastname(),
          getTelephone(),
          getBirthdate(),
          getIdhomeAddress_(),
          getIdworkAddress_()
       , false
	   );
	}

    public Integer getIdclient() {
        return idclient;
    }
	
    public void setIdclient (Integer idclient) {
        this.idclient =  idclient;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-email@
    public String getEmail() {
        return email;
    }
	
    public void setEmail (String email) {
        this.email =  email;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-password@
    public String getPassword() {
        return password;
    }
	
    public void setPassword (String password) {
        this.password =  password;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-firstname@
    public String getFirstname() {
        return firstname;
    }
	
    public void setFirstname (String firstname) {
        this.firstname =  firstname;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-lastname@
    public String getLastname() {
        return lastname;
    }
	
    public void setLastname (String lastname) {
        this.lastname =  lastname;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-telephone@
    public String getTelephone() {
        return telephone;
    }
	
    public void setTelephone (String telephone) {
        this.telephone =  telephone;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-birthdate@
    public Date getBirthdate() {
        return birthdate;
    }
	
    public void setBirthdate (Date birthdate) {
        this.birthdate =  birthdate;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Adress getIdhomeAddress () {
    	return idhomeAddress;
    }
	
    public void setIdhomeAddress (Adress idhomeAddress) {
    	this.idhomeAddress = idhomeAddress;
    }

    public Integer getIdhomeAddress_() {
        return idhomeAddress_;
    }
	
    public void setIdhomeAddress_ (Integer idhomeAddress) {
        this.idhomeAddress_ =  idhomeAddress;
    }
	
    public Adress getIdworkAddress () {
    	return idworkAddress;
    }
	
    public void setIdworkAddress (Adress idworkAddress) {
    	this.idworkAddress = idworkAddress;
    }

    public Integer getIdworkAddress_() {
        return idworkAddress_;
    }
	
    public void setIdworkAddress_ (Integer idworkAddress) {
        this.idworkAddress_ =  idworkAddress;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @avisClientViaIdclient-getter-client@
    public Set<Avis> getAvisClientViaIdclient() {
        if (avisClientViaIdclient == null){
            avisClientViaIdclient = new HashSet<Avis>();
        }
        return avisClientViaIdclient;
    }

    public void setAvisClientViaIdclient (Set<Avis> avisClientViaIdclient) {
        this.avisClientViaIdclient = avisClientViaIdclient;
    }	
    
    public void addAvisClientViaIdclient (Avis element) {
    	    getAvisClientViaIdclient().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @clientHasAttachmentViaClientByIdclient-getter-client@
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @notificationClientViaClientIdclient-getter-client@
    public Set<Notification> getNotificationClientViaClientIdclient() {
        if (notificationClientViaClientIdclient == null){
            notificationClientViaClientIdclient = new HashSet<Notification>();
        }
        return notificationClientViaClientIdclient;
    }

    public void setNotificationClientViaClientIdclient (Set<Notification> notificationClientViaClientIdclient) {
        this.notificationClientViaClientIdclient = notificationClientViaClientIdclient;
    }	
    
    public void addNotificationClientViaClientIdclient (Notification element) {
    	    getNotificationClientViaClientIdclient().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reservationClientClientViaIdclient-getter-client@
    public Set<ReservationClient> getReservationClientClientViaIdclient() {
        if (reservationClientClientViaIdclient == null){
            reservationClientClientViaIdclient = new HashSet<ReservationClient>();
        }
        return reservationClientClientViaIdclient;
    }

    public void setReservationClientClientViaIdclient (Set<ReservationClient> reservationClientClientViaIdclient) {
        this.reservationClientClientViaIdclient = reservationClientClientViaIdclient;
    }	
    
    public void addReservationClientClientViaIdclient (ReservationClient element) {
    	    getReservationClientClientViaIdclient().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Attachment> getAttachmentClientHasAttachmentViaIdattachment() {
        if (attachmentClientHasAttachmentViaIdattachment == null){
            attachmentClientHasAttachmentViaIdattachment = new HashSet<Attachment>();
        }
        return attachmentClientHasAttachmentViaIdattachment;
    }

    public void setAttachmentClientHasAttachmentViaIdattachment (Set<Attachment> attachmentClientHasAttachmentViaIdattachment) {
        this.attachmentClientHasAttachmentViaIdattachment = attachmentClientHasAttachmentViaIdattachment;
    }
    	
    public void addAttachmentClientHasAttachmentViaIdattachment (Attachment element) {
        getAttachmentClientHasAttachmentViaIdattachment().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
