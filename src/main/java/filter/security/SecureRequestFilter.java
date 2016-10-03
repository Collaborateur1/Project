package filter.security;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import model.session.UserSession;
import other.DefaultProperties;
import other.SpringFactory;
import other.token.Utils;

@Provider
@PreMatching
public class SecureRequestFilter implements ContainerRequestFilter  {
    private static Logger   logger       = Logger.getLogger( SecureRequestFilter.class );
    private ArrayList<String> AuthorizedURL=initHashtable();

    @Context
    private HttpServletRequest servletRequest;
    @Override
    public void filter( ContainerRequestContext requestContext ) throws IOException {
        // TODO Auto-generated method stub
        
        if ( requestContext.getRequest().getMethod().equals( "OPTIONS" ) ) {
            requestContext.abortWith( Response.status( Response.Status.OK ).build() );
            return;
        }
        
        
        String sessionId="";
        try{
            
           // sessionId= requestContext.getHeaderString( HttpHeaderNames.SERVICE_KEY );
            
            sessionId=Utils.getCookieValue( requestContext, HttpHeaderNames.AUTH_TOKEN);
          
       
        
        }catch(Exception e){
            logger.debug( e );
           // throw new  WebApplicationException( Response.status( Response.Status.UNAUTHORIZED ).build());
            
            
            
        }
      
        UserSession session = null;
        String uri=requestContext.getUriInfo().getPath( true ).toString();
       
            // Load session object from repository
        if(sessionId==null)
            sessionId="";
        
            session = SpringFactory.getUsersProvider().getUserSession(sessionId);
            
            boolean valideToken=false;
            boolean sessionToken=true;
            try{
            if(session!=null){
                valideToken=Utils.AuthTokenIsValide(session.getUser(),sessionId);
                sessionToken=valideToken;
            }
            }catch(Exception ex){
                logger.debug( "a error occure with function 'AuthTokenIsValide'",ex );
                valideToken=false; 
            }
            
             if(!AuthorizedURL.contains(uri)&&!sessionToken)
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
             if(session==null)
                 session=new UserSession();
          requestContext.setSecurityContext(new AuthentificationRestEndPointSecure(session));
          requestContext.setProperty( "valideToken", valideToken );
          requestContext.setProperty( "Token", sessionId );
          
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
