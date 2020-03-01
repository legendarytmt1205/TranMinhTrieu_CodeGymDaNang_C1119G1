package com.codegym.jpa.demojpa.controllers;

import com.codegym.jpa.demojpa.model.Customer;
import com.codegym.jpa.demojpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView getAllCustomer(@PageableDefault(value = 3) Pageable pageable, @RequestParam(name = "name") Optional<String> name, Model model){
        Page<Customer> customerList;
        if(name.isPresent()){
            customerList = customerService.findAllByNameContaining(name.get(), pageable);
            model.addAttribute("name",name.get());
        } else {
            customerList = customerService.getAllCustomers(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("listCustomer",customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage(){
        return new ModelAndView("create","customer",new Customer());
    }

    @PostMapping("/create")
    public String saveCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/";
    }
}
