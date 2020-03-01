package vn.tmt.springboot_web_casestudy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import vn.tmt.springboot_web_casestudy.entity.TypeServices;

public interface TypeServiceRepository extends PagingAndSortingRepository<TypeServices,Long> {

}
