package view.handlebars;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import view.handlebars.helper.GenericHelper;


public final class HandlebarsManager  extends Handlebars {
  
  
  
  
  private HandlebarsManager(TemplateLoader loader) {
      super(loader);
     
      this.registerHelpers(GenericHelper.INSTANCE);
   
  }
  
  public static Handlebars get() { TemplateLoader loader = new ClassPathTemplateLoader();
  loader.setPrefix("/");
  loader.setSuffix(".html");
  return new HandlebarsManager( loader); }
  
  public static Handlebars get(String templatDir, String templateExtention) { TemplateLoader loader = new ClassPathTemplateLoader();
  loader.setPrefix("/"+templatDir);
  loader.setSuffix("."+templateExtention);
  return new HandlebarsManager( loader);}
  

}
