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
import defaultroot.defautmodel.domain.defautmodel.Notification;
import defaultroot.defautmodel.domain.defautmodel.ReservationClientHasHairdresserHasBuisnessHasService;
import defaultroot.defautmodel.domain.defautmodel.Client;

/**
 *
 * <p>Title: ReservationClient</p>
 *
 * <p>Description: Domain Object describing a ReservationClient entity</p>
 *
 */
@Entity (name="ReservationClient")
@Table (name="\"reservation_client\"")
@NamedQueries ({
	 @NamedQuery(name="ReservationClient.findAll", query="SELECT a FROM ReservationClient a")
	,@NamedQuery(name="ReservationClient.findByDate", query="SELECT a FROM ReservationClient a WHERE a.date = :date")

	,@NamedQuery(name="ReservationClient.findByCreateDatetime", query="SELECT a FROM ReservationClient a WHERE a.createDatetime = :createDatetime")

	,@NamedQuery(name="ReservationClient.findByConfirmDatetime", query="SELECT a FROM ReservationClient a WHERE a.confirmDatetime = :confirmDatetime")

	,@NamedQuery(name="ReservationClient.findByAnnulationDatetime", query="SELECT a FROM ReservationClient a WHERE a.annulationDatetime = :annulationDatetime")

	,@NamedQuery(name="ReservationClient.findByNote", query="SELECT a FROM ReservationClient a WHERE a.note = :note")
	,@NamedQuery(name="ReservationClient.findByNoteContaining", query="SELECT a FROM ReservationClient a WHERE a.note like :note")

})

