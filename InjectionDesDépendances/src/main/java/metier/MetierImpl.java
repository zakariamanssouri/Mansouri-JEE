package metier;
import dao.IDAO;

public class MetierImpl implements IMetier {
    private IDAO dao;

    public double calcul() {
        double res = dao.getdata();
        return Math.random() * 100 + 3 * res;
    }

    public void setDao(IDAO dao) {
        this.dao = dao;
    }
}

