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

import defaultroot.defautmodel.domain.defautmodel.Notification;
import defaultroot.defautmodel.domain.defautmodel.ReservationClientHasHairdresserHasBuisnessHasService;
import defaultroot.defautmodel.domain.defautmodel.Client;

@StaticMetamodel(ReservationClient.class)
public class ReservationClient_ {

    public static volatile SingularAttribute<ReservationClient, Integer> idreservationClient;

    public static volatile SingularAttribute<ReservationClient, Timestamp> date;
    public static volatile SingularAttribute<ReservationClient, Timestamp> createDatetime;
    public static volatile SingularAttribute<ReservationClient, Timestamp> confirmDatetime;
    public static volatile SingularAttribute<ReservationClient, Timestamp> annulationDatetime;
    public static volatile SingularAttribute<ReservationClient, String> note;
    public static volatile SingularAttribute<ReservationClient, Client> idclient;
    public static volatile SingularAttribute<ReservationClient, Integer> idclient_;

    public static volatile SetAttribute<ReservationClient, Notification> notificationReservationClientViaIdreservation;
    public static volatile SetAttribute<ReservationClient, ReservationClientHasHairdresserHasBuisnessHasService> reservationClientHasHairdresserHasBuisnessHasServiceReservationClientViaIdreservationClient;


}
