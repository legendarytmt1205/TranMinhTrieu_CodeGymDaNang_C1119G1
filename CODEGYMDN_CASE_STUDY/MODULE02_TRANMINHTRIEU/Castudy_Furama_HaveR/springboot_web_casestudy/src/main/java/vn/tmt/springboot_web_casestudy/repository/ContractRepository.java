package vn.tmt.springboot_web_casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import vn.tmt.springboot_web_casestudy.entity.Contract;

public interface ContractRepository extends CrudRepository<Contract,Long> {

}
