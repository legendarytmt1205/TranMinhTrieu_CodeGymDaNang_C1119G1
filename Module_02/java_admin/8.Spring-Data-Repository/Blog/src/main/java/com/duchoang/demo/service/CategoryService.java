package com.duchoang.demo.service;

import com.duchoang.demo.model.Blog;
import com.duchoang.demo.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    Iterable<Blog> findByName(String name);

    Category findById(Long id);

    void save(Category category);

    void remove(Category category);
}
