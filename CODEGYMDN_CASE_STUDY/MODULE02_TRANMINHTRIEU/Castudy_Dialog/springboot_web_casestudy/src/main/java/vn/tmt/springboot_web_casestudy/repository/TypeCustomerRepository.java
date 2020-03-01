package vn.tmt.springboot_web_casestudy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.tmt.springboot_web_casestudy.entity.FuramaTypeCustomer;

public interface TypeCustomerRepository extends PagingAndSortingRepository<FuramaTypeCustomer,Long> {

}
