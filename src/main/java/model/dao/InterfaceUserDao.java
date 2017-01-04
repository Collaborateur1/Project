package model.dao;

import java.util.List;

import model.custom.UserCustom;



public interface InterfaceUserDao extends InterfaceCenter {
   
    public UserCustom getUserById(int id)throws Exception;
    public UserCustom getUserByLogin(String login)throws Exception;
    public int getUsersCount()throws Exception;
    public List<UserCustom> getUsers()throws Exception;
    public boolean create(UserCustom user)throws Exception;
    public UserCustom getUser(String email,String mdp)throws Exception;
    public  boolean AuthorizerUser(String email,String mdp)throws Exception;
    boolean UserExiste( String email )throws Exception;
    public boolean UpdateUser(UserCustom user)throws Exception;
    
}
