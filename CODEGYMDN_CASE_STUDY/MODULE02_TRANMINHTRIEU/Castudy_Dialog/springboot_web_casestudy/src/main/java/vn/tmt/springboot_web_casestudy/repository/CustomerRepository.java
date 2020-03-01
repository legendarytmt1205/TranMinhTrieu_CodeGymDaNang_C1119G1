package vn.tmt.springboot_web_casestudy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.tmt.springboot_web_casestudy.entity.FuramaCustomer;

public interface CustomerRepository extends JpaRepository<FuramaCustomer,Long> {
    Page<FuramaCustomer> findAll(Pageable pageable);
    Page<FuramaCustomer> findAllByFullNameContaining(String name, Pageable pageable);
}
