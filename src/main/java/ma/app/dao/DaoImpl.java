package ma.app.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("dao")
@Repository("dao")
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        double t=24;
        return t;
    }
}
