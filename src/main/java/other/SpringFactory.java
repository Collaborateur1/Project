package other;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import model.job.GenericJob;
import model.job.UserJob;
import model.provider.UsersProvider;
import view.handlebars.HandlebarsManager;

public class SpringFactory {
    
    public static Jaxb2Marshaller getJab2Marshaller() {
        return (Jaxb2Marshaller) SpringContext.getContext().getBean("marshaller");
    }
    public static UserJob getUserJob() {
        return (UserJob) SpringContext.getContext().getBean("userJob");
    }
    public static UsersProvider getUsersProvider() {
        return (UsersProvider) SpringContext.getContext().getBean("usersProvider");
    }
    
    public static GenericJob getGenericJob() {
        return (GenericJob) SpringContext.getContext().getBean("genericJob");
    }
    public static HandlebarsManager getHandlebarsManager() {
        return (HandlebarsManager) SpringContext.getContext().getBean("handlebarsManager");
    }
    
}
