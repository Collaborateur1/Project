package controller.routePro;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import other.WebContext;

@Path( "/generic" )
public class RouteGenericProDataProvider extends WebContext {

    public RouteGenericProDataProvider( @Context SecurityContext securityContext ) {
        super( securityContext );
        // TODO Auto-generated constructor stub
    }

}