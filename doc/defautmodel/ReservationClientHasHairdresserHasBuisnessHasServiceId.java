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
	* - name      : DomainEntityJPA2EmbeddedId
	* - file name : DomainEntityJPA2EmbeddedId.vm
	* - time      : 2016/12/01 ap. J.-C. at 15:46:40 CST
*/
package defaultroot.defautmodel.domain.defautmodel;

import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

/**
 *
 * <p>Title: ReservationClientHasHairdresserHasBuisnessHasServiceId</p>
 *
 * <p>Description: Embedded Id describing a ReservationClientHasHairdresserHasBuisnessHasServiceId entity primary key</p>
 *
 */
@Embeddable
public class ReservationClientHasHairdresserHasBuisnessHasServiceId implements Serializable {


    @Column(name="idreservation_client"  ,nullable=false)
    private Integer idreservationClient;

    @Column(name="idhairdresser"  ,nullable=false)
    private Integer idhairdresser;

    @Column(name="idbuisness"  ,nullable=false)
    private Integer idbuisness;

    @Column(name="idservice"  ,nullable=false)
    private Integer idservice;

	public Integer getIdreservationClient() {
        return idreservationClient;
    }
	
    public void setIdreservationClient (Integer idreservationClient) {
        this.idreservationClient = idreservationClient;
    }

	public Integer getIdhairdresser() {
        return idhairdresser;
    }
	
    public void setIdhairdresser (Integer idhairdresser) {
        this.idhairdresser = idhairdresser;
    }

	public Integer getIdbuisness() {
        return idbuisness;
    }
	
    public void setIdbuisness (Integer idbuisness) {
        this.idbuisness = idbuisness;
    }

	public Integer getIdservice() {
        return idservice;
    }
	
    public void setIdservice (Integer idservice) {
        this.idservice = idservice;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return obj.toString().equals(this.toString());
    }
 
    @Override
    public int hashCode() {
        return toString().hashCode();
    }
 
    @Override
    public String toString() {
        return "ReservationClientHasHairdresserHasBuisnessHasServiceId:" 
        + ":" + idbuisness
        + ":" + idservice
        + ":" + idhairdresser
        ;
    }
    
}
