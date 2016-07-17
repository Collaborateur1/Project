package other;

import javax.ws.rs.core.SecurityContext;

import model.custom.UserCustom;

public class WebContext {
   
    public WebContext( SecurityContext securityContext ) {
        super();
        this.securityContext = securityContext;
    }

    private final  SecurityContext securityContext;
    
    public UserCustom getUser()
    {
        return ((UserCustom)securityContext.getUserPrincipal());
    }
}
