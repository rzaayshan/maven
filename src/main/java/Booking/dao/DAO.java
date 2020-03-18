package Booking.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * this DAO doesn't cover any connection problems
 */
public interface DAO<A> {
  Optional<A> get(Long id);
  Collection<A> getAll();
  Collection<A> getAllBy(Predicate<A> p);
  void create(A data);
  void delete(Long id);
  public void deleteBy(Predicate<A> p);
}
