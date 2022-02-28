package ext;

import dao.IDAO;

public class DaoImplV2 implements IDAO{

    public double getdata() {

        System.out.println("versions capteurs");
        return Math.random() * 1000;
    }
}
