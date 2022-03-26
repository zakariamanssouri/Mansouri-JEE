import metier.User;
import org.xml.Injector;

public class ApplicationVersionXml {
    public static void main(String args[]) {
        Injector injector = new Injector("config.xml");
        User user = (User) injector.getBean("user");
        user.getCurrentUserData();

    }
}
