package model.bean;

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
@Table(name="ScheduleDay")
public class ScheduleDay  implements Executable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "scheDayId")
    private String scheDayId;
    
    @Column(name = "scheDay")
    private int scheDay;
    
    @Column(name = "scheStartDay")
    private int scheStartDay;
    
    @Column(name = "scheEndDay")
    private int scheEndDay;
    
    
    
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Schedule   scheDaySchedule;
    
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy="breaScheduleDay")
    private List<Break> scheDayBreak;


    public String getScheDayId() {
        return scheDayId;
    }


    public void setScheDayId( String scheDayId ) {
        this.scheDayId = scheDayId;
    }


    public int getScheDay() {
        return scheDay;
    }


    public void setScheDay( int scheDay ) {
        this.scheDay = scheDay;
    }


    public int getScheStartDay() {
        return scheStartDay;
    }


    public void setScheStartDay( int scheStartDay ) {
        this.scheStartDay = scheStartDay;
    }


    public int getScheEndDay() {
        return scheEndDay;
    }


    public void setScheEndDay( int scheEndDay ) {
        this.scheEndDay = scheEndDay;
    }


    public Schedule getScheDaySchedule() {
        return scheDaySchedule;
    }


    public void setScheDaySchedule( Schedule scheDaySchedule ) {
        this.scheDaySchedule = scheDaySchedule;
    }


    public List<Break> getScheDayBreak() {
        return scheDayBreak;
    }


    public void setScheDayBreak( List<Break> scheDayBreak ) {
        this.scheDayBreak = scheDayBreak;
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
        return scheDayId;
    }
    
}
