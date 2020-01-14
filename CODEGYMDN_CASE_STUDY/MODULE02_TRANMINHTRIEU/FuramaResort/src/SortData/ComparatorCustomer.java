package SortData;
import Models.persons.Customers;
import Models.persons.Employees;
import Models.services.Services;
import java.security.Provider;
import java.util.Comparator;

public class ComparatorCustomer implements Comparator<Customers> {
    @Override
    public int compare(Customers cur1, Customers cur2) {
        if (cur1.getName().compareTo(cur2.getName()) == 0) {
            return cur1.getYearBirthday() - cur2.getYearBirthday();
        }
        return cur1.getName().compareTo(cur2.getName());
    }
}

