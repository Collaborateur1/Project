package filter;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class ServletMaster extends ResourceConfig{
    public ServletMaster() {
        packages("controller;filter.security");
        register(RolesAllowedDynamicFeature.class);
       
       // TODO Auto-generated constructor stub
   }
}
