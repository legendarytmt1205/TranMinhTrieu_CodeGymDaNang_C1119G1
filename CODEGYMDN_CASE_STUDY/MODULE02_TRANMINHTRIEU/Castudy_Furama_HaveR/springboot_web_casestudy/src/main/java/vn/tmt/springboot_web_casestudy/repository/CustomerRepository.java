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

    //@Query(value = "SELECT c FROM customers c order by c.full_name COLLATE utf8_unicode_ci LIMIT 10",nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFullNameContaining(String name, Pageable pageable);

    @Query(value = "select ct.contract_date_end, c.* from customers c \n" +
            "inner join contracts ct\n" +
            "on c.customer_id = ct.customer_id\n" +
            "where datediff(CURRENT_DATE(),ct.contract_date_end) <=0", nativeQuery = true)
    List<Customer> getALlCustomerFromContractExist();
}


