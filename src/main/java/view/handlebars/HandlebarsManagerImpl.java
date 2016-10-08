package view.handlebars;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.FileTemplateLoader;
import com.github.jknack.handlebars.io.ServletContextTemplateLoader;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration.Strategy;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
import other.DefaultProperties;

@Service("handlebarsManager")
public final class HandlebarsManagerImpl  extends Handlebars implements HandlebarsManager{
    @Autowired
    ServletContext context;
    private static Logger logger         = Logger.getLogger( HandlebarsManagerImpl.class );

    private Cache preloadedTemplates;
  
 
  public Template getTemplate(String template) throws IOException
  {
      if(template!=null&&!"".equals( template )){
          if(preloadedTemplates.isKeyInCache( template )&&!DefaultProperties.getOption( "developerMode" ).equals( "true" ))
          {
              
              
              return (Template)preloadedTemplates.get( template ).getObjectValue();
          }else
          {  
          try {
              Template tmp=this.compile( template );
             if(!DefaultProperties.getOption( "developerMode" ).equals( "true" ))
              preloadedTemplates.put( new Element( template, tmp ) );
              return tmp;
         
          } catch ( IOException e ) {
              // TODO Auto-generated catch block
            throw new IOException("can't compile template :"+template,e );
            
          }
          }
      }
      return null;
  }
  

  

@PostConstruct
public void init() {
    CacheManager   sessionCache    =CacheManager.create();
    this.preloadedTemplates = new Cache(
            new CacheConfiguration( "templates",500 )
                            .memoryStoreEvictionPolicy( MemoryStoreEvictionPolicy.LFU )
                            .eternal( false )
                            .timeToLiveSeconds( 1200 ) 
                            .timeToIdleSeconds( 600)
                            .diskExpiryThreadIntervalSeconds( 0 )
                            .persistence( new PersistenceConfiguration().strategy( Strategy.LOCALTEMPSWAP ) ) );
    sessionCache.addCache( this.preloadedTemplates );
    
    ClassPathTemplateLoader  loader = new ClassPathTemplateLoader();
    loader.setPrefix("/");
    loader.setSuffix(".html");
    
    
    ServletContextTemplateLoader loaderServlet = new ServletContextTemplateLoader(context, "/",
      ".html");
    FileTemplateLoader  loaderFile = new FileTemplateLoader(DefaultProperties.getOption(  "templatePath" ),
            ".html");
    this.with( loader,loaderFile,loaderServlet );
}




@Override
public void addServletContext( ServletContext servletContext ) {
    // TODO Auto-generated method stub
    ServletContextTemplateLoader loader = new ServletContextTemplateLoader(servletContext, "/",
            ".html");
    this.with( loader );
    
}

}
