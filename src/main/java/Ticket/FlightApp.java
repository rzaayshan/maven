package Ticket;

import java.util.Scanner;



public class FlightApp {
    static void showbyId(DAOFlightFile f){
        System.out.println("Enter ID");
        String id = new Scanner(System.in).nextLine();
        System.out.println(f.get(Integer.parseInt(id)));
    }
    static void showbyDate(DAOFlightFile f){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter destination");
        String dest = scan.nextLine();
        System.out.println("Enter date");
        String date = scan.nextLine();
        System.out.println("Enter seets");
        int seets = Integer.parseInt(scan.nextLine());
        f.search(dest,date,seets);
    }
    public static void main(String[] args) {
        DAOFlightFile flight = new DAOFlightFile("schedule4.txt");
        flight.save(new Flight(1, "12.10.2020", "12-10", "Kiyev", "Baku",120));
        flight.save(new Flight(2,"21.12.2020", "13-10", "Kiyev", "Madrid", 200));
        flight.save(new Flight(3,"21.12.2020", "13-10", "Baku", "Istanbul", 200));
        flight.show("Kiyev");
        String s = null;
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Search by id(0), Search by 'destination, date, seets'(1), Exit(exit)");
            s=scan.nextLine();
            if(s.equals("exit"))
                break;
            switch(s){
                case "0":
                    showbyId(flight);
                    break;
                case "1":
                    showbyDate(flight);
                    break;
            }

        }


    }

}
