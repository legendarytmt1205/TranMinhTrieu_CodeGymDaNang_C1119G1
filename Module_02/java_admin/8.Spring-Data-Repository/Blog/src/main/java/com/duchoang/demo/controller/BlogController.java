package com.duchoang.demo.controller;

import com.duchoang.demo.model.Blog;
import com.duchoang.demo.model.Category;
import com.duchoang.demo.service.Blogsevice;
import com.duchoang.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private Blogsevice blogsevice;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("category")
    public Iterable<Category> provinces() {
        return categoryService.findAll();
    }

    @GetMapping("/blog")
    public ModelAndView showBlog(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Blog> blogs;
        if (s.isPresent()) {
            blogs = blogsevice.findAllByName(s.get(), pageable);
        } else {
            blogs = blogsevice.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView createBlog() {
        return new ModelAndView("blog/create", "blog", new Blog());
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute(name = "blog") Blog blog,
                                 @RequestParam(name = "category")Long categoryId) {
        Category category = categoryService.findById(categoryId);
        blog.setCategory(category);
        blogsevice.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView editBlog(@PathVariable Long id) {
        Blog blog = blogsevice.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/edit", "blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit-blog")
    public ModelAndView editBlog(@ModelAttribute(name = "blog") Blog blog) {
        blogsevice.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView deleteBlog(@PathVariable Long id) {
        Blog blog = blogsevice.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("blog/delete", "blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute(name = "blog") Blog blog) {
        blogsevice.remove(blog);
        return "redirect:/blog";
    }
}
