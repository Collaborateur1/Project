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

import model.custom.UserCustom;
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
          
       
        
        }catch(Exception ex){
            logger.error( ex.getStackTrace()[0].getMethodName(),ex);
           // throw new  WebApplicationException( Response.status( Response.Status.UNAUTHORIZED ).build());
            
            
            
        }
      
        UserCustom user = null;
        String uri=requestContext.getUriInfo().getPath( true ).toString();
        if("".equals( uri )){
            URI targetURIForRedirection=null;
            try {
                
                targetURIForRedirection = new URI(DefaultProperties.getProperties( "login" ));
            } catch ( URISyntaxException ex ) {
                // TODO Auto-generated catch block
                logger.error( ex.getStackTrace()[0].getMethodName(),ex);
            }
            throw new  WebApplicationException(Response.seeOther(targetURIForRedirection).build());
        }
            // Load session object from repository
        if(sessionId==null)
            sessionId="";
        
        user = SpringFactory.getUsersProvider().getCacheUserSession(sessionId);
            if(user==null){
                user=new UserCustom();
            }
            boolean valideToken=false;
           
            try{
            if(user!=null){
                valideToken=Utils.AuthTokenIsValide(user,sessionId);
                
            }
            }catch(Exception ex){
                logger.error( ex.getStackTrace()[0].getMethodName(),ex);
                valideToken=false; 
            }
            
             if(!AuthorizedURL.contains(uri)&&!valideToken)
             {
                 URI targetURIForRedirection=null;
                 try {
                     if("".equals( uri )){
                         uri="";
                 }else{
                     uri="?fowardTo="+uri;
                 }
                     targetURIForRedirection = new URI(DefaultProperties.getProperties( "login" )+uri);
                 } catch ( URISyntaxException ex ) {
                     // TODO Auto-generated catch block
                     logger.error( ex.getStackTrace()[0].getMethodName(),ex);
                 }
         
                 throw new  WebApplicationException(Response.seeOther(targetURIForRedirection).build());
             }
                 
            // Load associated user from session, a changé***
          /*  if (null != session) {
                user = session.getUser();
            }
            */
        
       
       
             
        // Set security context
          //if user is null set a empty user for role access    
             if(user==null)
                 user=new UserCustom();
          requestContext.setSecurityContext(new AuthentificationRestEndPointSecure(user,valideToken));
          requestContext.setProperty( "valideToken", valideToken );
          requestContext.setProperty( "Token", sessionId );
          
    }
    
    public ArrayList<String> initHashtable()
    {
        ArrayList<String> temp=new ArrayList<String>();
        String st[]=DefaultProperties.getProperties( "authorizedurl" ).split(";");
       
        for(int i=0;i<st.length;i++)
            temp.add(st[i].trim()); 
        
        
        return temp;
       
        
    }
}
