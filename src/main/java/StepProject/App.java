package StepProject;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        DAO.setUsers(Arrays.asList(
                new User("Aybeniz","https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fforbestechcouncil%2Ffiles%2F2019%2F01%2Fcanva-photo-editor-8-7.jpg"),
                new User("Ayshan","https://miro.medium.com/max/3200/0*QUqE4WGF8_cC9bIl.jpg"),
                new User("Jala", "https://i1.wp.com/geoawesomeness.com/wp-content/uploads/2017/09/Coding-Geospatial.jpg?fit=1152%2C768&ssl=1"),
                new User("Gulshan","https://marketingweek.imgix.net/content/uploads/2017/05/12103909/Coding-body-image-.jpg?auto=compress,format&q=60&w=750&h=460")));

        for(int i = 0; i< DAO.getUsers().size(); i++){
            DAO.getUser(i).setMessages(i+" "+i+" "+i);
            DAO.getUser(i).setId(i);
        }


        Server server = new Server(8085);

        ServletContextHandler handler = new ServletContextHandler();

        TemplateEngine engine = TemplateEngine.folder("content");

        handler.addServlet(new ServletHolder(new StartServlet(engine)),"/start");
        handler.addServlet(new ServletHolder(new UsersServlet(engine)),"/users");
        handler.addServlet(new ServletHolder(new ChoiceServlet()),"/choice");
        handler.addServlet(new ServletHolder(new Liked(engine)),"/liked");
        handler.addServlet(new ServletHolder(new Messeges(engine)),"/messeges/*");


        server.setHandler(handler);

        server.start();
        server.join();


    }
}
