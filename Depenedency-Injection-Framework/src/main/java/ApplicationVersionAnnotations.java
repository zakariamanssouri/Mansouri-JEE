import metier.User;
import metier.UserImpl;
import org.annotations.AnnotationsInjector;

public class ApplicationVersionAnnotations {
    public static void main(String args[]) throws IllegalAccessException {
        AnnotationsInjector injector = new AnnotationsInjector(".");
        User user= (User) injector.getBean(UserImpl.class);
        user.getCurrentUserData();

        User user1 = (User) injector.getBean(User.class);
        user1.getCurrentUserData();

    }
}
