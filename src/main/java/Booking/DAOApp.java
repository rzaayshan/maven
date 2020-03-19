package Booking;

import Booking.entity.Booking;
import Booking.entity.Flight;
import Booking.entity.Passenger;
import Booking.entity.User;

import java.time.LocalDateTime;
import java.util.Arrays;

public class DAOApp {

  public static void main(String[] args) {
    Database db = new Database();

    db.users.create(new User("alex", "123"));
    db.users.create(new User("ayshan", "234"));
    db.users.create(new User("sevil", "123"));
    db.flights.create(new Flight("Kyiv", "Baki", LocalDateTime.now(), 100));
    db.flights.create(new Flight("Paris", "Roma", LocalDateTime.now().plusHours(2), 100));
    db.bookings.create(new Booking(1, 1, Arrays.asList(new Passenger("A","B"), new Passenger("C", "D"))));
    db.users.getAll().forEach(u -> System.out.println(u.represent()));
  }

}
