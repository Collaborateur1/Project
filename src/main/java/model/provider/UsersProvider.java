package model.provider;

import model.custom.UserCustom;

public interface UsersProvider {
    


public UserCustom userCacheIsAlreadyConnected( String email );
public void setUserInCache( String token, UserCustom user );
public UserCustom getCacheUserSession( String token );
public boolean revokeUser( String token );
}
