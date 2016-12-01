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
import defaultroot.defautmodel.domain.defautmodel.ScheduleDay;
import defaultroot.defautmodel.domain.defautmodel.Hairdresser;

/**
 *
 * <p>Title: Schedule</p>
 *
 * <p>Description: Domain Object describing a Schedule entity</p>
 *
 */
@Entity (name="Schedule")
@Table (name="\"schedule\"")
@NamedQueries ({
	 @NamedQuery(name="Schedule.findAll", query="SELECT a FROM Schedule a")
	,@NamedQuery(name="Schedule.findByName", query="SELECT a FROM Schedule a WHERE a.name = :name")
	,@NamedQuery(name="Schedule.findByNameContaining", query="SELECT a FROM Schedule a WHERE a.name like :name")

	,@NamedQuery(name="Schedule.findByActive", query="SELECT a FROM Schedule a WHERE a.active = :active")

})

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Schedule.findAll";
    public static final String FIND_BY_NAME = "Schedule.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="Schedule.findByNameContaining";
    public static final String FIND_BY_ACTIVE = "Schedule.findByActive";
	
    @Id @Column(name="idschedule" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idschedule;

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=45 , nullable=false , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @active-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @active-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-active@
    @Column(name="active"   , nullable=false , unique=false)
    private Boolean active; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="hairdresser_idhairdresser", referencedColumnName = "idhairdresser" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Hairdresser hairdresserIdhairdresser;  

    @Column(name="hairdresser_idhairdresser"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer hairdresserIdhairdresser_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scheduleDayScheduleViaScheduleIdschedule-field-schedule@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.ScheduleDay.class, fetch=FetchType.LAZY, mappedBy="scheduleIdschedule", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <ScheduleDay> scheduleDayScheduleViaScheduleIdschedule = new HashSet<ScheduleDay>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Schedule() {
    }

	/**
	* All field constructor 
	*/
    public Schedule(
       Integer idschedule,
       String name,
       Boolean active,
       Integer hairdresserIdhairdresser) {
	 this(
       idschedule,
       name,
       active,
       hairdresserIdhairdresser
	 ,true);
	}
    
	public Schedule(
       Integer idschedule,
       String name,
       Boolean active,
       Integer hairdresserIdhairdresser	
    , boolean setRelationship) {
       //primary keys
       setIdschedule (idschedule);
       //attributes
       setName (name);
       setActive (active);
       //parents
       if (setRelationship && hairdresserIdhairdresser!=null) {
          this.hairdresserIdhairdresser = new Hairdresser();
          this.hairdresserIdhairdresser.setIdhairdresser(hairdresserIdhairdresser);
	      setHairdresserIdhairdresser_ (hairdresserIdhairdresser);
       }
    }

	public Schedule flat() {
	   return new Schedule(
          getIdschedule(),
          getName(),
          getActive(),
          getHairdresserIdhairdresser_()
       , false
	   );
	}

    public Integer getIdschedule() {
        return idschedule;
    }
	
    public void setIdschedule (Integer idschedule) {
        this.idschedule =  idschedule;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-active@
    public Boolean getActive() {
        return active;
    }
	
    public void setActive (Boolean active) {
        this.active =  active;
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
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scheduleDayScheduleViaScheduleIdschedule-getter-schedule@
    public Set<ScheduleDay> getScheduleDayScheduleViaScheduleIdschedule() {
        if (scheduleDayScheduleViaScheduleIdschedule == null){
            scheduleDayScheduleViaScheduleIdschedule = new HashSet<ScheduleDay>();
        }
        return scheduleDayScheduleViaScheduleIdschedule;
    }

    public void setScheduleDayScheduleViaScheduleIdschedule (Set<ScheduleDay> scheduleDayScheduleViaScheduleIdschedule) {
        this.scheduleDayScheduleViaScheduleIdschedule = scheduleDayScheduleViaScheduleIdschedule;
    }	
    
    public void addScheduleDayScheduleViaScheduleIdschedule (ScheduleDay element) {
    	    getScheduleDayScheduleViaScheduleIdschedule().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
