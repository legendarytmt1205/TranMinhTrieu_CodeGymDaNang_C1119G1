package com.tmt.customer.controller;

import com.tmt.customer.model.Customer;
import com.tmt.customer.service.CustomerService;
import com.tmt.customer.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/customers")
    public ModelAndView listCustomers(){
        return new ModelAndView("/customer/list","customers",customerService.findAll()) ;
    }
}