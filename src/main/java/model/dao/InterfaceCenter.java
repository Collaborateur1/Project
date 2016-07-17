package model.dao;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.SessionFactory;

public interface InterfaceCenter<T extends Executable> {
    public boolean exist(T object);
    public boolean create(T object ,ConcurrentHashMap<String, Object> item);
    public boolean update(T object ,ConcurrentHashMap<String, Object> item);
    public boolean delete(T object);
    public Object read(Class<?> object,String[][] restriction);
    public List<Object> list(Class<?> object,String[][] restriction,String[][] order );
    //nom de lobjet principale, autre objet ds la requete avec alias, close where, order, valeur a remonté et  groupe by
    public List complexList(Class<?> object,String[][] alias,String[][] restriction,String[][] order,String[][] projection);
    public SessionFactory getSessionFactory();
}
