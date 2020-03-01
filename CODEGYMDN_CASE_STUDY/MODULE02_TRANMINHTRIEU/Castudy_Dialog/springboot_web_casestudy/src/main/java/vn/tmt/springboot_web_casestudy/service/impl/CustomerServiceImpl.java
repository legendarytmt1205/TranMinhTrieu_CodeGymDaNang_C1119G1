package vn.tmt.springboot_web_casestudy.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.tmt.springboot_web_casestudy.entity.FuramaCustomer;
import vn.tmt.springboot_web_casestudy.repository.CustomerRepository;
import vn.tmt.springboot_web_casestudy.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<FuramaCustomer> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public FuramaCustomer getCustomerById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(FuramaCustomer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomer(Long id, FuramaCustomer customer) {

    }

    @Override
    public Page<FuramaCustomer> findAllByNameContaining(String name, Pageable pageable) {
        return customerRepository.findAllByFullNameContaining(name,pageable);
    }
}
