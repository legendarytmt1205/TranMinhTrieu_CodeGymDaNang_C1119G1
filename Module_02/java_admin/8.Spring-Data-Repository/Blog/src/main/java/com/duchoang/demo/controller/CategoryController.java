package com.duchoang.demo.controller;

import com.duchoang.demo.model.Blog;
import com.duchoang.demo.model.Category;
import com.duchoang.demo.service.Blogsevice;
import com.duchoang.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService  categoryService;

    @GetMapping("/category")
    public ModelAndView showCategoryFom(){
        Iterable<Category> category = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("category",category);
        return modelAndView;
    }
    @GetMapping("/create-category")
    public ModelAndView showCategorycreate(){
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }
    @PostMapping("create-category")
    public ModelAndView createCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category",category);
        return modelAndView;
    }
    @GetMapping("/edit-category/{id}")
    public ModelAndView showCategoryeidt(@PathVariable Long id){
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category",category);
        return modelAndView;
    }
    @PostMapping("edit-category")
    public ModelAndView eidtCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("category",category);
        return modelAndView;
    }
    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
            ModelAndView modelAndView = new ModelAndView("category/delete");
            modelAndView.addObject("category", category);
            return modelAndView;

    }

    @PostMapping("/delete-category")
    public String deleteProvince(@ModelAttribute("category") Category category){
        categoryService.remove(category);
        return "redirect:category";
    }

}
