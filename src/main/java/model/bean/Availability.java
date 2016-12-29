package model.bean;

import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import model.dao.Executable;

@Entity
@Table(name="Availability")
public class Availability  implements Executable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "avaiId")
    private String avaiId;
    @JsonIgnore
    @Column(name="avaiStartDate")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime avaiStartDate;
    @JsonIgnore
    @Column(name="avaiEndDate") 
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime avaiEndDate;
    
    @Column(name="avaiNote",length=60) 
    private String avaiNote;
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JsonBackReference
    private ScheduleDay   avaiScheduleDay;

    public String getavaiId() {
        return avaiId;
    }

    public void setavaiId( String avaiId ) {
        this.avaiId = avaiId;
    }
public String getFormatedAvaiStartDate(){
    return avaiStartDate.toString();
}

public String getFormatedAvaiEndtDate(){
    return avaiEndDate.toString();
}
    public DateTime getavaiStartDate() {
        return avaiStartDate;
    }

    public void setavaiStartDate( DateTime avaiStartDate ) {
        this.avaiStartDate = avaiStartDate;
    }

    public DateTime getavaiEndDate() {
        return avaiEndDate;
    }

    public void setavaiEndDate( DateTime avaiEndDate ) {
        this.avaiEndDate = avaiEndDate;
    }

    public String getavaiNote() {
        return avaiNote;
    }

    public void setavaiNote( String avaiNote ) {
        this.avaiNote = avaiNote;
    }

    public ScheduleDay getavaiScheduleDay() {
        return avaiScheduleDay;
    }

    public void setavaiScheduleDay( ScheduleDay avaiScheduleDay ) {
        this.avaiScheduleDay = avaiScheduleDay;
    }

    @Override
    public boolean presave( ConcurrentHashMap<String, Object> item ) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean postsave( ConcurrentHashMap<String, Object> item ) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getID() throws Exception {
        // TODO Auto-generated method stub
        return avaiId;
    }
    
}