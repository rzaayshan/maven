package app.dao;

import app.entity.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOFlightBin implements DAO<Flight>{
    private File file;

    public DAOFlightBin(String filename) {
        this.file = new File(filename);
    }

    @Override
    public Collection<Flight> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            Object readed = ois.readObject();
            List<Flight> flights = (ArrayList<Flight>) readed;
            return flights;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<Flight> get(int id) {
        return getAll().stream().filter(s -> s.id == id).findFirst();
    }

    @Override
    public Collection<Flight> getAllBy(Predicate<Flight> p) {
        return getAll().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void create(Flight flight) {
        Collection<Flight> flights = getAll();
        flights.add(flight);
        write(flights);
    }

    @Override
    public void delete(int id) {
        Collection<Flight> flights = getAllBy(s -> s.id != id);
        write(flights);
    }

    private void write(Collection<Flight> flights) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(flights);
        } catch (IOException ex) {
            throw new RuntimeException("DAO:write:IOException", ex);
        }
    }
}
