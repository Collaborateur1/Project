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
 * <p>Title: Tag</p>
 *
 * <p>Description: Domain Object describing a Tag entity</p>
 *
 */
@Entity (name="Tag")
@Table (name="\"tag\"")
@NamedQueries ({
	 @NamedQuery(name="Tag.findAll", query="SELECT a FROM Tag a")
	,@NamedQuery(name="Tag.findByName", query="SELECT a FROM Tag a WHERE a.name = :name")
	,@NamedQuery(name="Tag.findByNameContaining", query="SELECT a FROM Tag a WHERE a.name like :name")

})

public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Tag.findAll";
    public static final String FIND_BY_NAME = "Tag.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="Tag.findByNameContaining";
	
    @Id @Column(name="idtag" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idtag;

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=45 , nullable=true , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-buisnessSalonHasTagViaIdbuisness-tag@
    @ManyToMany
    @JoinTable(name="SALON_HAS_TAG", 
        joinColumns=@JoinColumn(name="idtag"), 
        inverseJoinColumns=@JoinColumn(name="idsalon") 
    )
    private Set <Buisness> buisnessSalonHasTagViaIdbuisness = new HashSet <Buisness> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Tag() {
    }

	/**
	* All field constructor 
	*/
    public Tag(
       Integer idtag,
       String name) {
	 this(
       idtag,
       name
	 ,true);
	}
    
	public Tag(
       Integer idtag,
       String name	
    , boolean setRelationship) {
       //primary keys
       setIdtag (idtag);
       //attributes
       setName (name);
       //parents
    }

	public Tag flat() {
	   return new Tag(
          getIdtag(),
          getName()
       , false
	   );
	}

    public Integer getIdtag() {
        return idtag;
    }
	
    public void setIdtag (Integer idtag) {
        this.idtag =  idtag;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @salonHasTagViaTagByIdtag-getter-tag@
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Buisness> getBuisnessSalonHasTagViaIdbuisness() {
        if (buisnessSalonHasTagViaIdbuisness == null){
            buisnessSalonHasTagViaIdbuisness = new HashSet<Buisness>();
        }
        return buisnessSalonHasTagViaIdbuisness;
    }

    public void setBuisnessSalonHasTagViaIdbuisness (Set<Buisness> buisnessSalonHasTagViaIdbuisness) {
        this.buisnessSalonHasTagViaIdbuisness = buisnessSalonHasTagViaIdbuisness;
    }
    	
    public void addBuisnessSalonHasTagViaIdbuisness (Buisness element) {
        getBuisnessSalonHasTagViaIdbuisness().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
