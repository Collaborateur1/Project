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
import defaultroot.defautmodel.domain.defautmodel.Client;
import defaultroot.defautmodel.domain.defautmodel.Client;

/**
 *
 * <p>Title: Adress</p>
 *
 * <p>Description: Domain Object describing a Adress entity</p>
 *
 */
@Entity (name="Adress")
@Table (name="\"adress\"")
@NamedQueries ({
	 @NamedQuery(name="Adress.findAll", query="SELECT a FROM Adress a")
	,@NamedQuery(name="Adress.findByVoie", query="SELECT a FROM Adress a WHERE a.voie = :voie")
	,@NamedQuery(name="Adress.findByVoieContaining", query="SELECT a FROM Adress a WHERE a.voie like :voie")

	,@NamedQuery(name="Adress.findByZipcode", query="SELECT a FROM Adress a WHERE a.zipcode = :zipcode")

})

public class Adress implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Adress.findAll";
    public static final String FIND_BY_VOIE = "Adress.findByVoie";
    public static final String FIND_BY_VOIE_CONTAINING ="Adress.findByVoieContaining";
    public static final String FIND_BY_ZIPCODE = "Adress.findByZipcode";
	
    @Id @Column(name="idadress" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idadress;

//MP-MANAGED-ADDED-AREA-BEGINNING @voie-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @voie-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-voie@
    @Column(name="voie"  , length=45 , nullable=true , unique=false)
    private String voie; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @zipcode-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @zipcode-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-zipcode@
    @Column(name="zipcode"   , nullable=true , unique=false)
    private Integer zipcode; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessAdressViaIdadress-field-adress@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Buisness.class, fetch=FetchType.LAZY, mappedBy="idadress", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Buisness> buisnessAdressViaIdadress = new HashSet<Buisness>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @clientAdressViaIdhomeAddress-field-adress@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Client.class, fetch=FetchType.LAZY, mappedBy="idhomeAddress", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Client> clientAdressViaIdhomeAddress = new HashSet<Client>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @clientAdressViaIdworkAddress-field-adress@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Client.class, fetch=FetchType.LAZY, mappedBy="idworkAddress", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Client> clientAdressViaIdworkAddress = new HashSet<Client>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Adress() {
    }

	/**
	* All field constructor 
	*/
    public Adress(
       Integer idadress,
       String voie,
       Integer zipcode) {
	 this(
       idadress,
       voie,
       zipcode
	 ,true);
	}
    
	public Adress(
       Integer idadress,
       String voie,
       Integer zipcode	
    , boolean setRelationship) {
       //primary keys
       setIdadress (idadress);
       //attributes
       setVoie (voie);
       setZipcode (zipcode);
       //parents
    }

	public Adress flat() {
	   return new Adress(
          getIdadress(),
          getVoie(),
          getZipcode()
       , false
	   );
	}

    public Integer getIdadress() {
        return idadress;
    }
	
    public void setIdadress (Integer idadress) {
        this.idadress =  idadress;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-voie@
    public String getVoie() {
        return voie;
    }
	
    public void setVoie (String voie) {
        this.voie =  voie;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-zipcode@
    public Integer getZipcode() {
        return zipcode;
    }
	
    public void setZipcode (Integer zipcode) {
        this.zipcode =  zipcode;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @buisnessAdressViaIdadress-getter-adress@
    public Set<Buisness> getBuisnessAdressViaIdadress() {
        if (buisnessAdressViaIdadress == null){
            buisnessAdressViaIdadress = new HashSet<Buisness>();
        }
        return buisnessAdressViaIdadress;
    }

    public void setBuisnessAdressViaIdadress (Set<Buisness> buisnessAdressViaIdadress) {
        this.buisnessAdressViaIdadress = buisnessAdressViaIdadress;
    }	
    
    public void addBuisnessAdressViaIdadress (Buisness element) {
    	    getBuisnessAdressViaIdadress().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @clientAdressViaIdhomeAddress-getter-adress@
    public Set<Client> getClientAdressViaIdhomeAddress() {
        if (clientAdressViaIdhomeAddress == null){
            clientAdressViaIdhomeAddress = new HashSet<Client>();
        }
        return clientAdressViaIdhomeAddress;
    }

    public void setClientAdressViaIdhomeAddress (Set<Client> clientAdressViaIdhomeAddress) {
        this.clientAdressViaIdhomeAddress = clientAdressViaIdhomeAddress;
    }	
    
    public void addClientAdressViaIdhomeAddress (Client element) {
    	    getClientAdressViaIdhomeAddress().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @clientAdressViaIdworkAddress-getter-adress@
    public Set<Client> getClientAdressViaIdworkAddress() {
        if (clientAdressViaIdworkAddress == null){
            clientAdressViaIdworkAddress = new HashSet<Client>();
        }
        return clientAdressViaIdworkAddress;
    }

    public void setClientAdressViaIdworkAddress (Set<Client> clientAdressViaIdworkAddress) {
        this.clientAdressViaIdworkAddress = clientAdressViaIdworkAddress;
    }	
    
    public void addClientAdressViaIdworkAddress (Client element) {
    	    getClientAdressViaIdworkAddress().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
