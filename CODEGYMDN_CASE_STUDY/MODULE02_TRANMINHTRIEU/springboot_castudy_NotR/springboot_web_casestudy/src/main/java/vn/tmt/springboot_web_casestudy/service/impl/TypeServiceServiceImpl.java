package vn.tmt.springboot_web_casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.tmt.springboot_web_casestudy.entity.TypeServices;
import vn.tmt.springboot_web_casestudy.repository.TypeServiceRepository;
import vn.tmt.springboot_web_casestudy.service.TypeServiceService;

@Service
public class TypeServiceServiceImpl implements TypeServiceService {

    @Autowired
    TypeServiceRepository typeServiceRepository;

    @Override
    public Iterable<TypeServices> findAll() {
        return typeServiceRepository.findAll();
    }
}
