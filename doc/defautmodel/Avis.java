/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9.8
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2016/12/01 ap. J.-C. at 15:46:40 CST
*/
package defaultroot.defautmodel.domain.defautmodel;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import java.io.Serializable;
import javax.persistence.*;
import defaultroot.defautmodel.domain.defautmodel.Client;
import defaultroot.defautmodel.domain.defautmodel.Buisness;

/**
 *
 * <p>Title: Avis</p>
 *
 * <p>Description: Domain Object describing a Avis entity</p>
 *
 */
@Entity (name="Avis")
@Table (name="\"avis\"")
@NamedQueries ({
	 @NamedQuery(name="Avis.findAll", query="SELECT a FROM Avis a")
	,@NamedQuery(name="Avis.findByRating", query="SELECT a FROM Avis a WHERE a.rating = :rating")

	,@NamedQuery(name="Avis.findByComment", query="SELECT a FROM Avis a WHERE a.comment = :comment")
	,@NamedQuery(name="Avis.findByCommentContaining", query="SELECT a FROM Avis a WHERE a.comment like :comment")

})

public class Avis implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Avis.findAll";
    public static final String FIND_BY_RATING = "Avis.findByRating";
    public static final String FIND_BY_COMMENT = "Avis.findByComment";
    public static final String FIND_BY_COMMENT_CONTAINING ="Avis.findByCommentContaining";
	
    @Id @Column(name="idavis" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idavis;

//MP-MANAGED-ADDED-AREA-BEGINNING @rating-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @rating-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-rating@
    @Column(name="rating"   , nullable=false , unique=false)
    private Integer rating; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @comment-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @comment-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-comment@
    @Column(name="comment"  , length=45 , nullable=true , unique=false)
    private String comment; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="idclient", referencedColumnName = "idclient" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Client idclient;  

    @Column(name="idclient"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer idclient_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="salon_idsalon", referencedColumnName = "idbuisness" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Buisness salonIdsalon;  

    @Column(name="salon_idsalon"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer salonIdsalon_;

    /**
    * Default constructor
    */
    public Avis() {
    }

	/**
	* All field constructor 
	*/
    public Avis(
       Integer idavis,
       Integer idclient,
       Integer salonIdsalon,
       Integer rating,
       String comment) {
	 this(
       idavis,
       idclient,
       salonIdsalon,
       rating,
       comment
	 ,true);
	}
    
	public Avis(
       Integer idavis,
       Integer idclient,
       Integer salonIdsalon,
       Integer rating,
       String comment	
    , boolean setRelationship) {
       //primary keys
       setIdavis (idavis);
       //attributes
       setRating (rating);
       setComment (comment);
       //parents
       if (setRelationship && idclient!=null) {
          this.idclient = new Client();
          this.idclient.setIdclient(idclient);
	      setIdclient_ (idclient);
       }
       if (setRelationship && salonIdsalon!=null) {
          this.salonIdsalon = new Buisness();
          this.salonIdsalon.setIdbuisness(salonIdsalon);
	      setSalonIdsalon_ (salonIdsalon);
       }
    }

	public Avis flat() {
	   return new Avis(
          getIdavis(),
          getIdclient_(),
          getSalonIdsalon_(),
          getRating(),
          getComment()
       , false
	   );
	}

    public Integer getIdavis() {
        return idavis;
    }
	
    public void setIdavis (Integer idavis) {
        this.idavis =  idavis;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-rating@
    public Integer getRating() {
        return rating;
    }
	
    public void setRating (Integer rating) {
        this.rating =  rating;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-comment@
    public String getComment() {
        return comment;
    }
	
    public void setComment (String comment) {
        this.comment =  comment;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Client getIdclient () {
    	return idclient;
    }
	
    public void setIdclient (Client idclient) {
    	this.idclient = idclient;
    }

    public Integer getIdclient_() {
        return idclient_;
    }
	
    public void setIdclient_ (Integer idclient) {
        this.idclient_ =  idclient;
    }
	
    public Buisness getSalonIdsalon () {
    	return salonIdsalon;
    }
	
    public void setSalonIdsalon (Buisness salonIdsalon) {
    	this.salonIdsalon = salonIdsalon;
    }

    public Integer getSalonIdsalon_() {
        return salonIdsalon_;
    }
	
    public void setSalonIdsalon_ (Integer salonIdsalon) {
        this.salonIdsalon_ =  salonIdsalon;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
