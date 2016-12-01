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
import defaultroot.defautmodel.domain.defautmodel.BuisnessHasService;
import defaultroot.defautmodel.domain.defautmodel.Hairdresser;
import defaultroot.defautmodel.domain.defautmodel.BuisnessType;
import defaultroot.defautmodel.domain.defautmodel.Adress;
import defaultroot.defautmodel.domain.defautmodel.Manager;
import defaultroot.defautmodel.domain.defautmodel.Attachment;
import defaultroot.defautmodel.domain.defautmodel.Tag;

/**
 *
 * <p>Title: Buisness</p>
 *
 * <p>Description: Domain Object describing a Buisness entity</p>
 *
 */
@Entity (name="Buisness")
@Table (name="\"buisness\"")
@NamedQueries ({
	 @NamedQuery(name="Buisness.findAll", query="SELECT a FROM Buisness a")
	,@NamedQuery(name="Buisness.findByName", query="SELECT a FROM Buisness a WHERE a.name = :name")
	,@NamedQuery(name="Buisness.findByNameContaining", query="SELECT a FROM Buisness a WHERE a.name like :name")

	,@NamedQuery(name="Buisness.findByConfirmation", query="SELECT a FROM Buisness a WHERE a.confirmation = :confirmation")

	,@NamedQuery(name="Buisness.findByDescription", query="SELECT a FROM Buisness a WHERE a.description = :description")
	,@NamedQuery(name="Buisness.findByDescriptionContaining", query="SELECT a FROM Buisness a WHERE a.description like :description")

})

