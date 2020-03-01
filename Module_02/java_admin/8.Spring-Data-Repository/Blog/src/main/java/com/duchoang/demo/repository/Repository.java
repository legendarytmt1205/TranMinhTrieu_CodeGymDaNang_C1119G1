package com.duchoang.demo.repository;

import com.duchoang.demo.model.Blog;
import com.duchoang.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends PagingAndSortingRepository<Blog,Long> {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByName(String name, Pageable pageable);
//    Iterable<Blog> findByCatagory(Category category);

//    long count(String tacgia);
}
