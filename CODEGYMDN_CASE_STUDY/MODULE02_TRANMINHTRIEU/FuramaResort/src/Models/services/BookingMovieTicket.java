package Models.services;
import Models.persons.Customers;
import java.util.LinkedList;
import java.util.Queue;

public class BookingMovieTicket {
    private static Queue<Customers> customers = new LinkedList<>();
    static {
        customers.add(new Customers("C-001", "Tran", null,null,null,null,null,null,null,null));
        customers.add(new Customers("C-002", "Minh", null,null,null,null,null,null,null,null));
        customers.add(new Customers("C-003", "Trieu", null,null,null,null,null,null,null,null));
        customers.add(new Customers("C-004", "Kha", null,null,null,null,null,null,null,null));
    }

    public Queue<Customers> getAllBookingCinema() {
        return customers;
    }
}
