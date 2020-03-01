package vn.tmt.springboot_web_casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tmt.springboot_web_casestudy.entity.TypeRent;
import vn.tmt.springboot_web_casestudy.repository.TypeRentRepository;
import vn.tmt.springboot_web_casestudy.service.TypeRentService;

@Service
public class TypeRentServiceImpl implements TypeRentService {

    @Autowired
    TypeRentRepository typeRentRepository;

    @Override
    public Iterable<TypeRent> findAll() {
        return typeRentRepository.findAll();
    }
}
