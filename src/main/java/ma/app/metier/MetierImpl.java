package ma.app.metier;

import ma.app.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("metier")
@Service("metier")
public class MetierImpl implements IMetier{

    private IDao dao;

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl(@Qualifier("dao2") IDao dao) {
        this.dao = dao;
    }
    @Override
    public double calcule() {
        double t = dao.getData();
        return t*7;
    }


}
