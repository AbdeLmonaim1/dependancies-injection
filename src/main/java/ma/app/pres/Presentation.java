package ma.app.pres;

import ma.app.dao.DaoImpl;
import ma.app.metier.MetierImpl;

public class Presentation {
    public static void main(String[] args) {
        MetierImpl metier = new MetierImpl();
        DaoImpl dao = new DaoImpl();
        metier.setDao(dao);
        System.out.println(metier.calcule());
    }
}
