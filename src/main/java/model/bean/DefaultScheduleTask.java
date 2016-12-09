package model.bean;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import model.dao.Executable;
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DefaultScheduleTask implements Executable{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "DstID")
    private String DstID;
    
    @Column(name="DstCreatedDate")
    private Date DstCreatedDate;
    
    @Column(name="DstUpdDate")
    private Date DstUpdDate;
    
    @Column(name="DstTaskToExecute")
    private String DstTaskToExecute;
    
    @Column(name="DstAlreadyExecuted")
    private int DstAlreadyExecuted;
    
    @Column(name="DstType")
    private String DstType;
    
    @Column(name="Dstparam1")
    private String Dstparam1;
    
    @Column(name="Dstparam2")
    private String Dstparam2;
    
    @Column(name="Dstparam3")
    private String Dstparam3;
    
    public String getDstID() {
        return DstID;
    }
    public void setDstID( String dstID ) {
        DstID = dstID;
    }
    public Date getDstCreatedDate() {
        return DstCreatedDate;
    }
    public void setDstCreatedDate( Date dstCreatedDate ) {
        DstCreatedDate = dstCreatedDate;
    }
    public Date getDstUpdDate() {
        return DstUpdDate;
    }
    public void setDstUpdDate( Date dstUpdDate ) {
        DstUpdDate = dstUpdDate;
    }
    public String getDstTaskToExecute() {
        return DstTaskToExecute;
    }
    public void setDstTaskToExecute( String dstTaskToExecute ) {
        DstTaskToExecute = dstTaskToExecute;
    }
    public int getDstAlreadyExecuted() {
        return DstAlreadyExecuted;
    }
    public void setDstAlreadyExecuted( int dstAlreadyExecuted ) {
        DstAlreadyExecuted = dstAlreadyExecuted;
    }
    public String getDstType() {
        return DstType;
    }
    public void setDstType( String dstType ) {
        DstType = dstType;
    }
    public String getDstparam1() {
        return Dstparam1;
    }
    public void setDstparam1( String dstparam1 ) {
        Dstparam1 = dstparam1;
    }
    public String getDstparam2() {
        return Dstparam2;
    }
    public void setDstparam2( String dstparam2 ) {
        Dstparam2 = dstparam2;
    }
    public String getDstparam3() {
        return Dstparam3;
    }
    public void setDstparam3( String dstparam3 ) {
        Dstparam3 = dstparam3;
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
        return null;
    }

}
