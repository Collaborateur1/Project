package model.bean;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

import model.dao.Executable;

@Entity
@Table(name="Break")
public class Break  implements Executable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "breaId")
    private String breaId;
    
    @Column(name="breaStartDate") 
    private Date breaStartDate;
    
    @Column(name="breaEndDate") 
    private Date breaEndDate;
    
    @Column(name="breaNote",length=60) 
    private String breaNote;
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JsonBackReference
    private ScheduleDay   breaScheduleDay;

    public String getBreaId() {
        return breaId;
    }

    public void setBreaId( String breaId ) {
        this.breaId = breaId;
    }

    public Date getBreaStartDate() {
        return breaStartDate;
    }

    public void setBreaStartDate( Date breaStartDate ) {
        this.breaStartDate = breaStartDate;
    }

    public Date getBreaEndDate() {
        return breaEndDate;
    }

    public void setBreaEndDate( Date breaEndDate ) {
        this.breaEndDate = breaEndDate;
    }

    public String getBreaNote() {
        return breaNote;
    }

    public void setBreaNote( String breaNote ) {
        this.breaNote = breaNote;
    }

    public ScheduleDay getBreaScheduleDay() {
        return breaScheduleDay;
    }

    public void setBreaScheduleDay( ScheduleDay breaScheduleDay ) {
        this.breaScheduleDay = breaScheduleDay;
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
        return breaId;
    }
    
}
