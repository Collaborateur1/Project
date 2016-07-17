package filter;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.container.filter.RolesAllowedResourceFilterFactory;
import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.spi.container.ResourceFilter;

import filter.security.SecurityContextFilter;

@Component // let spring manage the lifecycle
@Provider
public class ResourceFilterFactory extends RolesAllowedResourceFilterFactory {
 //tu peux ajouter les filtres de maniere générique ici 
    
    @Autowired
    private SecurityContextFilter securityContextFilter;
 
    // Similar to SecurityContextFilter to check incoming requests for API Version information and
    // act accordingly
   /* @Autowired
    private VersionFilter versionFilter;
 
    // Similar to SecurityContextFilter to audit incoming requests
    @Autowired
    private AuditingFilter auditingFilter;
 */
    @Override
    public List<ResourceFilter> create(AbstractMethod am) {
        // get filters from RolesAllowedResourceFilterFactory Factory!
        List<ResourceFilter> rolesFilters = super.create(am);
        if (null == rolesFilters) {
            rolesFilters = new ArrayList<ResourceFilter>();
        }
 
        // Convert into mutable List, so as to add more filters that we need
        // (RolesAllowedResourceFilterFactory generates immutable list of filters)
        List<ResourceFilter> filters = new ArrayList<ResourceFilter>(rolesFilters);
 
        // Load SecurityContext first (this will load security context onto request)
        filters.add(0, securityContextFilter);
 
      /*  // Version Control?
        filters.add(versionFilter);
 
        // If this abstract method is annotated with @Audit, we will apply AuditFilter to audit
        // this request.
        if (am.isAnnotationPresent(Audit.class)) {
            filters.add(auditingFilter);
        }
 */
        return filters;
    }
}
