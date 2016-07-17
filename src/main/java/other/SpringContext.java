package other;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service("springApplicationContext")
public class SpringContext implements ApplicationContextAware { 
   
    private static ApplicationContext context = null;

@Override
public void setApplicationContext( ApplicationContext arg0 ) throws BeansException {
    // TODO Auto-generated method stub
    context=arg0;
}


public static ApplicationContext getContext() {
    return context;
}
}