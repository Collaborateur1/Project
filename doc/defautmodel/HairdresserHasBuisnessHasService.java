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
import defaultroot.defautmodel.domain.defautmodel.ReservationClientHasHairdresserHasBuisnessHasService;
import defaultroot.defautmodel.domain.defautmodel.BuisnessHasService;
import defaultroot.defautmodel.domain.defautmodel.Hairdresser;
import defaultroot.defautmodel.domain.defautmodel.HairdresserHasBuisnessHasServiceId;

/**
 *
 * <p>Title: HairdresserHasBuisnessHasService</p>
 *
 * <p>Description: Domain Object describing a HairdresserHasBuisnessHasService entity</p>
 *
 */
@Entity (name="HairdresserHasBuisnessHasService")
@Table (name="\"hairdresser_has_buisness_has_service\"")
@NamedQueries ({
	 @NamedQuery(name="HairdresserHasBuisnessHasService.findAll", query="SELECT a FROM HairdresserHasBuisnessHasService a")
})

public class HairdresserHasBuisnessHasService implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "HairdresserHasBuisnessHasService.findAll";
    public static final String FIND_BY_IDSERVICE_CONTAINING ="HairdresserHasBuisnessHasService.findByIdserviceContaining";
	
    @EmbeddedId
    public HairdresserHasBuisnessHasServiceId hairdresserHasBuisnessHasServiceId__;     @Column(name="idservice"  , nullable=false , unique=false , insertable=false, updatable=false)
    private Integer idservice_;
    @MapsId ("idbuisness")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="idbuisness", referencedColumnName = "buisness_idbuisness" , nullable=false , unique=false , insertable=true, updatable=true) 
    private BuisnessHasService buisnessidbuisnessidservice;  

    @Column(name="idbuisness"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer buisnessidbuisnessidservice_;

    @MapsId ("idhairdresser")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="idhairdresser", referencedColumnName = "idhairdresser" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Hairdresser idhairdresser;  

    @Column(name="idhairdresser"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer idhairdresser_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser-field-hairdresser_has_buisness_has_service@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.ReservationClientHasHairdresserHasBuisnessHasService.class, fetch=FetchType.LAZY, mappedBy="reservationClientHasHairdresserHasBuisnessHasServiceId__.idhairdresser", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <ReservationClientHasHairdresserHasBuisnessHasService> reservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser = new HashSet<ReservationClientHasHairdresserHasBuisnessHasService>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public HairdresserHasBuisnessHasService() {
    }

	/**
	* All field constructor 
	*/
    public HairdresserHasBuisnessHasService(
       Integer idhairdresser,
       Integer idbuisness,
       Integer idservice) {
	 this(
       idhairdresser,
       idbuisness,
       idservice
	 ,true);
	}
    
	public HairdresserHasBuisnessHasService(
       Integer idhairdresser,
       Integer idbuisness,
       Integer idservice	
    , boolean setRelationship) {
       //primary keys
       this.hairdresserHasBuisnessHasServiceId__ = new HairdresserHasBuisnessHasServiceId();  	
       this.hairdresserHasBuisnessHasServiceId__.setIdservice (idservice);
       //attributes
       //parents
       if (setRelationship && idbuisness!=null) {
          this.buisnessidbuisnessidservice = new BuisnessHasService();
          this.buisnessidbuisnessidservice.setBuisnessIdbuisness(idbuisness);
       }
       if (setRelationship && idhairdresser!=null) {
          this.idhairdresser = new Hairdresser();
          this.idhairdresser.setIdhairdresser(idhairdresser);
       }
    }

	public HairdresserHasBuisnessHasService flat() {
	   return new HairdresserHasBuisnessHasService(
		  getHairdresserHasBuisnessHasServiceId__().getIdhairdresser(),
		  getHairdresserHasBuisnessHasServiceId__().getIdbuisness(),
		  getHairdresserHasBuisnessHasServiceId__().getIdservice()
       , false
	   );
	}


    public HairdresserHasBuisnessHasServiceId getHairdresserHasBuisnessHasServiceId__() {
		if (hairdresserHasBuisnessHasServiceId__==null) hairdresserHasBuisnessHasServiceId__ = new HairdresserHasBuisnessHasServiceId();
        return hairdresserHasBuisnessHasServiceId__;
    }
	
    public void setHairdresserHasBuisnessHasServiceId__ (HairdresserHasBuisnessHasServiceId hairdresserHasBuisnessHasServiceId__) {
        this.hairdresserHasBuisnessHasServiceId__ =  hairdresserHasBuisnessHasServiceId__;
    }
    public Integer getIdservice_() {
        return idservice_;
    }
	
    public void setIdservice_ (Integer idservice) {
        this.idservice_ =  idservice_;
    }
    

    public BuisnessHasService getBuisnessidbuisnessidservice () {
    	return buisnessidbuisnessidservice;
    }
	
    public void setBuisnessidbuisnessidservice (BuisnessHasService buisnessidbuisnessidservice) {
    	this.buisnessidbuisnessidservice = buisnessidbuisnessidservice;
    }

    public Integer getBuisnessidbuisnessidservice_() {
        return buisnessidbuisnessidservice_;
    }
	
    public void setBuisnessidbuisnessidservice_ (Integer buisnessidbuisnessidservice) {
        this.buisnessidbuisnessidservice_ =  buisnessidbuisnessidservice;
    }
	
    public Hairdresser getIdhairdresser () {
    	return idhairdresser;
    }
	
    public void setIdhairdresser (Hairdresser idhairdresser) {
    	this.idhairdresser = idhairdresser;
    }

    public Integer getIdhairdresser_() {
        return idhairdresser_;
    }
	
    public void setIdhairdresser_ (Integer idhairdresser) {
        this.idhairdresser_ =  idhairdresser;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @reservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser-getter-hairdresser_has_buisness_has_service@
    public Set<ReservationClientHasHairdresserHasBuisnessHasService> getReservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser() {
        if (reservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser == null){
            reservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser = new HashSet<ReservationClientHasHairdresserHasBuisnessHasService>();
        }
        return reservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser;
    }

    public void setReservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser (Set<ReservationClientHasHairdresserHasBuisnessHasService> reservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser) {
        this.reservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser = reservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser;
    }	
    
    public void addReservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser (ReservationClientHasHairdresserHasBuisnessHasService element) {
    	    getReservationClientHasHairdresserHasBuisnessHasServiceHairdresserHasBuisnessHasServiceViaIdhairdresser().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
