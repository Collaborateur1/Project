package model.session;

import java.io.Serializable;

import org.joda.time.DateTime;

import model.custom.UserCustom;

public class UserSession implements Serializable {
    public UserSession() {
        super();
    }
    public UserSession( String sessionId, UserCustom user, boolean active, boolean secure, DateTime createTime,
            DateTime lastAccessedTime ) {
        super();
        this.sessionId = sessionId;
        this.user = user;
        this.active = active;
        this.secure = secure;
        this.createTime = createTime;
        this.lastAccessedTime = lastAccessedTime;
    }
    // 
    private static final long serialVersionUID = -7483170872690892182L;
     
    private String sessionId;   // id
    private UserCustom user;      // user
    private boolean active;     // session active?
    private boolean secure;     // session secure?
 
    private  DateTime  createTime;    // session create time
    private DateTime lastAccessedTime;  // session last use time
    
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId( String sessionId ) {
        this.sessionId = sessionId;
    }
    
    public boolean isActive() {
        return active;
    }
    public void setActive( boolean active ) {
        this.active = active;
    }
    public boolean isSecure() {
        return secure;
    }
    public void setSecure( boolean secure ) {
        this.secure = secure;
    }
    public DateTime getCreateTime() {
        return createTime;
    }
    public void setCreateTime( DateTime createTime ) {
        this.createTime = createTime;
    }
    public DateTime getLastAccessedTime() {
        return lastAccessedTime;
    }
    public void setLastAccessedTime( DateTime lastAccessedTime ) {
        this.lastAccessedTime = lastAccessedTime;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public UserCustom getUser() {
        return user;
    }
    public void setUser( UserCustom user ) {
        this.user = user;
    }
    //return the current user if the imail corespond
    public UserCustom getUser(String email)
    {
        if(getUser().getDusEmail().equals( email))
            return getUser();
        return null;
    }
 public boolean tokenValide()
 {
     //Token valide 30 jour
     return createTime.plusDays(30).isAfterNow();
 }
    // getters/setters here
}
