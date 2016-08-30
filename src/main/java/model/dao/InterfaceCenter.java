package model.dao;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.SessionFactory;

import json.Jsonmap;

public interface InterfaceCenter<T extends Executable> {
    public boolean exist(T object);
    public boolean create(T object ,ConcurrentHashMap<String, Object> item);
    public boolean update(T object ,ConcurrentHashMap<String, Object> item);
    public boolean delete(T object,ConcurrentHashMap<String, Object> item);
    public Object read(Class<T> object,String[][] restriction);
    public Object read(T object,boolean lazyLoad);
    public Object read(Class<T> object,String  id, boolean lazyLoad);
    public void loadLazyCollection(T object);
    public List<Object> list(Class<T> object,String[][] restriction,String[][] order );
    public boolean delete(Class<T> object ,String id,ConcurrentHashMap<String, Object> item );
    //nom de lobjet principale, autre objet ds la requete avec alias, close where, order, valeur a remonté et  groupe by
    public List complexList(Class<?> object,String[][] alias,String[][] restriction,String[][] order,String[][] projection,int maxResult, int firstResult);
    public SessionFactory getSessionFactory();
   
    public List<String>complexList(String sql);
    
    public Object read(Class<T> object,Jsonmap param);
    //nom de lobjet principale, autre objet ds la requete avec alias, close where, order, valeur a remonté et  groupe by
    public List complexList(Class<?> object,Jsonmap param);
}
