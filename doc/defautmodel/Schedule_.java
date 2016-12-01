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

import defaultroot.defautmodel.domain.defautmodel.ScheduleDay;
import defaultroot.defautmodel.domain.defautmodel.Hairdresser;

@StaticMetamodel(Schedule.class)
public class Schedule_ {

    public static volatile SingularAttribute<Schedule, Integer> idschedule;

    public static volatile SingularAttribute<Schedule, String> name;
    public static volatile SingularAttribute<Schedule, Boolean> active;
    public static volatile SingularAttribute<Schedule, Hairdresser> hairdresserIdhairdresser;
    public static volatile SingularAttribute<Schedule, Integer> hairdresserIdhairdresser_;

    public static volatile SetAttribute<Schedule, ScheduleDay> scheduleDayScheduleViaScheduleIdschedule;


}
