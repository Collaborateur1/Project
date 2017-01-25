package model.job;

import java.util.List;

import json.Jsonmap;
import model.dao.Executable;
//a quoi sert le extends executable ? 
public interface GenericJob<T extends Executable> {
    public boolean createObject(T obj) throws Exception;
    public boolean updateObject(T obj)throws Exception;
    public boolean deleteObject(T obj)throws Exception;
    public boolean deleteObject(Class<T> cls, String id)throws Exception;
    public Object getObject(Class<T> cls, String id, boolean lazyLoad)throws Exception;
    public Object getObject(T obj,boolean lazyLoad)throws Exception;
    public void loadLazyCollection(T obj)throws Exception;
    public List<Object> getListObjectV1(Class<?> cls, String[][] restriction,String[][] order,String[][] alias)throws Exception;
    public List<Object> getListObjectV2(Class<T> cls, String restriction)throws Exception;
    public List getList(Class<T> cls,String[][] alias ,String[][] restriction,String[][] order,String[][] projection,int maxResult, int firstResult)throws Exception;
    public List getList(Class<T> cls,String alias ,String restriction,String order,String[] projection)throws Exception;
    public List<String>getList(String request,String[][] params, int firstResult,int maxResult)throws Exception;

    public List<Object> getListObject(Class<T> cls, Jsonmap param);
    public List<Object> getList(Class<T> cls,Jsonmap param);
 
    
    
    
    
}
