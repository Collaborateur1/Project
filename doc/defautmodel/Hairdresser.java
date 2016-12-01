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
import defaultroot.defautmodel.domain.defautmodel.Break;
import defaultroot.defautmodel.domain.defautmodel.HairdresserHasBuisnessHasService;
import defaultroot.defautmodel.domain.defautmodel.ReservationPro;
import defaultroot.defautmodel.domain.defautmodel.Schedule;
import defaultroot.defautmodel.domain.defautmodel.Attachment;
import defaultroot.defautmodel.domain.defautmodel.Buisness;

/**
 *
 * <p>Title: Hairdresser</p>
 *
 * <p>Description: Domain Object describing a Hairdresser entity</p>
 *
 */
@Entity (name="Hairdresser")
@Table (name="\"hairdresser\"")
@NamedQueries ({
	 @NamedQuery(name="Hairdresser.findAll", query="SELECT a FROM Hairdresser a")
	,@NamedQuery(name="Hairdresser.findByLastname", query="SELECT a FROM Hairdresser a WHERE a.lastname = :lastname")
	,@NamedQuery(name="Hairdresser.findByLastnameContaining", query="SELECT a FROM Hairdresser a WHERE a.lastname like :lastname")

	,@NamedQuery(name="Hairdresser.findByFirstname", query="SELECT a FROM Hairdresser a WHERE a.firstname = :firstname")
	,@NamedQuery(name="Hairdresser.findByFirstnameContaining", query="SELECT a FROM Hairdresser a WHERE a.firstname like :firstname")

	,@NamedQuery(name="Hairdresser.findByTelephone", query="SELECT a FROM Hairdresser a WHERE a.telephone = :telephone")
	,@NamedQuery(name="Hairdresser.findByTelephoneContaining", query="SELECT a FROM Hairdresser a WHERE a.telephone like :telephone")

	,@NamedQuery(name="Hairdresser.findByEmail", query="SELECT a FROM Hairdresser a WHERE a.email = :email")
	,@NamedQuery(name="Hairdresser.findByEmailContaining", query="SELECT a FROM Hairdresser a WHERE a.email like :email")

})

