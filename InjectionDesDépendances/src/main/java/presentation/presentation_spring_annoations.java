package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class presentation_spring_annoations {
    public static void main(String args[])
    {
        ApplicationContext app = new AnnotationConfigApplicationContext("dao", "metier");
        IMetier metier = app.getBean(IMetier.class);
        System.out.println(metier.calcul());

    }
}
