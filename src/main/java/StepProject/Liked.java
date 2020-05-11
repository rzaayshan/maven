package StepProject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Liked extends HttpServlet {
    private final TemplateEngine engine;

    public Liked(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> liked = new LinkedList<>();
        for(User u: DAO.getUsers()){
            if(u.getIsLiked().equals("Yes"))
                liked.add(u);
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("users",liked);
        engine.render2("liked.ftl", data, resp);
    }
}
