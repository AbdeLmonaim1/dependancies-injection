package ma.app.ext;

import ma.app.dao.IDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("dao2")
@Repository("dao2")
public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("WS --version--");
        int t = 49;
        return t;
    }
}
