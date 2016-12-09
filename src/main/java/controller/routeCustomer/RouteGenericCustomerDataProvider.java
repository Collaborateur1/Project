package controller.routeCustomer;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import other.WebContext;

@Path( "/generic" )
public class RouteGenericCustomerDataProvider extends WebContext {

    public RouteGenericCustomerDataProvider( @Context SecurityContext securityContext ) {
        super( securityContext );
        // TODO Auto-generated constructor stub
    }

}
