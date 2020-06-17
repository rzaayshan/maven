package StepProject;

import StepProject.Filters.CanLogin;
import StepProject.Filters.IsLogin;
import StepProject.Helpers.TemplateEngine;
import StepProject.Servlets.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.util.EnumSet;


public class Main {
    public static void main(String[] args) throws Exception {
        /*DbSetup.prepare(
                "jdbc:postgresql://localhost:5432/step",
                "postgres",
                "hidden"
        );*/

        Server server = new Server(8087);

        ServletContextHandler handler = new ServletContextHandler();

        TemplateEngine engine = TemplateEngine.folder("content");

        handler.addServlet(new ServletHolder(new Start(engine)),"/start");
        handler.addServlet(new ServletHolder(new Like(engine)),"/users");
        handler.addServlet(new ServletHolder(new Choice()),"/choice");
        handler.addServlet(new ServletHolder(new List(engine)),"/liked");
        handler.addServlet(new ServletHolder(new Login()),"/login");
        handler.addServlet(new ServletHolder(new Logout()),"/logout");
        handler.addServlet(new ServletHolder(new StaticServlet("css")), "/css/*");

        handler.addFilter(new FilterHolder(new CanLogin()),"/start", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(new FilterHolder(new IsLogin()),"/users", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(new FilterHolder(new IsLogin()),"/liked", EnumSet.of(DispatcherType.REQUEST));
        handler.addFilter(new FilterHolder(new IsLogin()),"/choice", EnumSet.of(DispatcherType.REQUEST));
        handler.addServlet(new ServletHolder(new Messages(engine)),"/message/*");


        server.setHandler(handler);

        server.start();
        server.join();


    }
}
