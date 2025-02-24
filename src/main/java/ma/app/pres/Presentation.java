package ma.app.pres;


import ma.app.dao.IDao;
import ma.app.metier.IMetier;

import java.io.File;
import java.util.Scanner;


public class Presentation {
    public static void main(String[] args) {
//        dependency injection by static instantiation
//        DaoImpl dao = new DaoImpl();
//        MetierImpl metier = new MetierImpl(dao);
//        System.out.println("Result with static instantiation = "+metier.calcule());
        //dependency injection by dynamic instantiation
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.nextLine();
            Class daoClass = Class.forName(daoClassName);
            IDao daoImpl = (IDao) daoClass.getConstructor().newInstance();
            String metierClassName = scanner.nextLine();
            Class metierClass = Class.forName(metierClassName);
            IMetier metierImpl = (IMetier) metierClass.getConstructor().newInstance(daoImpl);
            System.out.println("Result with dynamic instantiation = "+metierImpl.calcule());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
