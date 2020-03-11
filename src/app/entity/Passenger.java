package app.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Passenger implements Serializable {
    int id;
    String name;
    String surname;
    List<Integer> bookingID;

    private static final long serialVersionUID = 1L;

    Passenger(int id, String name, String surname, int bookingID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.bookingID = new LinkedList<>();
        this.bookingID.add(bookingID);
        //bookings = new HashMap<>();
    }
    public void addBook(int bookingID){
        this.bookingID.add(bookingID);
    }

    public static Passenger parse(String line) {
        String[] chunks = line.split(":");
        return new Passenger(
                Integer.parseInt(chunks[0]),
                chunks[1],
                chunks[2],
                Integer.parseInt(chunks[3])
        );
    }

    public String represent() {

        return String.format("%d:%s:%s:%d", id, name, surname, bookingID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id &&
                Objects.equals(name, passenger.name) &&
                Objects.equals(surname, passenger.surname) &&
                Objects.equals(bookingID, passenger.bookingID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, bookingID);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bookingID=" + bookingID +
                '}';
    }
}


