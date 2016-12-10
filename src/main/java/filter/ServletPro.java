package filter;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class ServletPro extends ResourceConfig{
    public ServletPro() {
        packages("controller.routePro;filter.security;controller.route");
        register(RolesAllowedDynamicFeature.class);
       
       // TODO Auto-generated constructor stub
   }
}
