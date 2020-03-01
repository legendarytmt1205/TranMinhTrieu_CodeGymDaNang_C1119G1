package com.tmt.my_blog.service;

import com.tmt.my_blog.model.Blog;
import com.tmt.my_blog.model.User;

public interface BlogService {
    Iterable<Blog> findAll();
    Iterable<Blog> findById(User user);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

}