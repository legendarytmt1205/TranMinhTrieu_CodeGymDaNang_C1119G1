package vn.tmt.springboot_web_casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tmt.springboot_web_casestudy.entity.Employee;
import vn.tmt.springboot_web_casestudy.repository.EmployeeRepository;
import vn.tmt.springboot_web_casestudy.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
