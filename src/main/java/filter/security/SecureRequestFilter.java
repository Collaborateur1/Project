package filter.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import other.DefaultProperties;

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
       
     /*   
        String sessionId=null;
        try{
            
           // sessionId= requestContext.getHeaderString( HttpHeaderNames.SERVICE_KEY );
            
            sessionId=Utils.getCookieValue( requestContext, HttpHeaderNames.AUTH_TOKEN);
          
       
        
        }catch(Exception ex){
            logger.error( ex.getStackTrace()[0].getMethodName(),ex);
         
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
      
        
        if("true".equals( DefaultProperties.getOption( "actorCache" ).toLowerCase())&&sessionId!=null)
        user = SpringFactory.getUsersProvider().getCacheUserSession(sessionId);
        
            if(user==null){
                user=new UserCustom();
            }
            boolean valideToken=false;
           
            try{         
                valideToken=Utils.AuthTokenIsValide(user,sessionId);
  
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
                 
          requestContext.setSecurityContext(new AuthentificationRestEndPointSecure(user,valideToken));
          requestContext.setProperty( "valideToken", valideToken );
          requestContext.setProperty( "Token", sessionId );
          */
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
