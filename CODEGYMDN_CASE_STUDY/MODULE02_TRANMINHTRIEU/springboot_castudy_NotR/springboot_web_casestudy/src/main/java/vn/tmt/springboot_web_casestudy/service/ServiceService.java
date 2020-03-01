package vn.tmt.springboot_web_casestudy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.tmt.springboot_web_casestudy.entity.Services;

public interface ServiceService {
    Page<Services> getAllServices(Pageable pageable);
    Services getServiceById(long id);
    void saveService(Services service);
    void deleteServiceById(long id);
    Page<Services> findAllByNameContaining(String name, Pageable pageable);
}
