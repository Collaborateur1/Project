package filter.security;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import model.custom.UserCustom;


public class AuthentificationRestEndPointSecure implements javax.ws.rs.core.SecurityContext {
 

    private final UserCustom user;
    private final Boolean isSecure;
    public AuthentificationRestEndPointSecure(UserCustom user, Boolean isSecure) {
        this.user = user;
        this.isSecure=isSecure;
  
    }
 
    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
 
    @Override
    public Principal getUserPrincipal() {
        return user;
    }
 
    @Override
    public boolean isSecure() {
        return isSecure;
    }
 
    @Override
    public boolean isUserInRole(String role) {
 
        if (null == user || !isSecure) {
           
            // Forbidden
           /* Response denied = Response.status(Response.Status.FORBIDDEN).entity("Permission Denied").build();
            throw new WebApplicationException(denied); */
            URI targetURIForRedirection=null;
            try {
                targetURIForRedirection = new URI( "login/page" );
            } catch ( URISyntaxException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
             throw new WebApplicationException(Response.seeOther(targetURIForRedirection).build());
        }
 
        try {
            // this user has this role?
            return user.getDusRoles().contains(UserCustom.Role.valueOf(role));
        } catch (Exception e) {
        }
         
        return false;
    }
}
