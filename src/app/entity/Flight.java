package app.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Flight implements Serializable {
  public int id;
  public String date;
  public String time;
  public String to;
  public String from;
  public int seats;
  private static final long serialVersionUID = 1L;

  public Flight(int id, String date, String time, String to, String from, int seats){
    this.id=id;
    this.date=date;
    this.time=time;
    this.to=to;
    this.from=from;
    this.seats = seats;

  }
  public String represent() {
    return String.format("%d,%s, %s, %s, %s, %s",
            id, date, time, to, from, seats);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Flight flight = (Flight) o;
    return id == flight.id &&
            Objects.equals(date, flight.date) &&
            Objects.equals(time, flight.time) &&
            Objects.equals(to, flight.to) &&
            Objects.equals(from, flight.from);}


  @Override
  public int hashCode() {
    int result = Objects.hash(id, date, time, to, from);
    result = 31 * result + seats;
    return result;
  }

  @Override
  public String toString() {
    return "Flight{" +
            "id=" + id +
            ", date='" + date + '\'' +
            ", time='" + time + '\'' +
            ", to='" + to + '\'' +
            ", from='" + from + '\'' +
            ", seats=" + seats +
            '}';
  }
}
