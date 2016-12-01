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
import defaultroot.defautmodel.domain.defautmodel.Attachment;
import defaultroot.defautmodel.domain.defautmodel.BuisnessHasService;
import defaultroot.defautmodel.domain.defautmodel.BuisnessHasServiceHasAttachmentId;

/**
 *
 * <p>Title: BuisnessHasServiceHasAttachment</p>
 *
 * <p>Description: Domain Object describing a BuisnessHasServiceHasAttachment entity</p>
 *
 */
@Entity (name="BuisnessHasServiceHasAttachment")
@Table (name="\"buisness_has_service_has_attachment\"")
@NamedQueries ({
	 @NamedQuery(name="BuisnessHasServiceHasAttachment.findAll", query="SELECT a FROM BuisnessHasServiceHasAttachment a")
})

public class BuisnessHasServiceHasAttachment implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "BuisnessHasServiceHasAttachment.findAll";
    public static final String FIND_BY_BUISNESSHASSERVICESERVICEIDSERVICE_CONTAINING ="BuisnessHasServiceHasAttachment.findByBuisnessHasServiceServiceIdserviceContaining";
	
    @EmbeddedId
    public BuisnessHasServiceHasAttachmentId buisnessHasServiceHasAttachmentId__;     @Column(name="buisness_has_service_service_idservice"  , nullable=false , unique=false , insertable=false, updatable=false)
    private Integer buisnessHasServiceServiceIdservice_;
    @MapsId ("attachment_idattachment")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="attachment_idattachment", referencedColumnName = "idattachment" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Attachment attachmentIdattachment;  

    @Column(name="attachment_idattachment"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer attachmentIdattachment_;

    @MapsId ("buisness_has_service_buisness_idbuisness")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="buisness_has_service_buisness_idbuisness", referencedColumnName = "buisness_idbuisness" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private BuisnessHasService buisnessidbuisnessbuisnesshasserviceserviceidservice;  

    @Column(name="buisness_has_service_buisness_idbuisness"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer buisnessidbuisnessbuisnesshasserviceserviceidservice_;

    /**
    * Default constructor
    */
    public BuisnessHasServiceHasAttachment() {
    }

	/**
	* All field constructor 
	*/
    public BuisnessHasServiceHasAttachment(
       Integer buisnessHasServiceBuisnessIdbuisness,
       Integer buisnessHasServiceServiceIdservice,
       Integer attachmentIdattachment) {
	 this(
       buisnessHasServiceBuisnessIdbuisness,
       buisnessHasServiceServiceIdservice,
       attachmentIdattachment
	 ,true);
	}
    
	public BuisnessHasServiceHasAttachment(
       Integer buisnessHasServiceBuisnessIdbuisness,
       Integer buisnessHasServiceServiceIdservice,
       Integer attachmentIdattachment	
    , boolean setRelationship) {
       //primary keys
       this.buisnessHasServiceHasAttachmentId__ = new BuisnessHasServiceHasAttachmentId();  	
       this.buisnessHasServiceHasAttachmentId__.setBuisnessHasServiceServiceIdservice (buisnessHasServiceServiceIdservice);
       //attributes
       //parents
       if (setRelationship && attachmentIdattachment!=null) {
          this.attachmentIdattachment = new Attachment();
          this.attachmentIdattachment.setIdattachment(attachmentIdattachment);
       }
       if (setRelationship && buisnessHasServiceBuisnessIdbuisness!=null) {
          this.buisnessidbuisnessbuisnesshasserviceserviceidservice = new BuisnessHasService();
          this.buisnessidbuisnessbuisnesshasserviceserviceidservice.setBuisnessIdbuisness(buisnessHasServiceBuisnessIdbuisness);
       }
    }

	public BuisnessHasServiceHasAttachment flat() {
	   return new BuisnessHasServiceHasAttachment(
		  getBuisnessHasServiceHasAttachmentId__().getBuisnessHasServiceBuisnessIdbuisness(),
		  getBuisnessHasServiceHasAttachmentId__().getBuisnessHasServiceServiceIdservice(),
		  getBuisnessHasServiceHasAttachmentId__().getAttachmentIdattachment()
       , false
	   );
	}


    public BuisnessHasServiceHasAttachmentId getBuisnessHasServiceHasAttachmentId__() {
		if (buisnessHasServiceHasAttachmentId__==null) buisnessHasServiceHasAttachmentId__ = new BuisnessHasServiceHasAttachmentId();
        return buisnessHasServiceHasAttachmentId__;
    }
	
    public void setBuisnessHasServiceHasAttachmentId__ (BuisnessHasServiceHasAttachmentId buisnessHasServiceHasAttachmentId__) {
        this.buisnessHasServiceHasAttachmentId__ =  buisnessHasServiceHasAttachmentId__;
    }
    public Integer getBuisnessHasServiceServiceIdservice_() {
        return buisnessHasServiceServiceIdservice_;
    }
	
    public void setBuisnessHasServiceServiceIdservice_ (Integer buisnessHasServiceServiceIdservice) {
        this.buisnessHasServiceServiceIdservice_ =  buisnessHasServiceServiceIdservice_;
    }
    

    public Attachment getAttachmentIdattachment () {
    	return attachmentIdattachment;
    }
	
    public void setAttachmentIdattachment (Attachment attachmentIdattachment) {
    	this.attachmentIdattachment = attachmentIdattachment;
    }

    public Integer getAttachmentIdattachment_() {
        return attachmentIdattachment_;
    }
	
    public void setAttachmentIdattachment_ (Integer attachmentIdattachment) {
        this.attachmentIdattachment_ =  attachmentIdattachment;
    }
	
    public BuisnessHasService getBuisnessidbuisnessbuisnesshasserviceserviceidservice () {
    	return buisnessidbuisnessbuisnesshasserviceserviceidservice;
    }
	
    public void setBuisnessidbuisnessbuisnesshasserviceserviceidservice (BuisnessHasService buisnessidbuisnessbuisnesshasserviceserviceidservice) {
    	this.buisnessidbuisnessbuisnesshasserviceserviceidservice = buisnessidbuisnessbuisnesshasserviceserviceidservice;
    }

    public Integer getBuisnessidbuisnessbuisnesshasserviceserviceidservice_() {
        return buisnessidbuisnessbuisnesshasserviceserviceidservice_;
    }
	
    public void setBuisnessidbuisnessbuisnesshasserviceserviceidservice_ (Integer buisnessidbuisnessbuisnesshasserviceserviceidservice) {
        this.buisnessidbuisnessbuisnesshasserviceserviceidservice_ =  buisnessidbuisnessbuisnesshasserviceserviceidservice;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
