package vn.tmt.springboot_web_casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tmt.springboot_web_casestudy.entity.FuramaTypeCustomer;
import vn.tmt.springboot_web_casestudy.repository.TypeCustomerRepository;
import vn.tmt.springboot_web_casestudy.service.TypeCustomerService;

@Service
public class TypeCustomerServiceImpl implements TypeCustomerService {

    @Autowired
    private TypeCustomerRepository typeCustomerRepository;

    @Override
    public Iterable<FuramaTypeCustomer> findAll() {
        return typeCustomerRepository.findAll();
    }
}
