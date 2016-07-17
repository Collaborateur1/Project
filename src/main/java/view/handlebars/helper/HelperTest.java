package view.handlebars.helper;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import com.github.jknack.handlebars.Options;
public class HelperTest {
    public static final String NAME = "test";
    public static final HelperTest INSTANCE = new HelperTest();
    
   
    public <T> CharSequence test( ConcurrentHashMap<String, T> context, Options options ) throws IOException {
        // TODO Auto-generated method stub
        return options.fn(context.get( "User" ));
    
    }
    
    public  CharSequence test2( String context, Options options ) throws IOException {
        // TODO Auto-generated method stub
        return options.fn("haha");
    
    }

}
