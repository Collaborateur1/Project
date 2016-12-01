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
 * <p>Title: Break</p>
 *
 * <p>Description: Domain Object describing a Break entity</p>
 *
 */
@Entity (name="Break")
@Table (name="\"break\"")
@NamedQueries ({
	 @NamedQuery(name="Break.findAll", query="SELECT a FROM Break a")
	,@NamedQuery(name="Break.findByStartdate", query="SELECT a FROM Break a WHERE a.startdate = :startdate")

	,@NamedQuery(name="Break.findByEnddate", query="SELECT a FROM Break a WHERE a.enddate = :enddate")

	,@NamedQuery(name="Break.findByNote", query="SELECT a FROM Break a WHERE a.note = :note")
	,@NamedQuery(name="Break.findByNoteContaining", query="SELECT a FROM Break a WHERE a.note like :note")

})

public class Break implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Break.findAll";
    public static final String FIND_BY_STARTDATE = "Break.findByStartdate";
    public static final String FIND_BY_ENDDATE = "Break.findByEnddate";
    public static final String FIND_BY_NOTE = "Break.findByNote";
    public static final String FIND_BY_NOTE_CONTAINING ="Break.findByNoteContaining";
	
    @Id @Column(name="idbreak" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idbreak;

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

//MP-MANAGED-ADDED-AREA-BEGINNING @note-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @note-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-note@
    @Column(name="note"  , length=45 , nullable=true , unique=false)
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
    public Break() {
    }

	/**
	* All field constructor 
	*/
    public Break(
       Integer idbreak,
       Timestamp startdate,
       Timestamp enddate,
       String note,
       Integer hairdresserIdhairdresser) {
	 this(
       idbreak,
       startdate,
       enddate,
       note,
       hairdresserIdhairdresser
	 ,true);
	}
    
	public Break(
       Integer idbreak,
       Timestamp startdate,
       Timestamp enddate,
       String note,
       Integer hairdresserIdhairdresser	
    , boolean setRelationship) {
       //primary keys
       setIdbreak (idbreak);
       //attributes
       setStartdate (startdate);
       setEnddate (enddate);
       setNote (note);
       //parents
       if (setRelationship && hairdresserIdhairdresser!=null) {
          this.hairdresserIdhairdresser = new Hairdresser();
          this.hairdresserIdhairdresser.setIdhairdresser(hairdresserIdhairdresser);
	      setHairdresserIdhairdresser_ (hairdresserIdhairdresser);
       }
    }

	public Break flat() {
	   return new Break(
          getIdbreak(),
          getStartdate(),
          getEnddate(),
          getNote(),
          getHairdresserIdhairdresser_()
       , false
	   );
	}

    public Integer getIdbreak() {
        return idbreak;
    }
	
    public void setIdbreak (Integer idbreak) {
        this.idbreak =  idbreak;
    }
    
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
