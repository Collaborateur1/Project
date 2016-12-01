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
import defaultroot.defautmodel.domain.defautmodel.BuisnessHasService;

/**
 *
 * <p>Title: Service</p>
 *
 * <p>Description: Domain Object describing a Service entity</p>
 *
 */
@Entity (name="Service")
@Table (name="\"service\"")
@NamedQueries ({
	 @NamedQuery(name="Service.findAll", query="SELECT a FROM Service a")
	,@NamedQuery(name="Service.findByName", query="SELECT a FROM Service a WHERE a.name = :name")
	,@NamedQuery(name="Service.findByNameContaining", query="SELECT a FROM Service a WHERE a.name like :name")

	,@NamedQuery(name="Service.findByDescription", query="SELECT a FROM Service a WHERE a.description = :description")
	,@NamedQuery(name="Service.findByDescriptionContaining", query="SELECT a FROM Service a WHERE a.description like :description")

})

public class Service implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Service.findAll";
    public static final String FIND_BY_NAME = "Service.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="Service.findByNameContaining";
    public static final String FIND_BY_DESCRIPTION = "Service.findByDescription";
    public static final String FIND_BY_DESCRIPTION_CONTAINING ="Service.findByDescriptionContaining";
	
    @Id @Column(name="idservice" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idservice;

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=45 , nullable=false , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @description-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @description-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-description@
    @Column(name="description"  , length=45 , nullable=true , unique=false)
    private String description; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessHasServiceServiceViaServiceIdservice-field-service@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.BuisnessHasService.class, fetch=FetchType.LAZY, mappedBy="buisnessHasServiceId__.serviceIdservice", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <BuisnessHasService> buisnessHasServiceServiceViaServiceIdservice = new HashSet<BuisnessHasService>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Service() {
    }

	/**
	* All field constructor 
	*/
    public Service(
       Integer idservice,
       String name,
       String description) {
	 this(
       idservice,
       name,
       description
	 ,true);
	}
    
	public Service(
       Integer idservice,
       String name,
       String description	
    , boolean setRelationship) {
       //primary keys
       setIdservice (idservice);
       //attributes
       setName (name);
       setDescription (description);
       //parents
    }

	public Service flat() {
	   return new Service(
          getIdservice(),
          getName(),
          getDescription()
       , false
	   );
	}

    public Integer getIdservice() {
        return idservice;
    }
	
    public void setIdservice (Integer idservice) {
        this.idservice =  idservice;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
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



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessHasServiceServiceViaServiceIdservice-getter-service@
    public Set<BuisnessHasService> getBuisnessHasServiceServiceViaServiceIdservice() {
        if (buisnessHasServiceServiceViaServiceIdservice == null){
            buisnessHasServiceServiceViaServiceIdservice = new HashSet<BuisnessHasService>();
        }
        return buisnessHasServiceServiceViaServiceIdservice;
    }

    public void setBuisnessHasServiceServiceViaServiceIdservice (Set<BuisnessHasService> buisnessHasServiceServiceViaServiceIdservice) {
        this.buisnessHasServiceServiceViaServiceIdservice = buisnessHasServiceServiceViaServiceIdservice;
    }	
    
    public void addBuisnessHasServiceServiceViaServiceIdservice (BuisnessHasService element) {
    	    getBuisnessHasServiceServiceViaServiceIdservice().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
