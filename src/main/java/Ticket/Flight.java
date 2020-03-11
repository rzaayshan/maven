package Ticket;

public class Flight {
    Booking booking;
    final String sourcePoint;
    final String destPoint;
    final int FlightNo;
    int seets;

    public Flight(int FlightNo, String sourcePoint, String destPoint,Booking booking) {
        this.sourcePoint = sourcePoint;
        this.destPoint = destPoint;
        this.FlightNo = FlightNo;
        this.booking=booking;
    }


    public static Flight parse(String line) {
        String[] chunks = line.split(":");
        return new Flight(
                Integer.parseInt(chunks[0]),



                );
    }
    public String represent() {
        return String.format("%d:%s:%s:%s:%s:%d", booking.id, booking.date,
                booking.time, booking.sourcePoint, booking.destPoint, booking.seets);
    }


    @Override
    public String toString() {
        return String.format("Flight[id:%d, date:'%s', time:%s, source:%s, destination:%s, seets:%d]",
                booking.id, booking.date, booking.time, sourcePoint, destPoint, seets);
    }

}
