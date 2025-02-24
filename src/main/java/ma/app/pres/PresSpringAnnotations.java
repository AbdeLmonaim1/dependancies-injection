package ma.app.pres;

import ma.app.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("ma.app.metier", "ma.app.ext", "ma.app.dao");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("Result Using Spring Annotations = "+metier.calcule());
    }
}
