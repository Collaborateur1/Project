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
import defaultroot.defautmodel.domain.defautmodel.Buisness;

/**
 *
 * <p>Title: BuisnessType</p>
 *
 * <p>Description: Domain Object describing a BuisnessType entity</p>
 *
 */
@Entity (name="BuisnessType")
@Table (name="\"buisness_type\"")
@NamedQueries ({
	 @NamedQuery(name="BuisnessType.findAll", query="SELECT a FROM BuisnessType a")
	,@NamedQuery(name="BuisnessType.findByName", query="SELECT a FROM BuisnessType a WHERE a.name = :name")
	,@NamedQuery(name="BuisnessType.findByNameContaining", query="SELECT a FROM BuisnessType a WHERE a.name like :name")

})

public class BuisnessType implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "BuisnessType.findAll";
    public static final String FIND_BY_NAME = "BuisnessType.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="BuisnessType.findByNameContaining";
	
    @Id @Column(name="idtype" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idtype;

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=45 , nullable=false , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessBuisnessTypeViaBuisnessTypeIdtype-field-buisness_type@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Buisness.class, fetch=FetchType.LAZY, mappedBy="buisnessTypeIdtype", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Buisness> buisnessBuisnessTypeViaBuisnessTypeIdtype = new HashSet<Buisness>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public BuisnessType() {
    }

	/**
	* All field constructor 
	*/
    public BuisnessType(
       Integer idtype,
       String name) {
	 this(
       idtype,
       name
	 ,true);
	}
    
	public BuisnessType(
       Integer idtype,
       String name	
    , boolean setRelationship) {
       //primary keys
       setIdtype (idtype);
       //attributes
       setName (name);
       //parents
    }

	public BuisnessType flat() {
	   return new BuisnessType(
          getIdtype(),
          getName()
       , false
	   );
	}

    public Integer getIdtype() {
        return idtype;
    }
	
    public void setIdtype (Integer idtype) {
        this.idtype =  idtype;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessBuisnessTypeViaBuisnessTypeIdtype-getter-buisness_type@
    public Set<Buisness> getBuisnessBuisnessTypeViaBuisnessTypeIdtype() {
        if (buisnessBuisnessTypeViaBuisnessTypeIdtype == null){
            buisnessBuisnessTypeViaBuisnessTypeIdtype = new HashSet<Buisness>();
        }
        return buisnessBuisnessTypeViaBuisnessTypeIdtype;
    }

    public void setBuisnessBuisnessTypeViaBuisnessTypeIdtype (Set<Buisness> buisnessBuisnessTypeViaBuisnessTypeIdtype) {
        this.buisnessBuisnessTypeViaBuisnessTypeIdtype = buisnessBuisnessTypeViaBuisnessTypeIdtype;
    }	
    
    public void addBuisnessBuisnessTypeViaBuisnessTypeIdtype (Buisness element) {
    	    getBuisnessBuisnessTypeViaBuisnessTypeIdtype().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
