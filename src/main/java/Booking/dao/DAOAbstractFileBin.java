package Booking.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOAbstractFileBin<A extends Identifiable> implements DAO<A> {

  private final File file;

  public DAOAbstractFileBin(String filename) {
    this.file = new File(filename);
  }



  @Override
  public Collection<A> getAll() {
    try (ObjectInputStream ois =
             new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      Object readed = ois.readObject();
      @SuppressWarnings("unchecked")
      List<A> as = (ArrayList<A>) readed;
      return as;
    } catch (ClassNotFoundException ex) {
      throw new RuntimeException("Deserialization error. Didn't you forget to include 'serialVersionUID field' in your entity?", ex);
    } catch (FileNotFoundException ex) {
      return new ArrayList<>();
    } catch (IOException ex) {
      throw new RuntimeException("Something went wrong", ex);
    }
  }

  @Override
  public Collection<A> getAllBy(Predicate<A> p) {
    return
        getAll().stream().filter(p).collect(Collectors.toList());
//        getAll().stream().filter(p::test).collect(Collectors.toList());
//        getAll().stream().filter(a -> p.test(a)).collect(Collectors.toList());
  }

  @Override
  public Optional<A> get(Long id) {
    return getAll().stream().filter(new Predicate<A>() {
      @Override
      public boolean test(A a) {
        return a.getId() == id;
      }
    }).findFirst();
  }

  @Override
  public void create(A a) {
    Collection<A> as = getAll();
    as.add(a);
    write(as);
  }

  @Override
  public void delete(Long id) {
    Collection<A> as = getAllBy(s -> s.getId() != id);
    write(as);
  }

  @Override
  public void deleteBy(Predicate<A> p) {
    Collection<A> as = getAllBy(a -> !p.test(a));
    write(as);
  }

  private void write(Collection<A> as) {
    try (ObjectOutputStream oos =
             new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file))))
    {
      oos.writeObject(as);
    } catch (IOException ex) {
      throw new RuntimeException("DAO:write:IOException", ex);
    }
  }

}
