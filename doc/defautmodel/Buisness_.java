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
import defaultroot.defautmodel.domain.defautmodel.BuisnessHasService;
import defaultroot.defautmodel.domain.defautmodel.Hairdresser;
import defaultroot.defautmodel.domain.defautmodel.BuisnessType;
import defaultroot.defautmodel.domain.defautmodel.Adress;
import defaultroot.defautmodel.domain.defautmodel.Manager;
import defaultroot.defautmodel.domain.defautmodel.Attachment;
import defaultroot.defautmodel.domain.defautmodel.Tag;

@StaticMetamodel(Buisness.class)
public class Buisness_ {

    public static volatile SingularAttribute<Buisness, Integer> idbuisness;

    public static volatile SingularAttribute<Buisness, String> name;
    public static volatile SingularAttribute<Buisness, Boolean> confirmation;
    public static volatile SingularAttribute<Buisness, String> description;
    public static volatile SingularAttribute<Buisness, BuisnessType> buisnessTypeIdtype;
    public static volatile SingularAttribute<Buisness, Integer> buisnessTypeIdtype_;
    public static volatile SingularAttribute<Buisness, Adress> idadress;
    public static volatile SingularAttribute<Buisness, Integer> idadress_;
    public static volatile SingularAttribute<Buisness, Manager> idmanager;
    public static volatile SingularAttribute<Buisness, Integer> idmanager_;

    public static volatile SetAttribute<Buisness, Avis> avisBuisnessViaSalonIdsalon;
    public static volatile SetAttribute<Buisness, BuisnessHasService> buisnessHasServiceBuisnessViaBuisnessIdbuisness;
    public static volatile SetAttribute<Buisness, Hairdresser> hairdresserBuisnessViaIdbuisness;

    public static volatile SetAttribute<Buisness, Attachment> attachmentBuisnessHasAttachmentViaIdattachment;
    public static volatile SetAttribute<Buisness, Tag> tagSalonHasTagViaIdtag;

}
