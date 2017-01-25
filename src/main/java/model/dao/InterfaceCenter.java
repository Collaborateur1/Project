package model.dao;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.SessionFactory;

import json.Jsonmap;

public interface InterfaceCenter<T extends Executable> {
    public boolean exist(T object)throws Exception;
    public boolean create(T object ,ConcurrentHashMap<String, Object> item) throws Exception;
    public boolean update(T object ,ConcurrentHashMap<String, Object> item)throws Exception;
    public boolean delete(T object,ConcurrentHashMap<String, Object> item)throws Exception;
    public Object read(Class<T> object,String[][] restriction)throws Exception;
    public Object read(T object,boolean lazyLoad)throws Exception;
    public Object read(Class<T> object,String  id, boolean lazyLoad)throws Exception;
    public void loadLazyCollection(T object)throws Exception;
    public List<Object> list(Class<T> object,String[][] restriction,String[][] order,String[][] alias )throws Exception;
    public boolean delete(Class<T> object ,String id,ConcurrentHashMap<String, Object> item )throws Exception;
    //nom de lobjet principale, autre objet ds la requete avec alias, close where, order, valeur a remonté et  groupe by
    public List complexList(Class<?> object,String[][] alias,String[][] restriction,String[][] order,String[][] projection, int firstResult,int maxResult)throws Exception;
  
    public SessionFactory getSessionFactory()throws Exception;
   
    public List<String>complexList(String request,String[][] params, int firstResult,int maxResult)throws Exception;
    
    public Object read(Class<T> object,Jsonmap param);
    //nom de lobjet principale, autre objet ds la requete avec alias, close where, order, valeur a remonté et  groupe by
    public List complexList(Class<?> object,Jsonmap param);
}
