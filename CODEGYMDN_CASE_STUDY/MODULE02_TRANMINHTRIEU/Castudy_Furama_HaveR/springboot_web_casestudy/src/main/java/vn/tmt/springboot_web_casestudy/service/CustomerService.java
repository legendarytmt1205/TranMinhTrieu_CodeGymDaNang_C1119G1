package vn.tmt.springboot_web_casestudy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.tmt.springboot_web_casestudy.entity.Customer;

public interface CustomerService {
    Page<Customer> getAllCustomers(Pageable pageable);
    Customer getCustomerById(long id);
    void saveCustomer(Customer customer);
    void deleteCustomerById(long id);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
