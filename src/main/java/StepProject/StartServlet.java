package StepProject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class StartServlet extends HttpServlet {
    private final TemplateEngine engine;

    public StartServlet(TemplateEngine engine) {
        this.engine = engine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, String> user = new HashMap<>();
        user.put("name", DAO.getUser(0).getName());
        user.put("image", DAO.getUser(0).getImage());

        engine.render("user.ftl", user, resp);
    }
}
