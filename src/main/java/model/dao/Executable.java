package model.dao;

import java.util.concurrent.ConcurrentHashMap;

public interface Executable {
public boolean presave( ConcurrentHashMap<String, Object> item);
public boolean postsave( ConcurrentHashMap<String, Object> item);
public long getID()throws Exception;

}
