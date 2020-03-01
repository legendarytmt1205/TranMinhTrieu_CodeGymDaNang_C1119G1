package vn.tmt.springboot_web_casestudy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.tmt.springboot_web_casestudy.entity.Services;

public interface ServiceRepository extends JpaRepository<Services, Long> {
    Page<Services> findAll(Pageable pageable);
    Page<Services> findAllByServiceNameContaining(String name, Pageable pageable);
}
