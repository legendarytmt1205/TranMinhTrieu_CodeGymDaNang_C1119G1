package vn.tmt.springboot_web_casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tmt.springboot_web_casestudy.entity.Customer;
import vn.tmt.springboot_web_casestudy.repository.CustomerRepository;
import vn.tmt.springboot_web_casestudy.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getCustomerById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByFullNameContaining(String s, Pageable pageable) {
        return customerRepository.findAllByFullNameContaining(s,pageable);
    }

    @Override
    public List<Customer> getALlCustomerFromContractExist() {
        return customerRepository.getALlCustomerFromContractExist();
    }
}
