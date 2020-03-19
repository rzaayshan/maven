package Booking.entity;

import Booking.dao.Identifiable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight implements Serializable, Identifiable {
  private final long id;
  private final String cityFrom;
  private final String cityTo;
  private final int seats;
  private final LocalDateTime date_time;

  static long counter = 0;

  private static final long serialVersionUID = 1L;

  public Flight(String cityFrom, String cityTo, LocalDateTime date_time , int seats) {
    this(++counter, cityFrom, cityTo, date_time, seats);
//    this.cityFrom = cityFrom;
//    this.cityTo = cityTo;
//    this.date = date;
//    this.seats = seats;
//    this.id = ++counter;
  }

  public Flight(long id, String cityFrom, String cityTo, LocalDateTime date_time, int seats) {
    this.cityFrom = cityFrom;
    this.cityTo = cityTo;
    this.seats = seats;
    this.id = id;
    this.date_time=date_time;
  }

  public static void setCounter(long counter) {
    Flight.counter = counter;
  }

  @Override
  public long getId() {
    return id;
  }

  public String getCityFrom() {
    return cityFrom;
  }

  public String getCityTo() {
    return cityTo;
  }

  public LocalDateTime getDate_time() {
    return date_time;
  }

  /*public LocalTime getTime() {
    return time;
  }*/

  public int getSeats() {
    return seats;
  }

  public String represent() {
    return String.format("%d %-20s - %-20s : %20s : %3d", id, cityFrom, cityTo, date_time.format(DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm")), seats);
  }
}
