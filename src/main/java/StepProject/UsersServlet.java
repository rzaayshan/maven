package StepProject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class UsersServlet extends HttpServlet {
    private final TemplateEngine engine;

    public UsersServlet(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = DAO.getUsers();
        HashMap<String, String> user = new HashMap<>();
        int i = (int)req.getAttribute("i");
        if(i>=users.size()){
            i=0;
            ChoiceServlet.i=0;
            resp.sendRedirect("/liked");
        }
        user.put("name",users.get(i).getName());
        user.put("image",users.get(i).getImage());

        engine.render("user.ftl", user, resp);


    }



}
