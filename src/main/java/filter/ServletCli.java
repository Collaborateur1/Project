package filter;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class ServletCli extends ResourceConfig{
    public ServletCli() {
        packages("controller.routeCustomer;controller.route");
        register(RolesAllowedDynamicFeature.class);
       
       // TODO Auto-generated constructor stub
   }
}
