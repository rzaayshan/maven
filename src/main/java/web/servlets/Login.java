package web.servlets;

import web.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = new BufferedReader(new FileReader(new File("src/main/java/web/pages/login.html")))
                .lines().collect(Collectors.joining("\n"));
        try(PrintWriter w = resp.getWriter()){
            w.write(page);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");

        if(DB.isUser(uname,pass)){
            String page = new BufferedReader(new FileReader(new File("src/main/java/web/pages/welcome.html")))
                    .lines().collect(Collectors.joining("\n"));
            try(PrintWriter w = resp.getWriter()){
                w.write(page);
            }
        }
        else{
            resp.sendRedirect("/wrong");
        }
    }
}
