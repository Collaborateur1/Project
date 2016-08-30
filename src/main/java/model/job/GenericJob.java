package model.job;

import java.util.List;

import json.Jsonmap;
import model.dao.Executable;
//a quoi sert le extends executable ? 
public interface GenericJob<T extends Executable> {
    public boolean createObject(T obj);
    public boolean updateObject(T obj);
    public boolean deleteObject(T obj);
    public boolean deleteObject(Class<T> cls, String id);
    public Object getObject(Class<T> cls, String id, boolean lazyLoad);
    public Object getObject(T obj,boolean lazyLoad);
    public void loadLazyCollection(T obj);
    public List<Object> getListObject(Class<T> cls, String[][] restriction);
    public List<Object> getListObject(Class<T> cls, String restriction);
    public List getList(Class<T> cls,String[][] alias ,String[][] restriction,String[][] order,String[][] projection,int maxResult, int firstResult);
    public List getList(Class<T> cls,String alias ,String restriction,String order,String[] projection);
    

    public List<Object> getListObject(Class<T> cls, Jsonmap param);
    public List<Object> getList(Class<T> cls,Jsonmap param);
    public List<String>getList(String sql);
    
    
    
    
}
