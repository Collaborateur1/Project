package view.handlebars.helper;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import com.github.jknack.handlebars.Options;

public class GenericHelper {
    public static final String NAME = "genericHelper";
    public static final GenericHelper INSTANCE = new GenericHelper();
    
    public <T> CharSequence context( ConcurrentHashMap<String, T> context, Options options ) throws IOException {
        // TODO Auto-generated method stub
        String str = options.param(0);
        if(str==null||"".equals( str ))
            throw new IllegalArgumentException(
                    "Error expecting at last on option for Context Helper");
        //apply a context for the template
        return options.fn(context.get( str ));
    
    }
    
}
