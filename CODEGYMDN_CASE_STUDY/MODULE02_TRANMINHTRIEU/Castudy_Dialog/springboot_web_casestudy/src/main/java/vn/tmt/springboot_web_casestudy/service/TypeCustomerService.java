package vn.tmt.springboot_web_casestudy.service;

import vn.tmt.springboot_web_casestudy.entity.FuramaTypeCustomer;

public interface TypeCustomerService {
    Iterable<FuramaTypeCustomer> findAll();
}
