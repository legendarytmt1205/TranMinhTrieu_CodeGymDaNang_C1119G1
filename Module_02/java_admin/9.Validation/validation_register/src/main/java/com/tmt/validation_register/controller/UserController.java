package com.tmt.validation_register.controller;

import com.tmt.validation_register.model.User;
import com.tmt.validation_register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView showList() {
        return new ModelAndView("list","users",userService.findAll());
    }

    @GetMapping("/create-user")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create","user", new User());
    }

    @PostMapping("/create-user")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("create");
        }
        ModelAndView modelAndView;
        modelAndView= new ModelAndView("create");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message","Create Success");
        userService.save(user);
        System.out.println("Create success");
        return modelAndView;
    }
}