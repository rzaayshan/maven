package app.service;


import app.dao.DAOBooking;
import app.dao.DAOFlightBin;
import app.entity.Booking;
import app.entity.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class Service {
  DAOBooking daoBooking;
  public DAOFlightBin daoFlight;


  public Service(DAOBooking daoBooking, DAOFlightBin daoFlight) {

    this.daoBooking = daoBooking;
    this.daoFlight=daoFlight;
  }

  public List<String> getallFlights() {
    return  daoFlight.getAll().stream().map(s->s.represent()).collect(Collectors.toList());
  }

  public String getByid(int flightId) {
    return daoFlight.get(flightId).orElse("No flight found");
  }
}
