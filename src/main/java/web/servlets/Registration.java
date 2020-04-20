package web.servlets;

import web.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class Registration extends HttpServlet {
    private String page(String path) throws FileNotFoundException {
        return new BufferedReader(new FileReader(new File(path)))
                .lines().collect(Collectors.joining("\n"));
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter w = resp.getWriter()){
            w.write(page("src/main/java/web/pages/registration.html"));
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");
        String pass2 = req.getParameter("pass2");
        if(DB.hasUsername(uname))
            try(PrintWriter w = resp.getWriter()){
                w.write(page("src/main/java/web/pages/registration2.html"));
            }
        else if(!pass2.equals(pass)){
            try(PrintWriter w = resp.getWriter()){
                w.write(page("src/main/java/web/pages/registration4.html"));
            }
        }
        else{
            DB.addUser(uname,pass);
            try(PrintWriter w = resp.getWriter()){
                w.write(page("src/main/java/web/pages/registration3.html"));
            }
        }

}
}
