package model.custom;

import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Entity;
import javax.persistence.Table;

import model.bean.DefaultScheduleTask;
@Entity
@Table(name="ScheduleTask")
public class ScheduleTaskCustom extends DefaultScheduleTask{
    @Override
    public boolean presave( ConcurrentHashMap<String, Object> item ) {
        // TODO Auto-generated method stub
        super.presave( item );
        return false;
    }
    @Override
    public boolean postsave( ConcurrentHashMap<String, Object> item ) {
        // TODO Auto-generated method stub
        super.presave( item );
        return false;
    }
}
