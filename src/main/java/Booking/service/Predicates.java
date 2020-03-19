package Booking.service;

import Booking.entity.Booking;
import Booking.entity.Flight;
import Booking.entity.User;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class Predicates {

    public static Predicate<Flight> isBookable(String dest, LocalDateTime date_time, int num) {
        return flight ->
            flight.getSeats()>=num &&
                    flight.getCityTo().equals(dest) &&
                    //flight.date.isAfter(date) &&
                    flight.getDate_time().isAfter(date_time);
    }

    public static Predicate<Booking> isMyBooking(long user_id) {
        return b->b.getUser_id()==user_id;
    }

    public static Predicate<User> isUser(String user, String pass) {
        return u -> u.getUser_name().equals(user) && u.getPasswd().equals(pass);
    }



}
