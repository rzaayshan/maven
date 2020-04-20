package web;

import java.util.HashMap;

public class DB {
    private static final HashMap<String, String> users = new HashMap<>();

    public static void addUser(String key, String val){
        users.put(key,val);
    }

    public static boolean isUser(String user, String pass){
        return hasUsername(user) && users.get(user).equals(pass);
    }

    public static boolean hasUsername(String user){
        return users.containsKey(user);
    }
}
