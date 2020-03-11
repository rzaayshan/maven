package Ticket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class DAOBookingFile {
    private File file;
    public DAOBookingFile(String filename) {
        this.file = new File(filename);
    }
    private Stream<Booking> bookings() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            return br.lines()
                    .map(Booking::parse);
        } catch (IOException e) {
            throw new RuntimeException("DAO:get:IOException", e);
        }
    }
    public void addPassenger(Passenger pass){

    }

}
