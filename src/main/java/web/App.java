package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import web.servlets.Login;
import web.servlets.Registration;
import web.servlets.Wrong;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8093);
        ServletContextHandler handler = new ServletContextHandler();
        Login login = new Login();
        handler.addServlet(new ServletHolder(login),"/login");
        handler.addServlet(new ServletHolder(new Wrong()),"/wrong");
        handler.addServlet(new ServletHolder(new Registration()),"/registration");

        DB.addUser("ayshan","123");
        DB.addUser("gulshan","abc");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
