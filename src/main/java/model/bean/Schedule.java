package model.bean;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import model.dao.Executable;

@Entity
@Table(name="Schedule")
public class Schedule implements Executable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "scheId")
    private String scheId;

    @Column(name = "scheName", length=30)
    private String scheName;
    
    @Column(name = "scheDate")
    private Date scheDate;
    
    @Column(name = "scheStartDate")
    private Date scheStartDate;
    
    @Column(name = "scheEndDate")
    private Date scheEndDate;
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JsonBackReference
    private Hairdresser   scheHairdresser;   
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="scheDaySchedule")
    private List<ScheduleDay> scheScheDays;


    public String getScheId() {
        return scheId;
    }


    public void setScheId( String scheId ) {
        this.scheId = scheId;
    }


    public String getScheName() {
        return scheName;
    }


    public void setScheName( String scheName ) {
        this.scheName = scheName;
    }


    public Date getScheDate() {
        return scheDate;
    }


    public void setScheDate( Date scheDate ) {
        this.scheDate = scheDate;
    }


    public Hairdresser getScheHairdresser() {
        return scheHairdresser;
    }


    public void setScheHairdresser( Hairdresser scheHairdresser ) {
        this.scheHairdresser = scheHairdresser;
    }


    public List<ScheduleDay> getScheScheDays() {
        return scheScheDays;
    }


    public void setScheScheDays( List<ScheduleDay> scheScheDays ) {
        this.scheScheDays = scheScheDays;
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
        return scheId;
    }
    
}
