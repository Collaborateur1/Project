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
 * <p>Title: BuisnessHasServiceHasAttachmentId</p>
 *
 * <p>Description: Embedded Id describing a BuisnessHasServiceHasAttachmentId entity primary key</p>
 *
 */
@Embeddable
public class BuisnessHasServiceHasAttachmentId implements Serializable {


    @Column(name="buisness_has_service_buisness_idbuisness"  ,nullable=false)
    private Integer buisnessHasServiceBuisnessIdbuisness;

    @Column(name="buisness_has_service_service_idservice"  ,nullable=false)
    private Integer buisnessHasServiceServiceIdservice;

    @Column(name="attachment_idattachment"  ,nullable=false)
    private Integer attachmentIdattachment;

	public Integer getBuisnessHasServiceBuisnessIdbuisness() {
        return buisnessHasServiceBuisnessIdbuisness;
    }
	
    public void setBuisnessHasServiceBuisnessIdbuisness (Integer buisnessHasServiceBuisnessIdbuisness) {
        this.buisnessHasServiceBuisnessIdbuisness = buisnessHasServiceBuisnessIdbuisness;
    }

	public Integer getBuisnessHasServiceServiceIdservice() {
        return buisnessHasServiceServiceIdservice;
    }
	
    public void setBuisnessHasServiceServiceIdservice (Integer buisnessHasServiceServiceIdservice) {
        this.buisnessHasServiceServiceIdservice = buisnessHasServiceServiceIdservice;
    }

	public Integer getAttachmentIdattachment() {
        return attachmentIdattachment;
    }
	
    public void setAttachmentIdattachment (Integer attachmentIdattachment) {
        this.attachmentIdattachment = attachmentIdattachment;
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
        return "BuisnessHasServiceHasAttachmentId:" 
        + ":" + buisnessHasServiceServiceIdservice
        + ":" + buisnessHasServiceBuisnessIdbuisness
        + ":" + attachmentIdattachment
        ;
    }
    
}
