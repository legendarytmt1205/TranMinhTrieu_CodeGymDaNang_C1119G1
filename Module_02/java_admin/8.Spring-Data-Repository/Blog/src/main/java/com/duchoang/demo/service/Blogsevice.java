package com.duchoang.demo.service;

import com.duchoang.demo.model.Blog;
import com.duchoang.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface Blogsevice {
    Page<Blog> findAll(Pageable pageable);

//    Iterable<Blog> findById(Category category);

    Page<Blog> findAllByName(String name, Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Blog blog);
}
