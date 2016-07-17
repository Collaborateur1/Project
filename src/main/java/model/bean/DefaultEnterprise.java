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
private Long enterpriseId;
 
 @Column(name="enterpriseName") 
private String enterpriseName;
 
 @Column(name="enterpriseHistory") 
private String enterpriseHistory;
 
 @Column(name="enterpriseCreation") 
private Date enterpriseCreation;
 
 @Column(name="enterpriseUpdate") 
private Date enterpriseUpdate;
 
 @Column(name="enterpriseBirth") 
private Date enterpriseBirth;
 
 @ManyToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
 @JoinTable( name = "Enterprise_Customer", joinColumns = {
         @JoinColumn( name = "enterpriseId", nullable = false, updatable = false ) }, inverseJoinColumns = {
                 @JoinColumn( name = "customerId", nullable = false, updatable = false ) })
 private List<CustomerCustom> enterpriseCustomers;

public Long getEnterpriseId() {
    return enterpriseId;
}
public void setEnterpriseId( Long enterpriseId ) {
    this.enterpriseId = enterpriseId;
}
public String getEnterpriseName() {
    return enterpriseName;
}
public void setEnterpriseName( String enterpriseName ) {
    this.enterpriseName = enterpriseName;
}
public String getEnterpriseHistory() {
    return enterpriseHistory;
}
public void setEnterpriseHistory( String enterpriseHistory ) {
    this.enterpriseHistory = enterpriseHistory;
}
public Date getEnterpriseCreation() {
    return enterpriseCreation;
}
public void setEnterpriseCreation( Date enterpriseCreation ) {
    this.enterpriseCreation = enterpriseCreation;
}
public Date getEnterpriseUpdate() {
    return enterpriseUpdate;
}
public void setEnterpriseUpdate( Date enterpriseUpdate ) {
    this.enterpriseUpdate = enterpriseUpdate;
}
public Date getEnterpriseBirth() {
    return enterpriseBirth;
}
public void setEnterpriseBirth( Date enterpriseBirth ) {
    this.enterpriseBirth = enterpriseBirth;
}
public List<CustomerCustom> getCustomers() {
    return enterpriseCustomers;
}
public void setCustomers( List<CustomerCustom> Customers ) {
    this.enterpriseCustomers = Customers;
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
    return enterpriseId;
}



}
