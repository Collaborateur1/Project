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
 * <p>Title: Manager</p>
 *
 * <p>Description: Domain Object describing a Manager entity</p>
 *
 */
@Entity (name="Manager")
@Table (name="\"manager\"")
@NamedQueries ({
	 @NamedQuery(name="Manager.findAll", query="SELECT a FROM Manager a")
	,@NamedQuery(name="Manager.findByEmail", query="SELECT a FROM Manager a WHERE a.email = :email")
	,@NamedQuery(name="Manager.findByEmailContaining", query="SELECT a FROM Manager a WHERE a.email like :email")

	,@NamedQuery(name="Manager.findByFirstname", query="SELECT a FROM Manager a WHERE a.firstname = :firstname")
	,@NamedQuery(name="Manager.findByFirstnameContaining", query="SELECT a FROM Manager a WHERE a.firstname like :firstname")

	,@NamedQuery(name="Manager.findByLastname", query="SELECT a FROM Manager a WHERE a.lastname = :lastname")
	,@NamedQuery(name="Manager.findByLastnameContaining", query="SELECT a FROM Manager a WHERE a.lastname like :lastname")

	,@NamedQuery(name="Manager.findByTelephone", query="SELECT a FROM Manager a WHERE a.telephone = :telephone")
	,@NamedQuery(name="Manager.findByTelephoneContaining", query="SELECT a FROM Manager a WHERE a.telephone like :telephone")

})

public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Manager.findAll";
    public static final String FIND_BY_EMAIL = "Manager.findByEmail";
    public static final String FIND_BY_EMAIL_CONTAINING ="Manager.findByEmailContaining";
    public static final String FIND_BY_FIRSTNAME = "Manager.findByFirstname";
    public static final String FIND_BY_FIRSTNAME_CONTAINING ="Manager.findByFirstnameContaining";
    public static final String FIND_BY_LASTNAME = "Manager.findByLastname";
    public static final String FIND_BY_LASTNAME_CONTAINING ="Manager.findByLastnameContaining";
    public static final String FIND_BY_TELEPHONE = "Manager.findByTelephone";
    public static final String FIND_BY_TELEPHONE_CONTAINING ="Manager.findByTelephoneContaining";
	
    @Id @Column(name="idmanager" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idmanager;

//MP-MANAGED-ADDED-AREA-BEGINNING @email-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @email-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-email@
    @Column(name="email"  , length=45 , nullable=false , unique=false)
    private String email; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @firstname-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @firstname-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-firstname@
    @Column(name="firstname"  , length=45 , nullable=false , unique=false)
    private String firstname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @lastname-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @lastname-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-lastname@
    @Column(name="lastname"  , length=45 , nullable=false , unique=false)
    private String lastname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @telephone-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @telephone-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-telephone@
    @Column(name="telephone"  , length=45 , nullable=false , unique=false)
    private String telephone; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessManagerViaIdmanager-field-manager@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Buisness.class, fetch=FetchType.LAZY, mappedBy="idmanager", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Buisness> buisnessManagerViaIdmanager = new HashSet<Buisness>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Manager() {
    }

	/**
	* All field constructor 
	*/
    public Manager(
       Integer idmanager,
       String email,
       String firstname,
       String lastname,
       String telephone) {
	 this(
       idmanager,
       email,
       firstname,
       lastname,
       telephone
	 ,true);
	}
    
	public Manager(
       Integer idmanager,
       String email,
       String firstname,
       String lastname,
       String telephone	
    , boolean setRelationship) {
       //primary keys
       setIdmanager (idmanager);
       //attributes
       setEmail (email);
       setFirstname (firstname);
       setLastname (lastname);
       setTelephone (telephone);
       //parents
    }

	public Manager flat() {
	   return new Manager(
          getIdmanager(),
          getEmail(),
          getFirstname(),
          getLastname(),
          getTelephone()
       , false
	   );
	}

    public Integer getIdmanager() {
        return idmanager;
    }
	
    public void setIdmanager (Integer idmanager) {
        this.idmanager =  idmanager;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-email@
    public String getEmail() {
        return email;
    }
	
    public void setEmail (String email) {
        this.email =  email;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-firstname@
    public String getFirstname() {
        return firstname;
    }
	
    public void setFirstname (String firstname) {
        this.firstname =  firstname;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-lastname@
    public String getLastname() {
        return lastname;
    }
	
    public void setLastname (String lastname) {
        this.lastname =  lastname;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-telephone@
    public String getTelephone() {
        return telephone;
    }
	
    public void setTelephone (String telephone) {
        this.telephone =  telephone;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessManagerViaIdmanager-getter-manager@
    public Set<Buisness> getBuisnessManagerViaIdmanager() {
        if (buisnessManagerViaIdmanager == null){
            buisnessManagerViaIdmanager = new HashSet<Buisness>();
        }
        return buisnessManagerViaIdmanager;
    }

    public void setBuisnessManagerViaIdmanager (Set<Buisness> buisnessManagerViaIdmanager) {
        this.buisnessManagerViaIdmanager = buisnessManagerViaIdmanager;
    }	
    
    public void addBuisnessManagerViaIdmanager (Buisness element) {
    	    getBuisnessManagerViaIdmanager().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
