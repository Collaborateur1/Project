package model.bean;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

import model.custom.CustomerCustom;
import model.dao.Executable;
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DefaultEnterprise implements Executable {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
private Long entID;
 
 @Column(name="entName") 
private String entName;
 
 @Column(name="entHistory") 
private String entHistory;
 
 @Column(name="entCreation") 
private Date entCreation;
 
 @Column(name="entUpdate") 
private Date entUpdate;
 
 @Column(name="entBirth") 
private Date entBirth;
 
 @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.MERGE )
 @JoinTable( name = "Enterprise_Customer", joinColumns = {
         @JoinColumn( name = "entID", nullable = false, updatable = false ) }, inverseJoinColumns = {
                 @JoinColumn( name = "cusID", nullable = false, updatable = false ) })
 private List<CustomerCustom> entCustomers;


public Long getEntID() {
    return entID;
}
public void setEntID( Long entID ) {
    this.entID = entID;
}
public String getEntName() {
    return entName;
}
public void setEntName( String entName ) {
    this.entName = entName;
}
public String getEntHistory() {
    return entHistory;
}
public void setEntHistory( String entHistory ) {
    this.entHistory = entHistory;
}
public Date getEntCreation() {
    return entCreation;
}
public void setEntCreation( Date entCreation ) {
    this.entCreation = entCreation;
}
public Date getEntUpdate() {
    return entUpdate;
}
public void setEntUpdate( Date entUpdate ) {
    this.entUpdate = entUpdate;
}
public Date getEntBirth() {
    return entBirth;
}
public void setEntBirth( Date entBirth ) {
    this.entBirth = entBirth;
}
public List<CustomerCustom> getEntCustomers() {
    return entCustomers;
}
public void setEntCustomers( List<CustomerCustom> entCustomers ) {
    this.entCustomers = entCustomers;
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
public long getID() throws Exception {
    // TODO Auto-generated method stub
    return getEntID();
}



}
