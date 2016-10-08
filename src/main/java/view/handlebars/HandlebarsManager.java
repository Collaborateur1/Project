package view.handlebars;

import java.io.IOException;

import javax.servlet.ServletContext;

import com.github.jknack.handlebars.Template;

public interface HandlebarsManager {
    public Template getTemplate(String template) throws IOException;
    public void addServletContext(ServletContext servletContext);
}
