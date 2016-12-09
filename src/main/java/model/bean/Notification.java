package model.bean;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import model.dao.Executable;

@Entity
@Table(name="Notification")
public class Notification  implements Executable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "notiId")
    private String notiId;
    
    @Column(name = "notiDate")
    private Date notiDate;
    
    @Column(name = "notiRead")
    private boolean notiRead;
    
    @Column(name = "notiType")
    private String notiType;
    
    @ManyToOne(optional = true)//mandatory
    @JoinColumn(name="appoId")
    private Appointment notiAppointment;
    
    @ManyToOne(optional = true)//no mandatory
    @JoinColumn(name="custId")
    private Custumer notiCustumer;

    public String getNotiId() {
        return notiId;
    }

    public void setNotiId( String notiId ) {
        this.notiId = notiId;
    }

    public Date getNotiDate() {
        return notiDate;
    }

    public void setNotiDate( Date notiDate ) {
        this.notiDate = notiDate;
    }

    public boolean isNotiRead() {
        return notiRead;
    }

    public void setNotiRead( boolean notiRead ) {
        this.notiRead = notiRead;
    }

    public String getNotiType() {
        return notiType;
    }

    public void setNotiType( String notiType ) {
        this.notiType = notiType;
    }

    public Appointment getNotiAppointment() {
        return notiAppointment;
    }

    public void setNotiAppointment( Appointment notiAppointment ) {
        this.notiAppointment = notiAppointment;
    }

    public Custumer getNotiCustumer() {
        return notiCustumer;
    }

    public void setNotiCustumer( Custumer notiCustumer ) {
        this.notiCustumer = notiCustumer;
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
        return notiId;
    }
    
    
    
}
