package StepProject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class Messeges extends HttpServlet {
    private final TemplateEngine engine;

    public Messeges(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        HashMap<String, Object> mes = new HashMap<>();
        mes.put("messege", DAO.getUser(id).getMessages());
        engine.render2("messeges.ftl", mes, resp);
    }
}
