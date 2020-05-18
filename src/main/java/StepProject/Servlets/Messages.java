package StepProject.Servlets;

import StepProject.DAO.DaoMessage;
import StepProject.Helpers.Message;
import StepProject.Helpers.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Messages extends HttpServlet {
    private final TemplateEngine engine;

    public Messages(TemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> data = new HashMap<>();
        String from = Arrays.stream(req.getCookies()).filter(c->c.getName().equals("uname"))
                .map(Cookie::getValue).findFirst().get();
        DaoMessage dao = new DaoMessage();
        String to = req.getParameter("to");
        System.out.println(to);
        List<Message> messages = dao.getMessages(from,to);
        data.put("messages", messages);

        engine.render2("message.ftl", data, resp);
    }


}
