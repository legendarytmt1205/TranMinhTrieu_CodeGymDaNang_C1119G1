package com.tmt.validation_register.service.impl;

import com.tmt.validation_register.model.User;
import com.tmt.validation_register.repository.UserRepository;
import com.tmt.validation_register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User User) {
        userRepository.save(User);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}