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

/**
 *
 * <p>Title: ScheduleTime</p>
 *
 * <p>Description: Domain Object describing a ScheduleTime entity</p>
 *
 */
@Entity (name="ScheduleTime")
@Table (name="\"schedule_time\"")
@NamedQueries ({
	 @NamedQuery(name="ScheduleTime.findAll", query="SELECT a FROM ScheduleTime a")
	,@NamedQuery(name="ScheduleTime.findByStart", query="SELECT a FROM ScheduleTime a WHERE a.start = :start")

	,@NamedQuery(name="ScheduleTime.findByEnd", query="SELECT a FROM ScheduleTime a WHERE a.end = :end")

})

public class ScheduleTime implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "ScheduleTime.findAll";
    public static final String FIND_BY_START = "ScheduleTime.findByStart";
    public static final String FIND_BY_END = "ScheduleTime.findByEnd";
	
    @Id @Column(name="idschedule_time" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idscheduleTime;

//MP-MANAGED-ADDED-AREA-BEGINNING @start-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @start-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-start@
    @Column(name="start"   , nullable=false , unique=false)
    private java.sql.Time start; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @end-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @end-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-end@
    @Column(name="end"   , nullable=false , unique=false)
    private java.sql.Time end; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="schedule_day_idday", referencedColumnName = "idday" , nullable=false , unique=false , insertable=true, updatable=true) 
    private ScheduleDay scheduleDayIdday;  

    @Column(name="schedule_day_idday"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer scheduleDayIdday_;

    /**
    * Default constructor
    */
    public ScheduleTime() {
    }

	/**
	* All field constructor 
	*/
    public ScheduleTime(
       Integer idscheduleTime,
       java.sql.Time start,
       java.sql.Time end,
       Integer scheduleDayIdday) {
	 this(
       idscheduleTime,
       start,
       end,
       scheduleDayIdday
	 ,true);
	}
    
	public ScheduleTime(
       Integer idscheduleTime,
       java.sql.Time start,
       java.sql.Time end,
       Integer scheduleDayIdday	
    , boolean setRelationship) {
       //primary keys
       setIdscheduleTime (idscheduleTime);
       //attributes
       setStart (start);
       setEnd (end);
       //parents
       if (setRelationship && scheduleDayIdday!=null) {
          this.scheduleDayIdday = new ScheduleDay();
          this.scheduleDayIdday.setIdday(scheduleDayIdday);
	      setScheduleDayIdday_ (scheduleDayIdday);
       }
    }

	public ScheduleTime flat() {
	   return new ScheduleTime(
          getIdscheduleTime(),
          getStart(),
          getEnd(),
          getScheduleDayIdday_()
       , false
	   );
	}

    public Integer getIdscheduleTime() {
        return idscheduleTime;
    }
	
    public void setIdscheduleTime (Integer idscheduleTime) {
        this.idscheduleTime =  idscheduleTime;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-start@
    public java.sql.Time getStart() {
        return start;
    }
	
    public void setStart (java.sql.Time start) {
        this.start =  start;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-end@
    public java.sql.Time getEnd() {
        return end;
    }
	
    public void setEnd (java.sql.Time end) {
        this.end =  end;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public ScheduleDay getScheduleDayIdday () {
    	return scheduleDayIdday;
    }
	
    public void setScheduleDayIdday (ScheduleDay scheduleDayIdday) {
    	this.scheduleDayIdday = scheduleDayIdday;
    }

    public Integer getScheduleDayIdday_() {
        return scheduleDayIdday_;
    }
	
    public void setScheduleDayIdday_ (Integer scheduleDayIdday) {
        this.scheduleDayIdday_ =  scheduleDayIdday;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
