package vn.tmt.springboot_web_casestudy.service;

import vn.tmt.springboot_web_casestudy.entity.TypeCustomer;

public interface TypeCustomerService {
    Iterable<TypeCustomer> findAll();
}
