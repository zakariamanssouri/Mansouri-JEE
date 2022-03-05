package metier;
import dao.IDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {

    @Autowired
    private IDAO dao;

    public MetierImpl(IDAO dao) {
        this.dao = dao;

    }

    public double calcul() {
        double res = dao.getdata();
        return Math.random() * 100 + 3 * res;
    }

    public void setDao(IDAO dao) {
        this.dao = dao;
    }
}

