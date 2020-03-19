package Booking.service;


import Booking.Database;
import Booking.entity.Booking;
import Booking.entity.Flight;
import Booking.entity.Passenger;
import Booking.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class AppService {
  private final Database db;

  public AppService(Database db) {
    this.db = db;
  }

  public Optional<Flight> getFlightById(Long flightId) { return db.flights.get(flightId);
  }


  public List<Flight> searchFlights(String dest, LocalDateTime date_time, int num){
    return new ArrayList<>(db.flights.getAllBy(Predicates.isBookable(dest, date_time , num)));
  }
  public void book(Long user_id, Long flightId, List<Passenger> passengers){
    db.flights.get(flightId).stream().map(flight -> flight.getSeats()-passengers.size());
    db.bookings.create(new Booking(user_id,flightId,passengers));
  }


  public boolean cancelBooking(Long id){
    Optional<Booking> booking = db.bookings.get(id);
    if(booking.isEmpty())
      return false;

    Booking booking1 = db.bookings.get(id).get();
    db.flights.get(booking1.getFlight_id()).map(f->f.getSeats()+booking1.getPassengers().size());
    db.bookings.delete(id);
    return true;
  }


  public List<Booking> myBookings(long user_id) {
    return new ArrayList<>(db.bookings.getAllBy(Predicates.isMyBooking(user_id)));
  }


  public long user(String name, String pass) {
    List <User> l = new ArrayList<>(db.users.getAllBy(Predicates.isUser(name, pass)));
    return l.get(0).getId();
    //return l.size() != 0;
  }

  public Collection<Flight> getAllFlights() {
    return db.flights.getAllBy(f -> LocalDateTime.now().plusHours(24).isAfter(f.getDate_time())
                     && LocalDateTime.now().isBefore(f.getDate_time()));



  }


}




