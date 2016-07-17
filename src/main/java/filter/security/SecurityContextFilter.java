package filter.security;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;

import model.dao.UserDao;
import model.provider.UsersProviderImpl;
import model.session.UserSession;
import other.DefaultProperties;

/**
 * Filter all incoming requests, look for possible session information and use that
 * to create and load a SecurityContext to request. 
 * 
 * 
 */
@Component   // let spring manage the lifecycle
@Provider    // register as jersey's provider
public class SecurityContextFilter implements ResourceFilter, ContainerRequestFilter {
 
    @Autowired(required=true)
    private UsersProviderImpl usersProviderImpl;  // DAO to access Session
 
    @Autowired(required=true)
    private UserDao userDao;  // DAO to access User
 private ArrayList<String> AuthorizedURL=initHashtable();
     
    @Override
    public ContainerRequest filter(ContainerRequest request) {
        // Get session id from request header
         String sessionId="";
        try{
            Map<String, Cookie> cookie=request.getCookies();
            
        sessionId = cookie.get("cookie").getValue();
        
        }catch(Exception e){
            
            try{
                MultivaluedMap<String, String> map= request.getQueryParameters();
                sessionId=map.getFirst("token");
                }catch(Exception ex){
                    
                }
            
            
            
        }
      
        UserSession session = null;
        String uri=request.getPath( true ).toString();
       
            // Load session object from repository
        if(sessionId==null)
            sessionId="";
        
            session = usersProviderImpl.getUserSession(sessionId);
            
            
                   
             if(!AuthorizedURL.contains(uri)&&session==null)
             {
                 URI targetURIForRedirection=null;
                 try {
                     targetURIForRedirection = new URI("login/page"+"?fowardTo="+uri);
                 } catch ( URISyntaxException e ) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
         
                 throw new  WebApplicationException(Response.seeOther(targetURIForRedirection).build());
             }
                 
            // Load associated user from session, a changé***
          /*  if (null != session) {
                user = session.getUser();
            }
            */
        
       
       

        // Set security context
        request.setSecurityContext(new AuthentificationRestEndPointSecure(session));
        return request;
    }
 
    @Override
    public ContainerRequestFilter getRequestFilter() {
        return this;
    }
 
    @Override
    public ContainerResponseFilter getResponseFilter() {
        return null;
    }
   public ArrayList<String> initHashtable()
   {
       ArrayList<String> temp=new ArrayList<String>();
       String st[]=DefaultProperties.getProperties( "authorizedurl" ).split(";");
      
       for(int i=0;i<st.length;i++)
           temp.add(st[i]); 
       
       
       return temp;
      
       
   }
}
