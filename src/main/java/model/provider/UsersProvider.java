package model.provider;

import java.util.Hashtable;

import model.custom.UserCustom;
import model.session.UserSession;

public interface UsersProvider {
    public  UserSession getUserSession(String token);
    public boolean deleteUser(String Token);
    public  boolean userExist(String token);
    public  void setUserSession(String token, UserSession user);
public Hashtable<String, UserSession> getListUserSession();
public boolean userIsValidForConnect(String token, boolean connection);
public int cleanUser();
public void setListUserSession( Hashtable<String, UserSession> listUserSession );
public boolean logOut(String token);
public boolean removeUser(String token);
public UserCustom userIsAlreadyConnected(String email);
}
