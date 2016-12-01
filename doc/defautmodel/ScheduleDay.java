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
import defaultroot.defautmodel.domain.defautmodel.ScheduleTime;
import defaultroot.defautmodel.domain.defautmodel.Schedule;

/**
 *
 * <p>Title: ScheduleDay</p>
 *
 * <p>Description: Domain Object describing a ScheduleDay entity</p>
 *
 */
@Entity (name="ScheduleDay")
@Table (name="\"schedule_day\"")
@NamedQueries ({
	 @NamedQuery(name="ScheduleDay.findAll", query="SELECT a FROM ScheduleDay a")
	,@NamedQuery(name="ScheduleDay.findByDay", query="SELECT a FROM ScheduleDay a WHERE a.day = :day")

})

public class ScheduleDay implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "ScheduleDay.findAll";
    public static final String FIND_BY_DAY = "ScheduleDay.findByDay";
	
    @Id @Column(name="idday" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idday;

//MP-MANAGED-ADDED-AREA-BEGINNING @day-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @day-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-day@
    @Column(name="day"   , nullable=false , unique=false)
    private Integer day; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="schedule_idschedule", referencedColumnName = "idschedule" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Schedule scheduleIdschedule;  

    @Column(name="schedule_idschedule"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer scheduleIdschedule_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scheduleTimeScheduleDayViaScheduleDayIdday-field-schedule_day@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.ScheduleTime.class, fetch=FetchType.LAZY, mappedBy="scheduleDayIdday", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <ScheduleTime> scheduleTimeScheduleDayViaScheduleDayIdday = new HashSet<ScheduleTime>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public ScheduleDay() {
    }

	/**
	* All field constructor 
	*/
    public ScheduleDay(
       Integer idday,
       Integer day,
       Integer scheduleIdschedule) {
	 this(
       idday,
       day,
       scheduleIdschedule
	 ,true);
	}
    
	public ScheduleDay(
       Integer idday,
       Integer day,
       Integer scheduleIdschedule	
    , boolean setRelationship) {
       //primary keys
       setIdday (idday);
       //attributes
       setDay (day);
       //parents
       if (setRelationship && scheduleIdschedule!=null) {
          this.scheduleIdschedule = new Schedule();
          this.scheduleIdschedule.setIdschedule(scheduleIdschedule);
	      setScheduleIdschedule_ (scheduleIdschedule);
       }
    }

	public ScheduleDay flat() {
	   return new ScheduleDay(
          getIdday(),
          getDay(),
          getScheduleIdschedule_()
       , false
	   );
	}

    public Integer getIdday() {
        return idday;
    }
	
    public void setIdday (Integer idday) {
        this.idday =  idday;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-day@
    public Integer getDay() {
        return day;
    }
	
    public void setDay (Integer day) {
        this.day =  day;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Schedule getScheduleIdschedule () {
    	return scheduleIdschedule;
    }
	
    public void setScheduleIdschedule (Schedule scheduleIdschedule) {
    	this.scheduleIdschedule = scheduleIdschedule;
    }

    public Integer getScheduleIdschedule_() {
        return scheduleIdschedule_;
    }
	
    public void setScheduleIdschedule_ (Integer scheduleIdschedule) {
        this.scheduleIdschedule_ =  scheduleIdschedule;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scheduleTimeScheduleDayViaScheduleDayIdday-getter-schedule_day@
    public Set<ScheduleTime> getScheduleTimeScheduleDayViaScheduleDayIdday() {
        if (scheduleTimeScheduleDayViaScheduleDayIdday == null){
            scheduleTimeScheduleDayViaScheduleDayIdday = new HashSet<ScheduleTime>();
        }
        return scheduleTimeScheduleDayViaScheduleDayIdday;
    }

    public void setScheduleTimeScheduleDayViaScheduleDayIdday (Set<ScheduleTime> scheduleTimeScheduleDayViaScheduleDayIdday) {
        this.scheduleTimeScheduleDayViaScheduleDayIdday = scheduleTimeScheduleDayViaScheduleDayIdday;
    }	
    
    public void addScheduleTimeScheduleDayViaScheduleDayIdday (ScheduleTime element) {
    	    getScheduleTimeScheduleDayViaScheduleDayIdday().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
