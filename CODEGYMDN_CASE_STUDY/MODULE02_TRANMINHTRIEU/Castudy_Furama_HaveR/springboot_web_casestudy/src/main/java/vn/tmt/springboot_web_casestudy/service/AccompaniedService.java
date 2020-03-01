package vn.tmt.springboot_web_casestudy.service;

import vn.tmt.springboot_web_casestudy.entity.Accompanied;
import vn.tmt.springboot_web_casestudy.entity.Employee;

import java.util.List;

public interface AccompaniedService {
    Iterable<Accompanied> findAll();
}