public class ReservationClient implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "ReservationClient.findAll";
    public static final String FIND_BY_DATE = "ReservationClient.findByDate";
    public static final String FIND_BY_CREATEDATETIME = "ReservationClient.findByCreateDatetime";
    public static final String FIND_BY_CONFIRMDATETIME = "ReservationClient.findByConfirmDatetime";
    public static final String FIND_BY_ANNULATIONDATETIME = "ReservationClient.findByAnnulationDatetime";
    public static final String FIND_BY_NOTE = "ReservationClient.findByNote";
    public static final String FIND_BY_NOTE_CONTAINING ="ReservationClient.findByNoteContaining";
	
    @Id @Column(name="idreservation_client" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idreservationClient;

//MP-MANAGED-ADDED-AREA-BEGINNING @date-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @date-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-date@
    @Column(name="date"   , nullable=false , unique=false)
    private Timestamp date; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @create_datetime-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @create_datetime-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-create_datetime@
    @Column(name="create_datetime"   , nullable=false , unique=false)
    private Timestamp createDatetime; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @confirm_datetime-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @confirm_datetime-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-confirm_datetime@
    @Column(name="confirm_datetime"   , nullable=true , unique=false)
    private Timestamp confirmDatetime; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @annulation_datetime-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @annulation_datetime-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-annulation_datetime@
    @Column(name="annulation_datetime"   , nullable=true , unique=false)
    private Timestamp annulationDatetime; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @note-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @note-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-note@
    @Column(name="note"  , length=2000 , nullable=true , unique=false)
    private String note; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="idclient", referencedColumnName = "idclient" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Client idclient;  

    @Column(name="idclient"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer idclient_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @notificationReservationClientViaIdreservation-field-reservation_client@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Notification.class, fetch=FetchType.LAZY, mappedBy="idreservation", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Notification> notificationReservationClientViaIdreservation = new HashSet<Notification>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient-field-reservation_client@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.ReservationClientHasHairdresserHasBuisnessHasService.class, fetch=FetchType.LAZY, mappedBy="reservationClientHasHairdresserHasBuisnessHasServiceId__.idreservationClient", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <ReservationClientHasHairdresserHasBuisnessHasService> reservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient = new HashSet<ReservationClientHasHairdresserHasBuisnessHasService>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public ReservationClient() {
    }

	/**
	* All field constructor 
	*/
    public ReservationClient(
       Integer idreservationClient,
       Integer idclient,
       Timestamp date,
       Timestamp createDatetime,
       Timestamp confirmDatetime,
       Timestamp annulationDatetime,
       String note) {
	 this(
       idreservationClient,
       idclient,
       date,
       createDatetime,
       confirmDatetime,
       annulationDatetime,
       note
	 ,true);
	}
    
	public ReservationClient(
       Integer idreservationClient,
       Integer idclient,
       Timestamp date,
       Timestamp createDatetime,
       Timestamp confirmDatetime,
       Timestamp annulationDatetime,
       String note	
    , boolean setRelationship) {
       //primary keys
       setIdreservationClient (idreservationClient);
       //attributes
       setDate (date);
       setCreateDatetime (createDatetime);
       setConfirmDatetime (confirmDatetime);
       setAnnulationDatetime (annulationDatetime);
       setNote (note);
       //parents
       if (setRelationship && idclient!=null) {
          this.idclient = new Client();
          this.idclient.setIdclient(idclient);
	      setIdclient_ (idclient);
       }
    }

	public ReservationClient flat() {
	   return new ReservationClient(
          getIdreservationClient(),
          getIdclient_(),
          getDate(),
          getCreateDatetime(),
          getConfirmDatetime(),
          getAnnulationDatetime(),
          getNote()
       , false
	   );
	}

    public Integer getIdreservationClient() {
        return idreservationClient;
    }
	
    public void setIdreservationClient (Integer idreservationClient) {
        this.idreservationClient =  idreservationClient;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-date@
    public Timestamp getDate() {
        return date;
    }
	
    public void setDate (Timestamp date) {
        this.date =  date;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-create_datetime@
    public Timestamp getCreateDatetime() {
        return createDatetime;
    }
	
    public void setCreateDatetime (Timestamp createDatetime) {
        this.createDatetime =  createDatetime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-confirm_datetime@
    public Timestamp getConfirmDatetime() {
        return confirmDatetime;
    }
	
    public void setConfirmDatetime (Timestamp confirmDatetime) {
        this.confirmDatetime =  confirmDatetime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-annulation_datetime@
    public Timestamp getAnnulationDatetime() {
        return annulationDatetime;
    }
	
    public void setAnnulationDatetime (Timestamp annulationDatetime) {
        this.annulationDatetime =  annulationDatetime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-note@
    public String getNote() {
        return note;
    }
	
    public void setNote (String note) {
        this.note =  note;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Client getIdclient () {
    	return idclient;
    }
	
    public void setIdclient (Client idclient) {
    	this.idclient = idclient;
    }

    public Integer getIdclient_() {
        return idclient_;
    }
	
    public void setIdclient_ (Integer idclient) {
        this.idclient_ =  idclient;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @notificationReservationClientViaIdreservation-getter-reservation_client@
    public Set<Notification> getNotificationReservationClientViaIdreservation() {
        if (notificationReservationClientViaIdreservation == null){
            notificationReservationClientViaIdreservation = new HashSet<Notification>();
        }
        return notificationReservationClientViaIdreservation;
    }

    public void setNotificationReservationClientViaIdreservation (Set<Notification> notificationReservationClientViaIdreservation) {
        this.notificationReservationClientViaIdreservation = notificationReservationClientViaIdreservation;
    }	
    
    public void addNotificationReservationClientViaIdreservation (Notification element) {
    	    getNotificationReservationClientViaIdreservation().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient-getter-reservation_client@
    public Set<ReservationClientHasHairdresserHasBuisnessHasService> getReservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient() {
        if (reservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient == null){
            reservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient = new HashSet<ReservationClientHasHairdresserHasBuisnessHasService>();
        }
        return reservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient;
    }

    public void setReservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient (Set<ReservationClientHasHairdresserHasBuisnessHasService> reservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient) {
        this.reservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient = reservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient;
    }	
    
    public void addReservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient (ReservationClientHasHairdresserHasBuisnessHasService element) {
    	    getReservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
