package web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.stream.Collectors;

public class Wrong extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = new BufferedReader(new FileReader(new File("src/main/java/web/pages/wrong.html")))
                .lines().collect(Collectors.joining("\n"));
        try(PrintWriter w = resp.getWriter()){
            w.write(page);
        }
    }
}
