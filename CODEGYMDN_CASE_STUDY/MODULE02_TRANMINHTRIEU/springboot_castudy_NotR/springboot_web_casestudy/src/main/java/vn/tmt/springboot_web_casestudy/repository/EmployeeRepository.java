package vn.tmt.springboot_web_casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import vn.tmt.springboot_web_casestudy.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
