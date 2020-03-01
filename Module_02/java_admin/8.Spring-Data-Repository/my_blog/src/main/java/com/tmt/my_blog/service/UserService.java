package com.tmt.my_blog.service;

import com.tmt.my_blog.model.User;

public interface UserService {

    Iterable<User> findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);
}
