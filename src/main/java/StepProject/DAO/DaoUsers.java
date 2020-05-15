package StepProject.DAO;

import StepProject.Helpers.Profile;
import StepProject.Helpers.User;

import java.sql.*;
import java.util.LinkedList;

public class DaoUsers {
    private static final String URL = "jdbc:postgresql://localhost:5432/step";
    private static final String UNAME = "postgres";
    private static final String PWD = "hidden";

    private Connection conn;

    public void connect() {
        try {
            this.conn = DriverManager.getConnection(URL, UNAME, PWD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkUser(String uname, String pass) {
        try {
            String query = "SELECT * FROM users WHERE (uname=? AND pass=?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, uname);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            rs.next();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void addUser(User user) {
        try {
            String query = "INSERT INTO users VALUES (?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, user.getId());
            st.setString(2, user.getName());
            st.setString(3, user.getPass());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteUser(int id) {
        try {
            String query = "DELETE FROM users WHERE id=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    LinkedList<Profile> getProfiles() {
        try {
            LinkedList<Profile> users = new LinkedList<>();
            String query = "SELECT * FROM users";
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String uname = rs.getString("uname");
                String image = rs.getString("image");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                users.add(new Profile(uname, image, name, surname));
            }
            return users;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
