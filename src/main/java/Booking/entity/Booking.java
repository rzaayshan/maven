package Booking.entity;

import Booking.dao.Identifiable;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Booking implements Identifiable, Serializable {
  private long id;
  private long user_id;
  private long flight_id;
  private List<Passenger> passengers;

  static long counter = 0;

  public static void setCounter(long counter) {
    Booking.counter = counter;
  }

  private static final long serialVersionUID = 1L;

  public Booking(long user_id, long flight_id, List<Passenger> passengers) {
    this(++counter, user_id, flight_id, passengers);
  }

  public Booking(long id, long user_id, long flight_id, List<Passenger> passengers) {
    this.id = id;
    this.user_id = user_id;
    this.flight_id = flight_id;
    this.passengers = passengers;
  }

  @Override
  public long getId() {
    return id;
  }

  public long getUser_id() {
    return user_id;
  }

  public long getFlight_id() {
    return flight_id;
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public String represent() {
    return String.format("Booking{id=%d, user_id=%d, flight _id=%d, passengers=%s}", id, user_id, flight_id,
            passengers.stream().map(p->String.format("%s %s",p.getFirstname(),p.getLastname())).collect(Collectors.toList()));
  }

}
