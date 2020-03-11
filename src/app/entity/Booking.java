package app.entity;

import java.util.List;
import java.util.Objects;

public class Booking {
  int id;
  int flight_id;
  List<Passenger> passengers;

  private static final long serialVersionUID = 1L;


  Booking(int id, int flight_id, List<Passenger> passengers){
    this.id=id;
    this.flight_id=flight_id;
    this.passengers=passengers;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Booking booking = (Booking) o;
    return id == booking.id &&
            flight_id == booking.flight_id &&
            Objects.equals(passengers, booking.passengers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, flight_id, passengers);
  }

  @Override
  public String toString() {
    return "Booking{" +
            "id=" + id +
            ", flight_id=" + flight_id +
            ", passengers=" + passengers +
            '}';
  }

}
