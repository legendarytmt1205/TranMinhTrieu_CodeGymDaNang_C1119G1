package com.codegym.jpa.demojpa.service;

import com.codegym.jpa.demojpa.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> getAllCustomers(Pageable pageable);
    Customer getCustomerById(long id);
    void saveCustomer(Customer customer);
    void deleteCustomerById(long id);
    void updateCustomer(int id, Customer customer);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
