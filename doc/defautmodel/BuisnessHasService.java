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
import defaultroot.defautmodel.domain.defautmodel.BuisnessHasServiceHasAttachment;
import defaultroot.defautmodel.domain.defautmodel.HairdresserHasBuisnessHasService;
import defaultroot.defautmodel.domain.defautmodel.Buisness;
import defaultroot.defautmodel.domain.defautmodel.Service;
import defaultroot.defautmodel.domain.defautmodel.BuisnessHasServiceId;

/**
 *
 * <p>Title: BuisnessHasService</p>
 *
 * <p>Description: Domain Object describing a BuisnessHasService entity</p>
 *
 */
@Entity (name="BuisnessHasService")
@Table (name="\"buisness_has_service\"")
@NamedQueries ({
	 @NamedQuery(name="BuisnessHasService.findAll", query="SELECT a FROM BuisnessHasService a")
	,@NamedQuery(name="BuisnessHasService.findByDurationMinutes", query="SELECT a FROM BuisnessHasService a WHERE a.durationMinutes = :durationMinutes")

	,@NamedQuery(name="BuisnessHasService.findByPrice", query="SELECT a FROM BuisnessHasService a WHERE a.price = :price")

	,@NamedQuery(name="BuisnessHasService.findByNote", query="SELECT a FROM BuisnessHasService a WHERE a.note = :note")
	,@NamedQuery(name="BuisnessHasService.findByNoteContaining", query="SELECT a FROM BuisnessHasService a WHERE a.note like :note")

})

public class BuisnessHasService implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "BuisnessHasService.findAll";
    public static final String FIND_BY_DURATIONMINUTES = "BuisnessHasService.findByDurationMinutes";
    public static final String FIND_BY_PRICE = "BuisnessHasService.findByPrice";
    public static final String FIND_BY_NOTE = "BuisnessHasService.findByNote";
    public static final String FIND_BY_NOTE_CONTAINING ="BuisnessHasService.findByNoteContaining";
	
    @EmbeddedId
    public BuisnessHasServiceId buisnessHasServiceId__; //MP-MANAGED-ADDED-AREA-BEGINNING @duration_minutes-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @duration_minutes-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-duration_minutes@
    @Column(name="duration_minutes"   , nullable=false , unique=false)
    private Integer durationMinutes; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @price-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @price-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-price@
    @Column(name="price"   , nullable=false , unique=false)
    private Integer price; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @note-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @note-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-note@
    @Column(name="note"  , length=2000 , nullable=true , unique=false)
    private String note; 
