package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class presentation_spring_xml {
    public static void main(String args[])
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appconfig.xml");
        IMetier metier = (IMetier) applicationContext.getBean("metier");
        System.out.println(metier.calcul());

    }
}
