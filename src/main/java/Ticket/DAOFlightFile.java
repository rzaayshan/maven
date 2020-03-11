package Ticket;

import java.io.*;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DAOFlightFile implements DAO<Flight> {
    private File file;

    public DAOFlightFile(String filename) {
        this.file = new File(filename);
    }

    private Stream<Flight> flights() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            return br.lines()
                    .map(Flight::parse);
        } catch (IOException e) {
            throw new RuntimeException("DAO:get:IOException", e);
        }
    }

    @Override
    public Optional<Flight> get(int id) {
        return flights()
                .filter(s -> s.id == id)
                .findFirst();
    }

    @Override
    public Collection<Flight> getAll() {
        return flights()
                .collect(Collectors.toList());  }
    public void save(Flight data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            String student = data.represent();
            bw.write(student);
            bw.write("\n");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("DAO:save:IOException", e);
        }
    }
    public void delete(int id) {
        try {
            Collection<Flight> students =  getAll();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Flight std: students) {
                bw.write(std.represent());
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException("DAO:get:IOException", e);
        }

    }

    @Override
    public void search(String des, String date, int num) {
        flights().filter(s->(s.destPoint.equals(des) && s.date.equals(date) && s.seets>num))
                .forEach(System.out::println);
    }

    void show(String point){
        flights()
                .filter(s -> s.sourcePoint.equals(point))
                .forEach(s->System.out.println(s));
    }
    void getbyDate(String date){
        flights()
                .filter(s -> s.date.equals(date))
                .forEach(s->System.out.println(s));
    }




}
