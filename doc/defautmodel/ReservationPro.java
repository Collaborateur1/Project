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
import defaultroot.defautmodel.domain.defautmodel.Hairdresser;

/**
 *
 * <p>Title: ReservationPro</p>
 *
 * <p>Description: Domain Object describing a ReservationPro entity</p>
 *
 */
@Entity (name="ReservationPro")
@Table (name="\"reservation_pro\"")
@NamedQueries ({
	 @NamedQuery(name="ReservationPro.findAll", query="SELECT a FROM ReservationPro a")
	,@NamedQuery(name="ReservationPro.findByName", query="SELECT a FROM ReservationPro a WHERE a.name = :name")
	,@NamedQuery(name="ReservationPro.findByNameContaining", query="SELECT a FROM ReservationPro a WHERE a.name like :name")

	,@NamedQuery(name="ReservationPro.findByFirstname", query="SELECT a FROM ReservationPro a WHERE a.firstname = :firstname")
	,@NamedQuery(name="ReservationPro.findByFirstnameContaining", query="SELECT a FROM ReservationPro a WHERE a.firstname like :firstname")

	,@NamedQuery(name="ReservationPro.findByStartdate", query="SELECT a FROM ReservationPro a WHERE a.startdate = :startdate")

	,@NamedQuery(name="ReservationPro.findByEnddate", query="SELECT a FROM ReservationPro a WHERE a.enddate = :enddate")

	,@NamedQuery(name="ReservationPro.findByNumero", query="SELECT a FROM ReservationPro a WHERE a.numero = :numero")
	,@NamedQuery(name="ReservationPro.findByNumeroContaining", query="SELECT a FROM ReservationPro a WHERE a.numero like :numero")

	,@NamedQuery(name="ReservationPro.findByNote", query="SELECT a FROM ReservationPro a WHERE a.note = :note")
	,@NamedQuery(name="ReservationPro.findByNoteContaining", query="SELECT a FROM ReservationPro a WHERE a.note like :note")

})

public class ReservationPro implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "ReservationPro.findAll";
    public static final String FIND_BY_NAME = "ReservationPro.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="ReservationPro.findByNameContaining";
    public static final String FIND_BY_FIRSTNAME = "ReservationPro.findByFirstname";
    public static final String FIND_BY_FIRSTNAME_CONTAINING ="ReservationPro.findByFirstnameContaining";
    public static final String FIND_BY_STARTDATE = "ReservationPro.findByStartdate";
    public static final String FIND_BY_ENDDATE = "ReservationPro.findByEnddate";
    public static final String FIND_BY_NUMERO = "ReservationPro.findByNumero";
    public static final String FIND_BY_NUMERO_CONTAINING ="ReservationPro.findByNumeroContaining";
    public static final String FIND_BY_NOTE = "ReservationPro.findByNote";
    public static final String FIND_BY_NOTE_CONTAINING ="ReservationPro.findByNoteContaining";
	
    @Id @Column(name="idreservation_pro" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idreservationPro;

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=45 , nullable=false , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @firstname-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @firstname-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-firstname@
    @Column(name="firstname"  , length=45 , nullable=true , unique=false)
    private String firstname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @startdate-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @startdate-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-startdate@
    @Column(name="startdate"   , nullable=false , unique=false)
    private Timestamp startdate; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @enddate-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @enddate-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-enddate@
    @Column(name="enddate"   , nullable=false , unique=false)
    private Timestamp enddate; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @numero-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @numero-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-numero@
    @Column(name="numero"  , length=45 , nullable=true , unique=false)
    private String numero; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @note-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @note-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-note@
    @Column(name="note"  , length=2000 , nullable=true , unique=false)
    private String note; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="hairdresser_idhairdresser", referencedColumnName = "idhairdresser" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Hairdresser hairdresserIdhairdresser;  

    @Column(name="hairdresser_idhairdresser"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer hairdresserIdhairdresser_;

    /**
    * Default constructor
    */
    public ReservationPro() {
    }

	/**
	* All field constructor 
	*/
    public ReservationPro(
       Integer idreservationPro,
       String name,
       String firstname,
       Timestamp startdate,
       Timestamp enddate,
       String numero,
       String note,
       Integer hairdresserIdhairdresser) {
	 this(
       idreservationPro,
       name,
       firstname,
       startdate,
       enddate,
       numero,
       note,
       hairdresserIdhairdresser
	 ,true);
	}
    
	public ReservationPro(
       Integer idreservationPro,
       String name,
       String firstname,
       Timestamp startdate,
       Timestamp enddate,
       String numero,
       String note,
       Integer hairdresserIdhairdresser	
    , boolean setRelationship) {
       //primary keys
       setIdreservationPro (idreservationPro);
       //attributes
       setName (name);
       setFirstname (firstname);
       setStartdate (startdate);
       setEnddate (enddate);
       setNumero (numero);
       setNote (note);
       //parents
       if (setRelationship && hairdresserIdhairdresser!=null) {
          this.hairdresserIdhairdresser = new Hairdresser();
          this.hairdresserIdhairdresser.setIdhairdresser(hairdresserIdhairdresser);
	      setHairdresserIdhairdresser_ (hairdresserIdhairdresser);
       }
    }

	public ReservationPro flat() {
	   return new ReservationPro(
          getIdreservationPro(),
          getName(),
          getFirstname(),
          getStartdate(),
          getEnddate(),
          getNumero(),
          getNote(),
          getHairdresserIdhairdresser_()
       , false
	   );
	}

    public Integer getIdreservationPro() {
        return idreservationPro;
    }
	
    public void setIdreservationPro (Integer idreservationPro) {
        this.idreservationPro =  idreservationPro;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-startdate@
    public Timestamp getStartdate() {
        return startdate;
    }
	
    public void setStartdate (Timestamp startdate) {
        this.startdate =  startdate;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-enddate@
    public Timestamp getEnddate() {
        return enddate;
    }
	
    public void setEnddate (Timestamp enddate) {
        this.enddate =  enddate;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-numero@
    public String getNumero() {
        return numero;
    }
	
    public void setNumero (String numero) {
        this.numero =  numero;
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


    public Hairdresser getHairdresserIdhairdresser () {
    	return hairdresserIdhairdresser;
    }
	
    public void setHairdresserIdhairdresser (Hairdresser hairdresserIdhairdresser) {
    	this.hairdresserIdhairdresser = hairdresserIdhairdresser;
    }

    public Integer getHairdresserIdhairdresser_() {
        return hairdresserIdhairdresser_;
    }
	
    public void setHairdresserIdhairdresser_ (Integer hairdresserIdhairdresser) {
        this.hairdresserIdhairdresser_ =  hairdresserIdhairdresser;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
