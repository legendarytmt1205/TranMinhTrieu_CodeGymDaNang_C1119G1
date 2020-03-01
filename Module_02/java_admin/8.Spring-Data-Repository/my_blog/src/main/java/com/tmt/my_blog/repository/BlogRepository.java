package com.tmt.my_blog.repository;

import com.tmt.my_blog.model.Blog;
import com.tmt.my_blog.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Iterable<Blog> findByUser(User user);
}