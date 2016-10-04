package model.provider;

import java.util.Hashtable;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import model.custom.UserCustom;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration.Strategy;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
import other.DefaultProperties;

@Service( "usersProvider" )
public class UsersProviderImpl implements UsersProvider {
    private Cache                  userSessionCache    ;
    private final String                   cacheName       = "UserSessionCache";

    
    @PostConstruct
    public void init() {
        CacheManager   sessionCache    =CacheManager.create();
        this.userSessionCache = new Cache(
                new CacheConfiguration( cacheName,
                        Integer.parseInt( DefaultProperties.geCacheProperties( "maxEntries" ) ) )
                                .memoryStoreEvictionPolicy( MemoryStoreEvictionPolicy.LFU )
                                .eternal( false )
                                .timeToLiveSeconds( Long.parseLong( DefaultProperties.getOption( "tokenMaxAge" ) ) )
                                .timeToIdleSeconds( Long.parseLong(DefaultProperties.geCacheProperties( "timeToIdleSeconds" )))
                                .diskExpiryThreadIntervalSeconds( 0 )
                                .persistence( new PersistenceConfiguration().strategy( Strategy.LOCALTEMPSWAP ) ) );
        sessionCache.addCache( this.userSessionCache );
        
    }
    
    public UserCustom getCacheUserSession( String token ) {
        Element elemt= userSessionCache.get( token );
        if(elemt!=null)
        return (UserCustom) elemt.getObjectValue();
        
        return null;

    }

    public boolean revokeUser( String token ) {
       
        return userSessionCache.remove( token );

    }
    public boolean userInCache( String token ) {
    
        return userSessionCache.isKeyInCache( token );
       
    }
    
    public void setUserInCache( String token, UserCustom user ) {
        
        userSessionCache.put(new Element(token, user) );
    }
    
    public int getCacheSize()
    { 
        return userSessionCache.getSize();
    }
    
    public Hashtable<String, UserCustom> getUsersInCache() {
       
       // userSessionCache.
        return null;
    }
    
    public UserCustom userCacheIsAlreadyConnected( String email ) {

        final Map<Object, Element> mapElements = userSessionCache.getAll(userSessionCache.getKeys()); 
      
        for (final Element element : mapElements.values()) { 
            
              if(((UserCustom)element.getObjectValue()).getDusEmail().equals( email ))
                  return (UserCustom)element.getObjectValue();
            } 
        
       
        return null;
    }
    


}
