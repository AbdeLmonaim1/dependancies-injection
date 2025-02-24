package ma.app.pres;

import ma.app.dao.IDao;
import ma.app.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresWithSpringXML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
        IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("Result Using XML file = "+metier.calcule());
    }
}
