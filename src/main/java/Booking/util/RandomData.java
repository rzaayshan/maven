package Booking.util;

import Booking.entity.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomData {

  private static int rnd(int max) {
    return (int) (Math.random() * max);
  }

  public static LocalDateTime genDate_time() {
    return LocalDateTime.of(2020 + rnd(2),
        rnd(12)+1,
        rnd(28)+1,
        6 + rnd(18),
        rnd(12)*5
        );
  }

  public static String genCity(){
    String cities[] = {"Baku", "Ganja", "Istanbul", "Ankara", "Berlin", "Paris", "Roma"};
    int num = (int) (Math.random()*7);
    return cities[num];
  }

  public static int genSeats(){
    return (int) (Math.random()*(-400)+700);
  }

  public static Flight genFlight(){
    return new Flight(genCity(),genCity(),genDate_time(),genSeats());
  }

}