public class Buisness implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Buisness.findAll";
    public static final String FIND_BY_NAME = "Buisness.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="Buisness.findByNameContaining";
    public static final String FIND_BY_CONFIRMATION = "Buisness.findByConfirmation";
    public static final String FIND_BY_DESCRIPTION = "Buisness.findByDescription";
    public static final String FIND_BY_DESCRIPTION_CONTAINING ="Buisness.findByDescriptionContaining";
	
    @Id @Column(name="idbuisness" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idbuisness;

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=45 , nullable=false , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @confirmation-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @confirmation-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-confirmation@
    @Column(name="confirmation"   , nullable=false , unique=false)
    private Boolean confirmation; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @description-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @description-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-description@
    @Column(name="description"  , length=5000 , nullable=true , unique=false)
    private String description; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="buisness_type_idtype", referencedColumnName = "idtype" , nullable=false , unique=false , insertable=true, updatable=true) 
    private BuisnessType buisnessTypeIdtype;  

    @Column(name="buisness_type_idtype"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer buisnessTypeIdtype_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="idadress", referencedColumnName = "idadress" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private Adress idadress;  

    @Column(name="idadress"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer idadress_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="idmanager", referencedColumnName = "idmanager" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private Manager idmanager;  

    @Column(name="idmanager"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer idmanager_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @avisBuisnessViaSalonIdsalon-field-buisness@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Avis.class, fetch=FetchType.LAZY, mappedBy="salonIdsalon", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Avis> avisBuisnessViaSalonIdsalon = new HashSet<Avis>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessHasServiceBuisnessViaBuisnessIdbuisness-field-buisness@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.BuisnessHasService.class, fetch=FetchType.LAZY, mappedBy="buisnessHasServiceId__.buisnessIdbuisness", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <BuisnessHasService> buisnessHasServiceBuisnessViaBuisnessIdbuisness = new HashSet<BuisnessHasService>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hairdresserBuisnessViaIdbuisness-field-buisness@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Hairdresser.class, fetch=FetchType.LAZY, mappedBy="idbuisness", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Hairdresser> hairdresserBuisnessViaIdbuisness = new HashSet<Hairdresser>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-attachmentBuisnessHasAttachmentViaIdattachment-buisness@
    @ManyToMany
    @JoinTable(name="BUISNESS_HAS_ATTACHMENT", 
        joinColumns=@JoinColumn(name="idbuisness"), 
        inverseJoinColumns=@JoinColumn(name="idattachment") 
    )
    private Set <Attachment> attachmentBuisnessHasAttachmentViaIdattachment = new HashSet <Attachment> ();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-tagSalonHasTagViaIdtag-buisness@
    @ManyToMany
    @JoinTable(name="SALON_HAS_TAG", 
        joinColumns=@JoinColumn(name="idsalon"), 
        inverseJoinColumns=@JoinColumn(name="idtag") 
    )
    private Set <Tag> tagSalonHasTagViaIdtag = new HashSet <Tag> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Buisness() {
    }

	/**
	* All field constructor 
	*/
    public Buisness(
       Integer idbuisness,
       Integer idmanager,
       Integer idadress,
       String name,
       Boolean confirmation,
       String description,
       Integer buisnessTypeIdtype) {
	 this(
       idbuisness,
       idmanager,
       idadress,
       name,
       confirmation,
       description,
       buisnessTypeIdtype
	 ,true);
	}
    
	public Buisness(
       Integer idbuisness,
       Integer idmanager,
       Integer idadress,
       String name,
       Boolean confirmation,
       String description,
       Integer buisnessTypeIdtype	
    , boolean setRelationship) {
       //primary keys
       setIdbuisness (idbuisness);
       //attributes
       setName (name);
       setConfirmation (confirmation);
       setDescription (description);
       //parents
       if (setRelationship && buisnessTypeIdtype!=null) {
          this.buisnessTypeIdtype = new BuisnessType();
          this.buisnessTypeIdtype.setIdtype(buisnessTypeIdtype);
	      setBuisnessTypeIdtype_ (buisnessTypeIdtype);
       }
       if (setRelationship && idadress!=null) {
          this.idadress = new Adress();
          this.idadress.setIdadress(idadress);
	      setIdadress_ (idadress);
       }
       if (setRelationship && idmanager!=null) {
          this.idmanager = new Manager();
          this.idmanager.setIdmanager(idmanager);
	      setIdmanager_ (idmanager);
       }
    }

	public Buisness flat() {
	   return new Buisness(
          getIdbuisness(),
          getIdmanager_(),
          getIdadress_(),
          getName(),
          getConfirmation(),
          getDescription(),
          getBuisnessTypeIdtype_()
       , false
	   );
	}

    public Integer getIdbuisness() {
        return idbuisness;
    }
	
    public void setIdbuisness (Integer idbuisness) {
        this.idbuisness =  idbuisness;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-confirmation@
    public Boolean getConfirmation() {
        return confirmation;
    }
	
    public void setConfirmation (Boolean confirmation) {
        this.confirmation =  confirmation;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-description@
    public String getDescription() {
        return description;
    }
	
    public void setDescription (String description) {
        this.description =  description;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public BuisnessType getBuisnessTypeIdtype () {
    	return buisnessTypeIdtype;
    }
	
    public void setBuisnessTypeIdtype (BuisnessType buisnessTypeIdtype) {
    	this.buisnessTypeIdtype = buisnessTypeIdtype;
    }

    public Integer getBuisnessTypeIdtype_() {
        return buisnessTypeIdtype_;
    }
	
    public void setBuisnessTypeIdtype_ (Integer buisnessTypeIdtype) {
        this.buisnessTypeIdtype_ =  buisnessTypeIdtype;
    }
	
    public Adress getIdadress () {
    	return idadress;
    }
	
    public void setIdadress (Adress idadress) {
    	this.idadress = idadress;
    }

    public Integer getIdadress_() {
        return idadress_;
    }
	
    public void setIdadress_ (Integer idadress) {
        this.idadress_ =  idadress;
    }
	
    public Manager getIdmanager () {
    	return idmanager;
    }
	
    public void setIdmanager (Manager idmanager) {
    	this.idmanager = idmanager;
    }

    public Integer getIdmanager_() {
        return idmanager_;
    }
	
    public void setIdmanager_ (Integer idmanager) {
        this.idmanager_ =  idmanager;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @avisBuisnessViaSalonIdsalon-getter-buisness@
    public Set<Avis> getAvisBuisnessViaSalonIdsalon() {
        if (avisBuisnessViaSalonIdsalon == null){
            avisBuisnessViaSalonIdsalon = new HashSet<Avis>();
        }
        return avisBuisnessViaSalonIdsalon;
    }

    public void setAvisBuisnessViaSalonIdsalon (Set<Avis> avisBuisnessViaSalonIdsalon) {
        this.avisBuisnessViaSalonIdsalon = avisBuisnessViaSalonIdsalon;
    }	
    
    public void addAvisBuisnessViaSalonIdsalon (Avis element) {
    	    getAvisBuisnessViaSalonIdsalon().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessHasAttachmentViaBuisnessByIdbuisness-getter-buisness@
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessHasServiceBuisnessViaBuisnessIdbuisness-getter-buisness@
    public Set<BuisnessHasService> getBuisnessHasServiceBuisnessViaBuisnessIdbuisness() {
        if (buisnessHasServiceBuisnessViaBuisnessIdbuisness == null){
            buisnessHasServiceBuisnessViaBuisnessIdbuisness = new HashSet<BuisnessHasService>();
        }
        return buisnessHasServiceBuisnessViaBuisnessIdbuisness;
    }

    public void setBuisnessHasServiceBuisnessViaBuisnessIdbuisness (Set<BuisnessHasService> buisnessHasServiceBuisnessViaBuisnessIdbuisness) {
        this.buisnessHasServiceBuisnessViaBuisnessIdbuisness = buisnessHasServiceBuisnessViaBuisnessIdbuisness;
    }	
    
    public void addBuisnessHasServiceBuisnessViaBuisnessIdbuisness (BuisnessHasService element) {
    	    getBuisnessHasServiceBuisnessViaBuisnessIdbuisness().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hairdresserBuisnessViaIdbuisness-getter-buisness@
    public Set<Hairdresser> getHairdresserBuisnessViaIdbuisness() {
        if (hairdresserBuisnessViaIdbuisness == null){
            hairdresserBuisnessViaIdbuisness = new HashSet<Hairdresser>();
        }
        return hairdresserBuisnessViaIdbuisness;
    }

    public void setHairdresserBuisnessViaIdbuisness (Set<Hairdresser> hairdresserBuisnessViaIdbuisness) {
        this.hairdresserBuisnessViaIdbuisness = hairdresserBuisnessViaIdbuisness;
    }	
    
    public void addHairdresserBuisnessViaIdbuisness (Hairdresser element) {
    	    getHairdresserBuisnessViaIdbuisness().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @salonHasTagViaBuisnessByIdbuisness-getter-buisness@
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Attachment> getAttachmentBuisnessHasAttachmentViaIdattachment() {
        if (attachmentBuisnessHasAttachmentViaIdattachment == null){
            attachmentBuisnessHasAttachmentViaIdattachment = new HashSet<Attachment>();
        }
        return attachmentBuisnessHasAttachmentViaIdattachment;
    }

    public void setAttachmentBuisnessHasAttachmentViaIdattachment (Set<Attachment> attachmentBuisnessHasAttachmentViaIdattachment) {
        this.attachmentBuisnessHasAttachmentViaIdattachment = attachmentBuisnessHasAttachmentViaIdattachment;
    }
    	
    public void addAttachmentBuisnessHasAttachmentViaIdattachment (Attachment element) {
        getAttachmentBuisnessHasAttachmentViaIdattachment().add(element);
    }
	
    public Set<Tag> getTagSalonHasTagViaIdtag() {
        if (tagSalonHasTagViaIdtag == null){
            tagSalonHasTagViaIdtag = new HashSet<Tag>();
        }
        return tagSalonHasTagViaIdtag;
    }

    public void setTagSalonHasTagViaIdtag (Set<Tag> tagSalonHasTagViaIdtag) {
        this.tagSalonHasTagViaIdtag = tagSalonHasTagViaIdtag;
    }
    	
    public void addTagSalonHasTagViaIdtag (Tag element) {
        getTagSalonHasTagViaIdtag().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