//MP-MANAGED-UPDATABLE-ENDING

    @MapsId ("buisness_idbuisness")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="buisness_idbuisness", referencedColumnName = "idbuisness" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Buisness buisnessIdbuisness;  

    @Column(name="buisness_idbuisness"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer buisnessIdbuisness_;

    @MapsId ("service_idservice")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="service_idservice", referencedColumnName = "idservice" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Service serviceIdservice;  

    @Column(name="service_idservice"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer serviceIdservice_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness-field-buisness_has_service@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.BuisnessHasServiceHasAttachment.class, fetch=FetchType.LAZY, mappedBy="buisnessHasServiceHasAttachmentId__.buisnessHasServiceBuisnessIdbuisness", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <BuisnessHasServiceHasAttachment> buisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness = new HashSet<BuisnessHasServiceHasAttachment>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness-field-buisness_has_service@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.HairdresserHasBuisnessHasService.class, fetch=FetchType.LAZY, mappedBy="hairdresserHasBuisnessHasServiceId__.idbuisness", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <HairdresserHasBuisnessHasService> hairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness = new HashSet<HairdresserHasBuisnessHasService>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public BuisnessHasService() {
    }

	/**
	* All field constructor 
	*/
    public BuisnessHasService(
       Integer buisnessIdbuisness,
       Integer serviceIdservice,
       Integer durationMinutes,
       Integer price,
       String note) {
	 this(
       buisnessIdbuisness,
       serviceIdservice,
       durationMinutes,
       price,
       note
	 ,true);
	}
    
	public BuisnessHasService(
       Integer buisnessIdbuisness,
       Integer serviceIdservice,
       Integer durationMinutes,
       Integer price,
       String note	
    , boolean setRelationship) {
       //primary keys
       this.buisnessHasServiceId__ = new BuisnessHasServiceId();  	
       //attributes
       setDurationMinutes (durationMinutes);
       setPrice (price);
       setNote (note);
       //parents
       if (setRelationship && buisnessIdbuisness!=null) {
          this.buisnessIdbuisness = new Buisness();
          this.buisnessIdbuisness.setIdbuisness(buisnessIdbuisness);
	      setBuisnessIdbuisness_ (buisnessIdbuisness);
       }
       if (setRelationship && serviceIdservice!=null) {
          this.serviceIdservice = new Service();
          this.serviceIdservice.setIdservice(serviceIdservice);
	      setServiceIdservice_ (serviceIdservice);
       }
    }

	public BuisnessHasService flat() {
	   return new BuisnessHasService(
		  getBuisnessHasServiceId__().getBuisnessIdbuisness(),
		  getBuisnessHasServiceId__().getServiceIdservice(),
          getDurationMinutes(),
          getPrice(),
          getNote()
       , false
	   );
	}


    public BuisnessHasServiceId getBuisnessHasServiceId__() {
		if (buisnessHasServiceId__==null) buisnessHasServiceId__ = new BuisnessHasServiceId();
        return buisnessHasServiceId__;
    }
	
    public void setBuisnessHasServiceId__ (BuisnessHasServiceId buisnessHasServiceId__) {
        this.buisnessHasServiceId__ =  buisnessHasServiceId__;
    }
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-duration_minutes@
    public Integer getDurationMinutes() {
        return durationMinutes;
    }
	
    public void setDurationMinutes (Integer durationMinutes) {
        this.durationMinutes =  durationMinutes;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-price@
    public Integer getPrice() {
        return price;
    }
	
    public void setPrice (Integer price) {
        this.price =  price;
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


    public Buisness getBuisnessIdbuisness () {
    	return buisnessIdbuisness;
    }
	
    public void setBuisnessIdbuisness (Buisness buisnessIdbuisness) {
    	this.buisnessIdbuisness = buisnessIdbuisness;
    }

    public Integer getBuisnessIdbuisness_() {
        return buisnessIdbuisness_;
    }
	
    public void setBuisnessIdbuisness_ (Integer buisnessIdbuisness) {
        this.buisnessIdbuisness_ =  buisnessIdbuisness;
    }
	
    public Service getServiceIdservice () {
    	return serviceIdservice;
    }
	
    public void setServiceIdservice (Service serviceIdservice) {
    	this.serviceIdservice = serviceIdservice;
    }

    public Integer getServiceIdservice_() {
        return serviceIdservice_;
    }
	
    public void setServiceIdservice_ (Integer serviceIdservice) {
        this.serviceIdservice_ =  serviceIdservice;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness-getter-buisness_has_service@
    public Set<BuisnessHasServiceHasAttachment> getBuisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness() {
        if (buisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness == null){
            buisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness = new HashSet<BuisnessHasServiceHasAttachment>();
        }
        return buisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness;
    }

    public void setBuisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness (Set<BuisnessHasServiceHasAttachment> buisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness) {
        this.buisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness = buisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness;
    }	
    
    public void addBuisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness (BuisnessHasServiceHasAttachment element) {
    	    getBuisnessHasServiceHasAttachmentBuisnessHasServiceViaBuisnessHasServiceBuisnessIdbuisness().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness-getter-buisness_has_service@
    public Set<HairdresserHasBuisnessHasService> getHairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness() {
        if (hairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness == null){
            hairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness = new HashSet<HairdresserHasBuisnessHasService>();
        }
        return hairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness;
    }

    public void setHairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness (Set<HairdresserHasBuisnessHasService> hairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness) {
        this.hairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness = hairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness;
    }	
    
    public void addHairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness (HairdresserHasBuisnessHasService element) {
    	    getHairdresserHasBuisnessHasServiceBuisnessHasServiceViaIdbuisness().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
