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
	* - name      : DomainEntityJPA2Metamodel
	* - file name : DomainEntityJPA2Metamodel.vm
	* - time      : 2016/12/01 ap. J.-C. at 15:46:40 CST
*/
package defaultroot.defautmodel.domain.defautmodel;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import defaultroot.defautmodel.domain.defautmodel.Avis;
import defaultroot.defautmodel.domain.defautmodel.Notification;
import defaultroot.defautmodel.domain.defautmodel.ReservationClient;
import defaultroot.defautmodel.domain.defautmodel.Adress;
import defaultroot.defautmodel.domain.defautmodel.Adress;
import defaultroot.defautmodel.domain.defautmodel.Attachment;

@StaticMetamodel(Client.class)
public class Client_ {

    public static volatile SingularAttribute<Client, Integer> idclient;

    public static volatile SingularAttribute<Client, String> email;
    public static volatile SingularAttribute<Client, String> password;
    public static volatile SingularAttribute<Client, String> firstname;
    public static volatile SingularAttribute<Client, String> lastname;
    public static volatile SingularAttribute<Client, String> telephone;
    public static volatile SingularAttribute<Client, Date> birthdate;
    public static volatile SingularAttribute<Client, Adress> idhomeAddress;
    public static volatile SingularAttribute<Client, Integer> idhomeAddress_;
    public static volatile SingularAttribute<Client, Adress> idworkAddress;
    public static volatile SingularAttribute<Client, Integer> idworkAddress_;

    public static volatile SetAttribute<Client, Avis> avisClientViaIdclient;
    public static volatile SetAttribute<Client, Notification> notificationClientViaClientIdclient;
    public static volatile SetAttribute<Client, ReservationClient> reservationClientClientViaIdclient;

    public static volatile SetAttribute<Client, Attachment> attachmentClientHasAttachmentViaIdattachment;

}
