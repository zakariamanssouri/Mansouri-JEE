package metier;

import dao.Database;


public class UserImpl implements User {
    private long id;
    private String name = "zakaria";


    private Database database;

    public UserImpl() {
    }
    public void getCurrentUserData() {
        System.out.println("-------------------------------------------------");
        System.out.println(this.getClass().getName() + " constructor executed");
        database.getUserData("zakaria");
        System.out.println("-------------------------------------------------");
    }
}

