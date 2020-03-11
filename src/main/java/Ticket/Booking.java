package Ticket;

import java.util.List;

public class Booking {
    final int id;
    final String date;
    final String time;
    final int seets;
    List<Passenger> passengers;

    public Booking(int id, String date, String time,  int seets) {
        this.id = id;
        this.date = date;
        this.time = time;        
        this.seets = seets;
    }

}
