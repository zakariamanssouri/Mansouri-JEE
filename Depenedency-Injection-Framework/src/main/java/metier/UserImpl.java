package metier;


import dao.Database;


public class UserImpl implements User {
    private long id;
    private String name = "zakaria";


    private Database Database;

    public UserImpl() {
    }
    public void getCurrentUserData() {
        System.out.println("-------------------------------------------------");
        System.out.println(this.getClass().getName() + " constructor executed");
        Database.getUserData("zakaria");
        System.out.println("-------------------------------------------------");
    }

    public void setDatabase(Database Database) {
        this.Database = Database;
    }
}

