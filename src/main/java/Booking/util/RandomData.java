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

  public static LocalTime genTime(){
    int ranHour = (int) (Math.random()*24);
    int ranMin = (int) (Math.random()*60);
    int ranSec = (int) (Math.random()*60);
    String s = String.format(String.format("%02d:%02d:%02d",ranHour,ranMin,ranSec));
    LocalTime time = LocalTime.parse(s);
    return time;
  }

  public static LocalDate genDate(){
    Random r = new Random();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    int ranDay = (int) (Math.random()*28 +1);
    int ranMonth = (int) (Math.random()*12 +1);
    int ranYear = (int) (Math.random()*(-1001) + 3000);

    String s = String.format("%04d-%02d-%02d",ranYear,ranMonth,ranDay);
    return LocalDate.parse(s,formatter);
  }

  public static String genCity(){
    String cities[] = {"Bakı", "Gəncə", "İstanbul", "Ankara", "Berlin", "Paris", "Roma"};
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
