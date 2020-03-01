package vn.tmt.springboot_web_casestudy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.tmt.springboot_web_casestudy.entity.Accompanied;
import vn.tmt.springboot_web_casestudy.repository.AccompaniedRepository;
import vn.tmt.springboot_web_casestudy.service.AccompaniedService;

import java.util.List;

public class AccompaniedServiceImpl implements AccompaniedService {

    @Autowired
    AccompaniedRepository accompaniedRepository;

    @Override
    public Iterable<Accompanied> findAll() {
        return accompaniedRepository.findAll();
    }
}
