package vn.tmt.springboot_web_casestudy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.tmt.springboot_web_casestudy.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFullNameContaining(String name, Pageable pageable);

//    @Query(("SELECT new com.roytuts.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
//            + "FROM Department d INNER JOIN d.employees e"))
//    List<Customer> getAllCustomerByContract();
}
