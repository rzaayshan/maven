package Booking;

import Booking.controller.AppController;
import Booking.io.Console;
import Booking.io.UnixConsole;
import Booking.service.AppService;

import java.util.Scanner;

public class BookingApp {
  public static void main(String[] args) {
    Console console = new UnixConsole(new Scanner(System.in));
    Database db = new Database();
    AppService service = new AppService(db);
    AppController controller = new AppController((UnixConsole) console, service);
    long u = -1;
    boolean quit = false;
    while (!quit) {
      controller.showMenu(u);
      console.print("Enter your choice:");
      String line = console.readLn();
      if(u!=-1)
        switch (line) {
          case "1":u=controller.logout(); break;
          case "2": controller.showAllFlights(); break;
          case "3": controller.makeBooking(u); break;
          case "4": controller.myBookings(u); break;
          case "5": controller.cancelBooking(u); break;
          case "6": console.printLn("Bye!"); quit = true; break;
          default : console.print("Wrong input");
        }
      if(u==-1)
        switch (line) {
          case "1": u=controller.login(); break;
          case "2": controller.showAllFlights(); break;
          case "3": console.printLn("Bye!"); quit = true; break;
          default : console.print("Wrong input");
        }



    }
  }
}
