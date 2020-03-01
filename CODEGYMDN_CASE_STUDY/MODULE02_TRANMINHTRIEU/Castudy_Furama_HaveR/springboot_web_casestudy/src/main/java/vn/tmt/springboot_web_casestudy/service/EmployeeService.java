package vn.tmt.springboot_web_casestudy.service;

import vn.tmt.springboot_web_casestudy.entity.Employee;
import vn.tmt.springboot_web_casestudy.entity.TypeCustomer;

public interface EmployeeService {
    Iterable<Employee> findAll();
}
