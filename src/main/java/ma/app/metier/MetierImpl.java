package ma.app.metier;

import ma.app.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{
    @Autowired
    private IDao dao;

    public void setDao(IDao dao) {
        this.dao = dao;
    }

//    public MetierImpl(IDao dao) {
//        this.dao = dao;
//    }
    @Override
    public double calcule() {
        double t = dao.getData();
        return t*7;
    }


}
