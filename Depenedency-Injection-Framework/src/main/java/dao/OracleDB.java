package dao;


import org.annotations.Component;

@Component
public class OracleDB implements Database {

    public OracleDB() {
    }

    public String getUserData(String username) {
        System.out.println("getting your info from oracle database");
        System.out.println("wait...");
        System.out.println("success");
        System.out.println("Username is : "+username);
        return username;
    }
}
