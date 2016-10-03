package filter.security;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
@Provider
@PreMatching
public class SecureResponseFilter implements ContainerResponseFilter {
    private static Logger   logger       = Logger.getLogger( SecureResponseFilter.class );
    @Override
    public void filter( ContainerRequestContext requestContext, ContainerResponseContext responseContext )
            throws IOException {
        // TODO Auto-generated method stub
        logger.info( "Filtering REST Response" );
        
        responseContext.getHeaders().add( "Access-Control-Allow-Origin", "*" );    // You may further limit certain client IPs with Access-Control-Allow-Origin instead of '*'
        responseContext.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
        responseContext.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        responseContext.getHeaders().add( "Access-Control-Allow-Headers", HttpHeaderNames.SERVICE_KEY + ", " + HttpHeaderNames.AUTH_TOKEN );
    }

}
