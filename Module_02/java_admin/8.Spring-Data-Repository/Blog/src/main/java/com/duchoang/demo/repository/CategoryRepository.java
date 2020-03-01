package com.duchoang.demo.repository;
import com.duchoang.demo.model.Blog;
import com.duchoang.demo.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Iterable<Blog> findByName(String name);
}
