package vn.tmt.springboot_web_casestudy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.tmt.springboot_web_casestudy.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFullNameContaining(String name, Pageable pageable);
}
