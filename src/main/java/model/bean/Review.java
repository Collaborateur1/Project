package model.bean;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import model.dao.Executable;

@Entity
@Table(name="Review")
public class Review  implements Executable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "reviId")
    private String reviId;
    
    
    @Column(name = "reviRating")
    private int reviRating;
    
    @Column(name = "reviComment", length=800)
    private String reviComment;
    
    @Column(name = "reviDate")
    private Date reviDate;
    
    
    @ManyToOne(cascade = CascadeType.MERGE,optional = false)
    @JsonBackReference
    private Hairdresser   reviHairdresser;


    public String getReviId() {
        return reviId;
    }


    public void setReviId( String reviId ) {
        this.reviId = reviId;
    }


    public int getReviRating() {
        return reviRating;
    }


    public void setReviRating( int reviRating ) {
        this.reviRating = reviRating;
    }


    public String getReviComment() {
        return reviComment;
    }


    public void setReviComment( String reviComment ) {
        this.reviComment = reviComment;
    }


    public Date getReviDate() {
        return reviDate;
    }


    public void setReviDate( Date reviDate ) {
        this.reviDate = reviDate;
    }


    public Hairdresser getReviHairdresser() {
        return reviHairdresser;
    }


    public void setReviHairdresser( Hairdresser reviHairdresser ) {
        this.reviHairdresser = reviHairdresser;
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
        return reviId;
    }
   
}
