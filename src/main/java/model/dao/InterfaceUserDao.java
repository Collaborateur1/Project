package model.dao;

import java.util.List;

import model.custom.UserCustom;



public interface InterfaceUserDao extends InterfaceCenter {
   
    public UserCustom getUserById(int id);
    public UserCustom getUserByLogin(String login);
    public int getUsersCount();
    public List<UserCustom> getUsers();
    public boolean create(UserCustom user);
    public UserCustom getUser(String email,String mdp);
    public  boolean AuthorizerUser(String email,String mdp);
    boolean UserExiste2( String email );
    public boolean UpdateUser(UserCustom user);
    
}
