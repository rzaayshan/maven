package app;


import app.controller.Controller;
import app.dao.DAO;
import app.dao.DAOBooking;
import app.dao.DAOFlightBin;
import app.entity.Flight;
import app.io.ConsoleMain;
import app.service.Service;

public class MainApp {
  public static void main(String[] args) {

    ConsoleMain console = new ConsoleMain();
    DAOBooking daoBooking = new DAOBooking();
    DAOFlightBin flight = new DAOFlightBin("test4.bin");
    flight.create(new Flight(1,"12.12.2010", "12:10", "HHH", "JJJ", 100));
    flight.create(new Flight(2,"13.12.2010", "13:10", "SSS", "AAA", 200));
//    DAOBooking daoBooking = new DAOBooking();
//    DAOBooking daoBooking = new DAOBooking();
//    DAOBooking daoBooking = new DAOBooking();
    Service service = new Service(daoBooking,flight);
//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
//    Service service = new Service(daoBooking);
    Controller controller = new Controller(console, service);
//    Controller controller = new Controller(service);
//    Controller controller = new Controller(service);
//    Controller controller = new Controller(service);

   // String name = console.readLn();

    /*while (true) {
      String input = console.readLn();
      switch (input) {
        case "1": controller.show(); break;
        case "2": controller.search(); break;
        case "3": controller.book(); break;
        case "4": ; break;
        case "5": ; break;
        default:  break;
      }
    }*/


    System.out.println(controller.show());
    System.out.println(controller.search(Integer.parseInt(console.readLn())));
  }
}
