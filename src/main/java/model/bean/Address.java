package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Address")
public class Address {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "addrId")
    private String addrID;
   
    @Column(name="addr1", length=60) 
    private String addr1;
    
    @Column(name="addr2", length=60)
    private String addr2;
    
    @Column(name="addrZip", length=7)
    private String addrZip;
    
    @Column(name="addrContry", length=24)
    private String addrContry;
    
    
    
    
    
    
}
