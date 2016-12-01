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
import defaultroot.defautmodel.domain.defautmodel.ReservationClient;

/**
 *
 * <p>Title: Notification</p>
 *
 * <p>Description: Domain Object describing a Notification entity</p>
 *
 */
@Entity (name="Notification")
@Table (name="\"notification\"")
@NamedQueries ({
	 @NamedQuery(name="Notification.findAll", query="SELECT a FROM Notification a")
	,@NamedQuery(name="Notification.findByNotRead", query="SELECT a FROM Notification a WHERE a.notRead = :notRead")

	,@NamedQuery(name="Notification.findByAction", query="SELECT a FROM Notification a WHERE a.action = :action")
	,@NamedQuery(name="Notification.findByActionContaining", query="SELECT a FROM Notification a WHERE a.action like :action")

})

public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Notification.findAll";
    public static final String FIND_BY_NOTREAD = "Notification.findByNotRead";
    public static final String FIND_BY_ACTION = "Notification.findByAction";
    public static final String FIND_BY_ACTION_CONTAINING ="Notification.findByActionContaining";
	
    @Id @Column(name="idnotification" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idnotification;

//MP-MANAGED-ADDED-AREA-BEGINNING @not_read-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @not_read-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-not_read@
    @Column(name="not_read"   , nullable=false , unique=false)
    private Boolean notRead; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @action-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @action-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-action@
    @Column(name="action"  , length=45 , nullable=false , unique=false)
    private String action; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="client_idclient", referencedColumnName = "idclient" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Client clientIdclient;  

    @Column(name="client_idclient"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer clientIdclient_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="idreservation", referencedColumnName = "idreservation_client" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private ReservationClient idreservation;  

    @Column(name="idreservation"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer idreservation_;

    /**
    * Default constructor
    */
    public Notification() {
    }

	/**
	* All field constructor 
	*/
    public Notification(
       Integer idnotification,
       Boolean notRead,
       String action,
       Integer idreservation,
       Integer clientIdclient) {
	 this(
       idnotification,
       notRead,
       action,
       idreservation,
       clientIdclient
	 ,true);
	}
    
	public Notification(
       Integer idnotification,
       Boolean notRead,
       String action,
       Integer idreservation,
       Integer clientIdclient	
    , boolean setRelationship) {
       //primary keys
       setIdnotification (idnotification);
       //attributes
       setNotRead (notRead);
       setAction (action);
       //parents
       if (setRelationship && clientIdclient!=null) {
          this.clientIdclient = new Client();
          this.clientIdclient.setIdclient(clientIdclient);
	      setClientIdclient_ (clientIdclient);
       }
       if (setRelationship && idreservation!=null) {
          this.idreservation = new ReservationClient();
          this.idreservation.setIdreservationClient(idreservation);
	      setIdreservation_ (idreservation);
       }
    }

	public Notification flat() {
	   return new Notification(
          getIdnotification(),
          getNotRead(),
          getAction(),
          getIdreservation_(),
          getClientIdclient_()
       , false
	   );
	}

    public Integer getIdnotification() {
        return idnotification;
    }
	
    public void setIdnotification (Integer idnotification) {
        this.idnotification =  idnotification;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-not_read@
    public Boolean getNotRead() {
        return notRead;
    }
	
    public void setNotRead (Boolean notRead) {
        this.notRead =  notRead;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-action@
    public String getAction() {
        return action;
    }
	
    public void setAction (String action) {
        this.action =  action;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public Client getClientIdclient () {
    	return clientIdclient;
    }
	
    public void setClientIdclient (Client clientIdclient) {
    	this.clientIdclient = clientIdclient;
    }

    public Integer getClientIdclient_() {
        return clientIdclient_;
    }
	
    public void setClientIdclient_ (Integer clientIdclient) {
        this.clientIdclient_ =  clientIdclient;
    }
	
    public ReservationClient getIdreservation () {
    	return idreservation;
    }
	
    public void setIdreservation (ReservationClient idreservation) {
    	this.idreservation = idreservation;
    }

    public Integer getIdreservation_() {
        return idreservation_;
    }
	
    public void setIdreservation_ (Integer idreservation) {
        this.idreservation_ =  idreservation;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
