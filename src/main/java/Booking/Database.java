package Booking;

import Booking.dao.DAO;
import Booking.dao.DAOAbstractFileBin;
import Booking.entity.Booking;
import Booking.entity.Flight;
import Booking.entity.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static Booking.util.RandomData.genFlight;

public class Database {
  public final DAO<User> users;
  public final DAO<Flight> flights;
  public final DAO<Booking> bookings;

  public Database() {
    this.users = new DAOAbstractFileBin<User>("users.bin");;
    this.flights = new DAOAbstractFileBin<Flight>("flights.bin");
    this.bookings = new DAOAbstractFileBin<Booking>("bookings.bin");

    setMaxCounters();
    if (flights.getAll().isEmpty()) createInitialData();
  }

  private void createInitialData() {
    List<Flight> fligts = IntStream.range(0, 20).mapToObj((n) -> genFlight()).collect(Collectors.toList());
    fligts.forEach(f -> flights.create(f));
  }

  private void setMaxCounters() {
    long maxu = users.getAll().stream().mapToLong(User::getId).max().orElse(0);
    User.setCounter(maxu);
    long maxf = flights.getAll().stream().mapToLong(Flight::getId).max().orElse(0);
    Flight.setCounter(maxf);
    long maxb = bookings.getAll().stream().mapToLong(Booking::getId).max().orElse(0);
    Flight.setCounter(maxb);
  }
}
