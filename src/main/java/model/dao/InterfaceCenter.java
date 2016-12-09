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
    public List<Object> list(Class<T> object,String[][] restriction,String[][] order,String[][] alias );
    public boolean delete(Class<T> object ,String id,ConcurrentHashMap<String, Object> item );
    //nom de lobjet principale, autre objet ds la requete avec alias, close where, order, valeur a remonté et  groupe by
    public List complexList(Class<?> object,String[][] alias,String[][] restriction,String[][] order,String[][] projection, int firstResult,int maxResult);
  
    public SessionFactory getSessionFactory();
   
    public List<String>complexList(String request,String[][] params, int firstResult,int maxResult);
    
    public Object read(Class<T> object,Jsonmap param);
    //nom de lobjet principale, autre objet ds la requete avec alias, close where, order, valeur a remonté et  groupe by
    public List complexList(Class<?> object,Jsonmap param);
}
