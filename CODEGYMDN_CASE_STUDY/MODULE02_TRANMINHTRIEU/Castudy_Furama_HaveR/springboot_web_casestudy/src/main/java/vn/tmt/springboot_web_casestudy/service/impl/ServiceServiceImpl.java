package vn.tmt.springboot_web_casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.tmt.springboot_web_casestudy.entity.Services;
import vn.tmt.springboot_web_casestudy.repository.ServiceRepository;
import vn.tmt.springboot_web_casestudy.service.ServiceService;


@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<Services> getAllServices(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Services getServiceById(long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void saveService(Services service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteServiceById(long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Page<Services> findAllByNameContaining(String name, Pageable pageable) {
        return serviceRepository.findAllByServiceNameContaining(name,pageable);
    }
}
