package lesson32.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String sx = req.getParameter("x");
    String sy = req.getParameter("y");
    String sop = req.getParameter("op");
    int x=Integer.parseInt(sx);
    int y=Integer.parseInt(sy);

    try (PrintWriter w = resp.getWriter()) {
      switch (sop){
        case "add":
          w.write(String.format("%s+%s=%d",sx,sy,x+y));
          break;
        case "sub":
          w.write(String.format("%s-%s=%d",sx,sy,x-y));
          break;
        case "mul":
          w.write(String.format("%s*%s=%d",sx,sy,x*y));
          break;
        case "div":
          w.write(String.format("%s-%s=%d",sx,sy,x/y));
          break;
      }

    }

  }
}
