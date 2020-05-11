package StepProject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChoiceServlet extends HttpServlet {
    static int i=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO.getUsers().get(i).setIsLiked(req.getParameter("choice"));
        req.setAttribute("i",++i);
        RequestDispatcher r = req.getRequestDispatcher("/users");
        r.forward(req,resp);
    }



}
