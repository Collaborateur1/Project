package model.provider;

import java.util.Enumeration;
import java.util.Hashtable;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import model.custom.UserCustom;
import model.session.UserSession;


@Service("usersProvider")
public class UsersProviderImpl implements UsersProvider {
private Hashtable<String, UserSession> ListUserSession=new Hashtable<String, UserSession>();



public  UserSession getUserSession(String token) {
    return ListUserSession.get( token );
}
public boolean deleteUser(String Token)
{
    return (ListUserSession.remove( Token )!=null);
}
public  boolean userExist(String token) {
    return ListUserSession.containsKey( token );
}
public  void setUserSession(String token, UserSession user) {
    ListUserSession.put( token ,  user);
}
public Hashtable<String, UserSession> getListUserSession() {
    return ListUserSession;
}
//le boolean pour dire si on doit mettre a jour la date de connexion
public boolean userIsValidForConnect(String token, boolean connection){
    UserSession user=ListUserSession.get (token);
    if(user!=null)
    {
        if(connection)
            user.setLastAccessedTime(  DateTime.now() );
        //ajouter user is valide
        return user.tokenValide();
    }
    return false;
}

public UserCustom userIsAlreadyConnected(String email){
    
    Enumeration<UserSession> userS=null;
    userS=ListUserSession.elements();
    UserCustom user;       
    while (userS.hasMoreElements())
            {
             user=userS.nextElement().getUser( email );
                if(user!=null)
                {
                    return user;
                }
            }
    return null;
}

public int cleanUser()
{
    Enumeration<UserSession> users= ListUserSession.elements();
    Enumeration<String> keys= ListUserSession.keys();
    UserSession user;
    String key;
    while(users.hasMoreElements()&&keys.hasMoreElements())
    {
         user=users.nextElement();
         key=keys.nextElement();
         
         if(user!=null)
         {
             if(!user.isActive()||!user.tokenValide())
             {
                 removeUser(key);
             }
             
             
             
         }else
         {
             removeUser(key);
         }
    }
    return 0;
}
public void setListUserSession( Hashtable<String, UserSession> listUserSession ) {
    ListUserSession = listUserSession;
}

public boolean logOut(String token)
{
   return (removeUser(token));
}
public boolean removeUser(String token){
    return (ListUserSession.remove(token)!=null);
}

}
