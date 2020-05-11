package StepProject;

import java.util.List;

public class DAO {
    static private List<User> users;


    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        DAO.users = users;
    }
    public static User getUser(int i){
        return users.get(i);
    }
}
