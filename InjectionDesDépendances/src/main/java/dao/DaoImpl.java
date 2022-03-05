package dao;

import org.springframework.stereotype.Component;

@Component
public class DaoImpl implements IDAO{
    public double getdata() {
        System.out.println("version base de données");
        return Math.PI*100/Math.cos(10);
    }
}


