package ma.app.metier;

import ma.app.dao.IDao;

public class MetierImpl implements IMetier{
    private IDao dao;
    @Override
    public double calcule() {
        double t = dao.getData();
        return t*7;
    }

}
