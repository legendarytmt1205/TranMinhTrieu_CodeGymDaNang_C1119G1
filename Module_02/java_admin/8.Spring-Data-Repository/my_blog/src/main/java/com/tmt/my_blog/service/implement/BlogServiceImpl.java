package com.tmt.my_blog.service.implement;

import com.tmt.my_blog.model.Blog;
import com.tmt.my_blog.model.User;
import com.tmt.my_blog.repository.BlogRepository;
import com.tmt.my_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Iterable<Blog> findById(User user) {
        return blogRepository.findByUser(user);
    }


    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }
}