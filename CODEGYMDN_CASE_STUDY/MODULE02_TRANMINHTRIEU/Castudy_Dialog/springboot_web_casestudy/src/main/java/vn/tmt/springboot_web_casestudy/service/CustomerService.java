package vn.tmt.springboot_web_casestudy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.tmt.springboot_web_casestudy.entity.FuramaCustomer;

public interface CustomerService {
    Page<FuramaCustomer> getAllCustomers(Pageable pageable);
    FuramaCustomer getCustomerById(long id);
    void saveCustomer(FuramaCustomer customer);
    void deleteCustomerById(long id);
    void updateCustomer(Long id, FuramaCustomer customer);
    Page<FuramaCustomer> findAllByNameContaining(String name, Pageable pageable);
}
