package other;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;



public class DefaultProperties implements ServletContextListener {
   
    private static Logger logger = Logger.getLogger( DefaultProperties.class );
    private static final Properties prop = new Properties();
    private static final Properties mapp = new Properties();
    private static final Properties option = new Properties();
    private static final Properties cache = new Properties();
    
    private void loadProperties(){
        loadProperties("Config.properties",prop);
        loadProperties("Mapping.properties",mapp);
        loadProperties("options.properties",option);
        loadProperties("cache.properties",cache);
    
    }
    public static String getProperties(String name)
    {
        
        return prop.getProperty( name,"null" );
    }
    
    public static String geCacheProperties(String name)
    {
        
        return cache.getProperty( name );
    }
    
    public static String getMapping(String name)
    {
        
        return mapp.getProperty( name,DefaultProperties.getProperties("defaultpage"));
    }
    
    
    public static String getOption(String name)
    {
        
        return option.getProperty( name,"null");
    }
public void loadProperties(String filename, Properties prop)
{

    
    InputStream input = null;
   
    try {
    
        
        input = DefaultProperties.class.getClassLoader().getResourceAsStream(filename);

        

        //load a properties file from class path, inside static method
        prop.load(input);

 
        
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally{
        if(input!=null){
            try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
    
  
}
    
    @Override
    public void contextInitialized( ServletContextEvent sce ) {
        // TODO Auto-generated method stub
        loadProperties();
    }
    @Override
    public void contextDestroyed( ServletContextEvent sce ) {
        // TODO Auto-generated method stub
        
    }

}