public class Hairdresser implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Hairdresser.findAll";
    public static final String FIND_BY_LASTNAME = "Hairdresser.findByLastname";
    public static final String FIND_BY_LASTNAME_CONTAINING ="Hairdresser.findByLastnameContaining";
    public static final String FIND_BY_FIRSTNAME = "Hairdresser.findByFirstname";
    public static final String FIND_BY_FIRSTNAME_CONTAINING ="Hairdresser.findByFirstnameContaining";
    public static final String FIND_BY_TELEPHONE = "Hairdresser.findByTelephone";
    public static final String FIND_BY_TELEPHONE_CONTAINING ="Hairdresser.findByTelephoneContaining";
    public static final String FIND_BY_EMAIL = "Hairdresser.findByEmail";
    public static final String FIND_BY_EMAIL_CONTAINING ="Hairdresser.findByEmailContaining";
	
    @Id @Column(name="idhairdresser" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idhairdresser;

//MP-MANAGED-ADDED-AREA-BEGINNING @lastname-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @lastname-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-lastname@
    @Column(name="lastname"  , length=45 , nullable=false , unique=false)
    private String lastname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @firstname-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @firstname-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-firstname@
    @Column(name="firstname"  , length=45 , nullable=false , unique=false)
    private String firstname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @telephone-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @telephone-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-telephone@
    @Column(name="telephone"  , length=45 , nullable=false , unique=false)
    private String telephone; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @email-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @email-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-email@
    @Column(name="email"  , length=45 , nullable=false , unique=false)
    private String email; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="profile_picture", referencedColumnName = "idattachment" , nullable=true , unique=false , insertable=true, updatable=true) 
    private Attachment profilePicture;  

    @Column(name="profile_picture"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer profilePicture_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="idbuisness", referencedColumnName = "idbuisness" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Buisness idbuisness;  

    @Column(name="idbuisness"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer idbuisness_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @breakHairdresserViaHairdresserIdhairdresser-field-hairdresser@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Break.class, fetch=FetchType.LAZY, mappedBy="hairdresserIdhairdresser", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Break> breakHairdresserViaHairdresserIdhairdresser = new HashSet<Break>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser-field-hairdresser@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.HairdresserHasBuisnessHasService.class, fetch=FetchType.LAZY, mappedBy="hairdresserHasBuisnessHasServiceId__.idhairdresser", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <HairdresserHasBuisnessHasService> hairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser = new HashSet<HairdresserHasBuisnessHasService>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reservationProHairdresserViaHairdresserIdhairdresser-field-hairdresser@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.ReservationPro.class, fetch=FetchType.LAZY, mappedBy="hairdresserIdhairdresser", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <ReservationPro> reservationProHairdresserViaHairdresserIdhairdresser = new HashSet<ReservationPro>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scheduleHairdresserViaHairdresserIdhairdresser-field-hairdresser@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Schedule.class, fetch=FetchType.LAZY, mappedBy="hairdresserIdhairdresser", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Schedule> scheduleHairdresserViaHairdresserIdhairdresser = new HashSet<Schedule>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Hairdresser() {
    }

	/**
	* All field constructor 
	*/
    public Hairdresser(
       Integer idhairdresser,
       String lastname,
       String firstname,
       String telephone,
       String email,
       Integer profilePicture,
       Integer idbuisness) {
	 this(
       idhairdresser,
       lastname,
       firstname,
       telephone,
       email,
       profilePicture,
       idbuisness
	 ,true);
	}
    
	public Hairdresser(
       Integer idhairdresser,
       String lastname,
       String firstname,
       String telephone,
       String email,
       Integer profilePicture,
       Integer idbuisness	
    , boolean setRelationship) {
       //primary keys
       setIdhairdresser (idhairdresser);
       //attributes
       setLastname (lastname);
       setFirstname (firstname);
       setTelephone (telephone);
       setEmail (email);
       //parents
       if (setRelationship && profilePicture!=null) {
          this.profilePicture = new Attachment();
          this.profilePicture.setIdattachment(profilePicture);
	      setProfilePicture_ (profilePicture);
       }
       if (setRelationship && idbuisness!=null) {
          this.idbuisness = new Buisness();
          this.idbuisness.setIdbuisness(idbuisness);
	      setIdbuisness_ (idbuisness);
       }
    }

	public Hairdresser flat() {
	   return new Hairdresser(
          getIdhairdresser(),
          getLastname(),
          getFirstname(),
          getTelephone(),
          getEmail(),
          getProfilePicture_(),
          getIdbuisness_()
       , false
	   );
	}

    public Integer getIdhairdresser() {
        return idhairdresser;
    }
	
    public void setIdhairdresser (Integer idhairdresser) {
        this.idhairdresser =  idhairdresser;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-lastname@
    public String getLastname() {
        return lastname;
    }
	
    public void setLastname (String lastname) {
        this.lastname =  lastname;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-telephone@
    public String getTelephone() {
        return telephone;
    }
	
    public void setTelephone (String telephone) {
        this.telephone =  telephone;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-email@
    public String getEmail() {
        return email;
    }
	
    public void setEmail (String email) {
        this.email =  email;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Attachment getProfilePicture () {
    	return profilePicture;
    }
	
    public void setProfilePicture (Attachment profilePicture) {
    	this.profilePicture = profilePicture;
    }

    public Integer getProfilePicture_() {
        return profilePicture_;
    }
	
    public void setProfilePicture_ (Integer profilePicture) {
        this.profilePicture_ =  profilePicture;
    }
	
    public Buisness getIdbuisness () {
    	return idbuisness;
    }
	
    public void setIdbuisness (Buisness idbuisness) {
    	this.idbuisness = idbuisness;
    }

    public Integer getIdbuisness_() {
        return idbuisness_;
    }
	
    public void setIdbuisness_ (Integer idbuisness) {
        this.idbuisness_ =  idbuisness;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @breakHairdresserViaHairdresserIdhairdresser-getter-hairdresser@
    public Set<Break> getBreakHairdresserViaHairdresserIdhairdresser() {
        if (breakHairdresserViaHairdresserIdhairdresser == null){
            breakHairdresserViaHairdresserIdhairdresser = new HashSet<Break>();
        }
        return breakHairdresserViaHairdresserIdhairdresser;
    }

    public void setBreakHairdresserViaHairdresserIdhairdresser (Set<Break> breakHairdresserViaHairdresserIdhairdresser) {
        this.breakHairdresserViaHairdresserIdhairdresser = breakHairdresserViaHairdresserIdhairdresser;
    }	
    
    public void addBreakHairdresserViaHairdresserIdhairdresser (Break element) {
    	    getBreakHairdresserViaHairdresserIdhairdresser().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser-getter-hairdresser@
    public Set<HairdresserHasBuisnessHasService> getHairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser() {
        if (hairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser == null){
            hairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser = new HashSet<HairdresserHasBuisnessHasService>();
        }
        return hairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser;
    }

    public void setHairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser (Set<HairdresserHasBuisnessHasService> hairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser) {
        this.hairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser = hairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser;
    }	
    
    public void addHairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser (HairdresserHasBuisnessHasService element) {
    	    getHairdresserHasBuisnessHasServiceHairdresserViaIdhairdresser().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reservationProHairdresserViaHairdresserIdhairdresser-getter-hairdresser@
    public Set<ReservationPro> getReservationProHairdresserViaHairdresserIdhairdresser() {
        if (reservationProHairdresserViaHairdresserIdhairdresser == null){
            reservationProHairdresserViaHairdresserIdhairdresser = new HashSet<ReservationPro>();
        }
        return reservationProHairdresserViaHairdresserIdhairdresser;
    }

    public void setReservationProHairdresserViaHairdresserIdhairdresser (Set<ReservationPro> reservationProHairdresserViaHairdresserIdhairdresser) {
        this.reservationProHairdresserViaHairdresserIdhairdresser = reservationProHairdresserViaHairdresserIdhairdresser;
    }	
    
    public void addReservationProHairdresserViaHairdresserIdhairdresser (ReservationPro element) {
    	    getReservationProHairdresserViaHairdresserIdhairdresser().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scheduleHairdresserViaHairdresserIdhairdresser-getter-hairdresser@
    public Set<Schedule> getScheduleHairdresserViaHairdresserIdhairdresser() {
        if (scheduleHairdresserViaHairdresserIdhairdresser == null){
            scheduleHairdresserViaHairdresserIdhairdresser = new HashSet<Schedule>();
        }
        return scheduleHairdresserViaHairdresserIdhairdresser;
    }

    public void setScheduleHairdresserViaHairdresserIdhairdresser (Set<Schedule> scheduleHairdresserViaHairdresserIdhairdresser) {
        this.scheduleHairdresserViaHairdresserIdhairdresser = scheduleHairdresserViaHairdresserIdhairdresser;
    }	
    
    public void addScheduleHairdresserViaHairdresserIdhairdresser (Schedule element) {
    	    getScheduleHairdresserViaHairdresserIdhairdresser().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
