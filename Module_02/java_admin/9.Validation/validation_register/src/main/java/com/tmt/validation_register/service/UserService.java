package com.tmt.validation_register.service;
import com.tmt.validation_register.model.User;

public interface UserService {
    Iterable<User> findAll();

    User findById(Long id);

    void save(User User);

    void remove(Long id);
}
