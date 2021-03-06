package vn.tmt.springboot_web_casestudy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.tmt.springboot_web_casestudy.entity.Customer;

import java.util.List;

public interface CustomerService {
    Page<Customer> getAllCustomers(Pageable pageable);
    Customer getCustomerById(long id);
    void saveCustomer(Customer customer);
    void deleteCustomerById(long id);
//    Page<Customer> findByFullNameOrAddress(String address,String name, Pageable pageable);
    List<Customer> getALlCustomerFromContractExist();

    Page<Customer> findAllByFullNameContaining(String s, Pageable pageable);
}
