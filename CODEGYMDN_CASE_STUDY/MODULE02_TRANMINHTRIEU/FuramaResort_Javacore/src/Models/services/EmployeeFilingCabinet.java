package Models.services;

import Models.persons.Employees;

import java.util.Stack;

public class EmployeeFilingCabinet {
    private static Stack<Employees> employees;

    static {
        employees = new Stack<>();
        employees.push(new Employees("001", "tmt 1", "1", "6"));
        employees.push(new Employees("002", "tmt 2", "2", "7"));
        employees.push(new Employees("003", "tmt 3", "3", "8"));
        employees.push(new Employees("004", "tmt 4", "4", "8"));
        employees.push(new Employees("005", "tmt 5", "5", "10"));
    }

    public Employees findEmployeeById(String id) {
        Stack<Employees> employees1 = employees;
        while (true) {
            Employees employee = employees1.pop();
            if (employee == null) {
                break;
            }
            if (id.equals(employee.getId())) {
                return employee;
            }
        }
        return null;
    }
}
