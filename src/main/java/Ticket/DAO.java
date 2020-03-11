package Ticket;



import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

    public interface DAO<A> {
        Collection<A> getAll();
        Optional<A> get(int id) throws IOException;
        void save(A data);
        void delete(int id);
        void search(String des, String date, int num);

    }


