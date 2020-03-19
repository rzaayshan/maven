package Booking.controller;

import Booking.entity.Flight;
import Booking.entity.Passenger;
import Booking.io.Console;
import Booking.service.AppService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class AppController {
  private final Console console;
  private final AppService service;

  public AppController(Console console, AppService service) {
    this.console = console;
    this.service = service;
  }

  public void myBookings(Long user_id) {
    service.myBookings(user_id).stream().forEach(booking -> console.printLn(booking.represent()));
  }

  //menu 3
  public void makeBooking(Long user_id){
    console.printLn("Enter destination point:");
    String dest = console.readLn();
    console.printLn("Enter date:");
    LocalDateTime date = LocalDateTime.parse(console.readLn(), DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm"));
    console.printLn("Enter number of passengers:");
    int pass_num = Integer.parseInt(console.readLn());
    if(!searchFlights(dest,date,pass_num))
      return;
    Long flight_id = Long.parseLong(console.readLn());
    if(!wantBooking(flight_id))
      return;
    book(user_id, flight_id, pass_num);
  }

  public boolean searchFlights(String dest, LocalDateTime date, int num){
    List<Flight> flights = service.searchFlights(dest, date, num);
    if(flights.size()==0){
      console.printLn("No flight is found");
      return false;}
    else{
      flights.stream().map(Flight::represent).forEach(flight->console.printLn(flight));
      return true;}
  }

  public boolean wantBooking(Long num){
    return num==0 ? false : true;
  }

  public void book(Long user_id, Long flight_id, int pass_num) {
    List <Passenger> passengers = new LinkedList<>();
    for(int i=0;i<pass_num;i++){
      console.printLn("Name:");
      String name = console.readLn();
      console.printLn("Surname:");
      String surname = console.readLn();
      passengers.add(new Passenger(name, surname));
    }
    service.book(user_id, flight_id, passengers);
  }


  public void showAllFlights() {
    Collection<Flight> allFlights = service.getAllFlights();
    allFlights.forEach(f -> System.out.println(f.represent()));
  }

  public long login() {
    long flag=-1;
    String name;
    String pass;
    while(true){
      console.printLn("Username:");
      name=console.readLn();
      console.printLn("Password:");
      pass=console.readLn();
      flag=service.user(name,pass);
      if(flag!=-1)
        return flag;

      System.out.println("Login or password is wrong.");}

    }

  public int logout() {
    return -1;
  }

  public void cancelBooking(Long user_id){
    console.printLn("Enter ID of booking:");
    Long booking_id=Long.parseLong(console.readLn());
    if(service.cancelBooking(booking_id))
      console.printLn("Booking was deleted");
    else
      console.printLn("There isn't any booking");
  }

  public void showMenu(Long u){
    StringBuilder sb = new StringBuilder();
    if(u!=-1){
      sb.append("My profile\n")
              .append("1. Log out\n")
              .append("2. Show flights\n")
              .append("3. Book a flight\n")
              .append("4. My flights\n")
              .append("5. Cancel the booking\n")
              .append("6. Exit\n");
    }
    else{
      sb.append("1. Log in\n")
              .append("2. Show flights\n")
              .append("3. Exit\n");
    }
    console.printLn(sb.toString());
  }
}

