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
import defaultroot.defautmodel.domain.defautmodel.Hairdresser;
import defaultroot.defautmodel.domain.defautmodel.Buisness;
import defaultroot.defautmodel.domain.defautmodel.Client;

/**
 *
 * <p>Title: Attachment</p>
 *
 * <p>Description: Domain Object describing a Attachment entity</p>
 *
 */
@Entity (name="Attachment")
@Table (name="\"attachment\"")
@NamedQueries ({
	 @NamedQuery(name="Attachment.findAll", query="SELECT a FROM Attachment a")
	,@NamedQuery(name="Attachment.findByName", query="SELECT a FROM Attachment a WHERE a.name = :name")
	,@NamedQuery(name="Attachment.findByNameContaining", query="SELECT a FROM Attachment a WHERE a.name like :name")

	,@NamedQuery(name="Attachment.findByUrl", query="SELECT a FROM Attachment a WHERE a.url = :url")
	,@NamedQuery(name="Attachment.findByUrlContaining", query="SELECT a FROM Attachment a WHERE a.url like :url")

	,@NamedQuery(name="Attachment.findByType", query="SELECT a FROM Attachment a WHERE a.type = :type")
	,@NamedQuery(name="Attachment.findByTypeContaining", query="SELECT a FROM Attachment a WHERE a.type like :type")

})

public class Attachment implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Attachment.findAll";
    public static final String FIND_BY_NAME = "Attachment.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="Attachment.findByNameContaining";
    public static final String FIND_BY_URL = "Attachment.findByUrl";
    public static final String FIND_BY_URL_CONTAINING ="Attachment.findByUrlContaining";
    public static final String FIND_BY_TYPE = "Attachment.findByType";
    public static final String FIND_BY_TYPE_CONTAINING ="Attachment.findByTypeContaining";
	
    @Id @Column(name="idattachment" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idattachment;

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=45 , nullable=false , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @url-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @url-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-url@
    @Column(name="url"  , length=45 , nullable=false , unique=false)
    private String url; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-type@
    @Column(name="type"  , length=45 , nullable=false , unique=false)
    private String type; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment-field-attachment@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.BuisnessHasServiceHasAttachment.class, fetch=FetchType.LAZY, mappedBy="buisnessHasServiceHasAttachmentId__.attachmentIdattachment", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <BuisnessHasServiceHasAttachment> buisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment = new HashSet<BuisnessHasServiceHasAttachment>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hairdresserAttachmentViaProfilePicture-field-attachment@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Hairdresser.class, fetch=FetchType.LAZY, mappedBy="profilePicture", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Hairdresser> hairdresserAttachmentViaProfilePicture = new HashSet<Hairdresser>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-buisnessBuisnessHasAttachmentViaIdbuisness-attachment@
    @ManyToMany
    @JoinTable(name="BUISNESS_HAS_ATTACHMENT", 
        joinColumns=@JoinColumn(name="idattachment"), 
        inverseJoinColumns=@JoinColumn(name="idbuisness") 
    )
    private Set <Buisness> buisnessBuisnessHasAttachmentViaIdbuisness = new HashSet <Buisness> ();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-clientClientHasAttachmentViaIdclient-attachment@
    @ManyToMany
    @JoinTable(name="CLIENT_HAS_ATTACHMENT", 
        joinColumns=@JoinColumn(name="attachment_idattachment"), 
        inverseJoinColumns=@JoinColumn(name="client_idclient") 
    )
    private Set <Client> clientClientHasAttachmentViaIdclient = new HashSet <Client> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Attachment() {
    }

	/**
	* All field constructor 
	*/
    public Attachment(
       Integer idattachment,
       String name,
       String url,
       String type) {
	 this(
       idattachment,
       name,
       url,
       type
	 ,true);
	}
    
	public Attachment(
       Integer idattachment,
       String name,
       String url,
       String type	
    , boolean setRelationship) {
       //primary keys
       setIdattachment (idattachment);
       //attributes
       setName (name);
       setUrl (url);
       setType (type);
       //parents
    }

	public Attachment flat() {
	   return new Attachment(
          getIdattachment(),
          getName(),
          getUrl(),
          getType()
       , false
	   );
	}

    public Integer getIdattachment() {
        return idattachment;
    }
	
    public void setIdattachment (Integer idattachment) {
        this.idattachment =  idattachment;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-url@
    public String getUrl() {
        return url;
    }
	
    public void setUrl (String url) {
        this.url =  url;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-type@
    public String getType() {
        return type;
    }
	
    public void setType (String type) {
        this.type =  type;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessHasAttachmentViaAttachmentByIdattachment-getter-attachment@
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment-getter-attachment@
    public Set<BuisnessHasServiceHasAttachment> getBuisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment() {
        if (buisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment == null){
            buisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment = new HashSet<BuisnessHasServiceHasAttachment>();
        }
        return buisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment;
    }

    public void setBuisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment (Set<BuisnessHasServiceHasAttachment> buisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment) {
        this.buisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment = buisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment;
    }	
    
    public void addBuisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment (BuisnessHasServiceHasAttachment element) {
    	    getBuisnessHasServiceHasAttachmentAttachmentViaAttachmentIdattachment().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @clientHasAttachmentViaAttachmentByIdattachment-getter-attachment@
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @hairdresserAttachmentViaProfilePicture-getter-attachment@
    public Set<Hairdresser> getHairdresserAttachmentViaProfilePicture() {
        if (hairdresserAttachmentViaProfilePicture == null){
            hairdresserAttachmentViaProfilePicture = new HashSet<Hairdresser>();
        }
        return hairdresserAttachmentViaProfilePicture;
    }

    public void setHairdresserAttachmentViaProfilePicture (Set<Hairdresser> hairdresserAttachmentViaProfilePicture) {
        this.hairdresserAttachmentViaProfilePicture = hairdresserAttachmentViaProfilePicture;
    }	
    
    public void addHairdresserAttachmentViaProfilePicture (Hairdresser element) {
    	    getHairdresserAttachmentViaProfilePicture().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Buisness> getBuisnessBuisnessHasAttachmentViaIdbuisness() {
        if (buisnessBuisnessHasAttachmentViaIdbuisness == null){
            buisnessBuisnessHasAttachmentViaIdbuisness = new HashSet<Buisness>();
        }
        return buisnessBuisnessHasAttachmentViaIdbuisness;
    }

    public void setBuisnessBuisnessHasAttachmentViaIdbuisness (Set<Buisness> buisnessBuisnessHasAttachmentViaIdbuisness) {
        this.buisnessBuisnessHasAttachmentViaIdbuisness = buisnessBuisnessHasAttachmentViaIdbuisness;
    }
    	
    public void addBuisnessBuisnessHasAttachmentViaIdbuisness (Buisness element) {
        getBuisnessBuisnessHasAttachmentViaIdbuisness().add(element);
    }
	
    public Set<Client> getClientClientHasAttachmentViaIdclient() {
        if (clientClientHasAttachmentViaIdclient == null){
            clientClientHasAttachmentViaIdclient = new HashSet<Client>();
        }
        return clientClientHasAttachmentViaIdclient;
    }

    public void setClientClientHasAttachmentViaIdclient (Set<Client> clientClientHasAttachmentViaIdclient) {
        this.clientClientHasAttachmentViaIdclient = clientClientHasAttachmentViaIdclient;
    }
    	
    public void addClientClientHasAttachmentViaIdclient (Client element) {
        getClientClientHasAttachmentViaIdclient().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
