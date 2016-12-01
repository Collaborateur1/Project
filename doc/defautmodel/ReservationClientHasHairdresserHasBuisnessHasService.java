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
import defaultroot.defautmodel.domain.defautmodel.ReservationClient;
import defaultroot.defautmodel.domain.defautmodel.HairdresserHasBuisnessHasService;
import defaultroot.defautmodel.domain.defautmodel.ReservationClientHasHairdresserHasBuisnessHasServiceId;

/**
 *
 * <p>Title: ReservationClientHasHairdresserHasBuisnessHasService</p>
 *
 * <p>Description: Domain Object describing a ReservationClientHasHairdresserHasBuisnessHasService entity</p>
 *
 */
@Entity (name="ReservationClientHasHairdresserHasBuisnessHasService")
@Table (name="\"reservation_client_has_hairdresser_has_buisness_has_service\"")
@NamedQueries ({
	 @NamedQuery(name="ReservationClientHasHairdresserHasBuisnessHasService.findAll", query="SELECT a FROM ReservationClientHasHairdresserHasBuisnessHasService a")
})

public class ReservationClientHasHairdresserHasBuisnessHasService implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "ReservationClientHasHairdresserHasBuisnessHasService.findAll";
    public static final String FIND_BY_IDBUISNESS_CONTAINING ="ReservationClientHasHairdresserHasBuisnessHasService.findByIdbuisnessContaining";
    public static final String FIND_BY_IDSERVICE_CONTAINING ="ReservationClientHasHairdresserHasBuisnessHasService.findByIdserviceContaining";
	
    @EmbeddedId
    public ReservationClientHasHairdresserHasBuisnessHasServiceId reservationClientHasHairdresserHasBuisnessHasServiceId__;     @Column(name="idbuisness"  , nullable=false , unique=false , insertable=false, updatable=false)
    private Integer idbuisness_;
    @Column(name="idservice"  , nullable=false , unique=false , insertable=false, updatable=false)
    private Integer idservice_;
    @MapsId ("idreservation_client")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="idreservation_client", referencedColumnName = "idreservation_client" , nullable=false , unique=false , insertable=true, updatable=true) 
    private ReservationClient idreservationClient;  

    @Column(name="idreservation_client"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer idreservationClient_;

    @MapsId ("idhairdresser")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="idhairdresser", referencedColumnName = "idhairdresser" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private HairdresserHasBuisnessHasService idhairdresseridbuisnessidservice;  

    @Column(name="idhairdresser"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer idhairdresseridbuisnessidservice_;

    /**
    * Default constructor
    */
    public ReservationClientHasHairdresserHasBuisnessHasService() {
    }

	/**
	* All field constructor 
	*/
    public ReservationClientHasHairdresserHasBuisnessHasService(
       Integer idreservationClient,
       Integer idhairdresser,
       Integer idbuisness,
       Integer idservice) {
	 this(
       idreservationClient,
       idhairdresser,
       idbuisness,
       idservice
	 ,true);
	}
    
	public ReservationClientHasHairdresserHasBuisnessHasService(
       Integer idreservationClient,
       Integer idhairdresser,
       Integer idbuisness,
       Integer idservice	
    , boolean setRelationship) {
       //primary keys
       this.reservationClientHasHairdresserHasBuisnessHasServiceId__ = new ReservationClientHasHairdresserHasBuisnessHasServiceId();  	
       this.reservationClientHasHairdresserHasBuisnessHasServiceId__.setIdbuisness (idbuisness);
       this.reservationClientHasHairdresserHasBuisnessHasServiceId__.setIdservice (idservice);
       //attributes
       //parents
       if (setRelationship && idreservationClient!=null) {
          this.idreservationClient = new ReservationClient();
          this.idreservationClient.setIdreservationClient(idreservationClient);
       }
       if (setRelationship && idhairdresser!=null) {
          this.idhairdresseridbuisnessidservice = new HairdresserHasBuisnessHasService();
          this.idhairdresseridbuisnessidservice.setIdhairdresser(idhairdresser);
       }
    }

	public ReservationClientHasHairdresserHasBuisnessHasService flat() {
	   return new ReservationClientHasHairdresserHasBuisnessHasService(
		  getReservationClientHasHairdresserHasBuisnessHasServiceId__().getIdreservationClient(),
		  getReservationClientHasHairdresserHasBuisnessHasServiceId__().getIdhairdresser(),
		  getReservationClientHasHairdresserHasBuisnessHasServiceId__().getIdbuisness(),
		  getReservationClientHasHairdresserHasBuisnessHasServiceId__().getIdservice()
       , false
	   );
	}


    public ReservationClientHasHairdresserHasBuisnessHasServiceId getReservationClientHasHairdresserHasBuisnessHasServiceId__() {
		if (reservationClientHasHairdresserHasBuisnessHasServiceId__==null) reservationClientHasHairdresserHasBuisnessHasServiceId__ = new ReservationClientHasHairdresserHasBuisnessHasServiceId();
        return reservationClientHasHairdresserHasBuisnessHasServiceId__;
    }
	
    public void setReservationClientHasHairdresserHasBuisnessHasServiceId__ (ReservationClientHasHairdresserHasBuisnessHasServiceId reservationClientHasHairdresserHasBuisnessHasServiceId__) {
        this.reservationClientHasHairdresserHasBuisnessHasServiceId__ =  reservationClientHasHairdresserHasBuisnessHasServiceId__;
    }
    public Integer getIdbuisness_() {
        return idbuisness_;
    }
	
    public void setIdbuisness_ (Integer idbuisness) {
        this.idbuisness_ =  idbuisness_;
    }
    
    public Integer getIdservice_() {
        return idservice_;
    }
	
    public void setIdservice_ (Integer idservice) {
        this.idservice_ =  idservice_;
    }
    

    public ReservationClient getIdreservationClient () {
    	return idreservationClient;
    }
	
    public void setIdreservationClient (ReservationClient idreservationClient) {
    	this.idreservationClient = idreservationClient;
    }

    public Integer getIdreservationClient_() {
        return idreservationClient_;
    }
	
    public void setIdreservationClient_ (Integer idreservationClient) {
        this.idreservationClient_ =  idreservationClient;
    }
	
    public HairdresserHasBuisnessHasService getIdhairdresseridbuisnessidservice () {
    	return idhairdresseridbuisnessidservice;
    }
	
    public void setIdhairdresseridbuisnessidservice (HairdresserHasBuisnessHasService idhairdresseridbuisnessidservice) {
    	this.idhairdresseridbuisnessidservice = idhairdresseridbuisnessidservice;
    }

    public Integer getIdhairdresseridbuisnessidservice_() {
        return idhairdresseridbuisnessidservice_;
    }
	
    public void setIdhairdresseridbuisnessidservice_ (Integer idhairdresseridbuisnessidservice) {
        this.idhairdresseridbuisnessidservice_ =  idhairdresseridbuisnessidservice;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
