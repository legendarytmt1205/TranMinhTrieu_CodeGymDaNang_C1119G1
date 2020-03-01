package vn.tmt.springboot_web_casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.tmt.springboot_web_casestudy.entity.FuramaCustomer;
import vn.tmt.springboot_web_casestudy.entity.FuramaTypeCustomer;
import vn.tmt.springboot_web_casestudy.service.CustomerService;
import vn.tmt.springboot_web_casestudy.service.TypeCustomerService;

import java.sql.Date;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    TypeCustomerService typeCustomerService;

    @ModelAttribute("typeCustomers")
    public Iterable<FuramaTypeCustomer> typeCustomers(){
        return typeCustomerService.findAll();
    }

    @GetMapping("admin/customer")
    public ModelAndView getAllCustomer(@PageableDefault(value = 3) Pageable pageable, @RequestParam(name = "name") Optional<String> name, Model model){
        Page<FuramaCustomer> customerList;
        customerList = getCustomerList(pageable, name, model);
        ModelAndView modelAndView = new ModelAndView("customer/index");
        modelAndView.addObject("listCustomer",customerList);
        model.addAttribute("customerAdd", new FuramaCustomer());
        return modelAndView;
    }

    private Page<FuramaCustomer> getCustomerList(@PageableDefault(3) Pageable pageable, @RequestParam(name = "name") Optional<String> name, Model model) {
        Page<FuramaCustomer> customerList;
        if(name.isPresent()){
            customerList = customerService.findAllByNameContaining(name.get(), pageable);
            model.addAttribute("name",name.get());
        } else {
            customerList = customerService.getAllCustomers(pageable);
        }
        return customerList;
    }

//    @GetMapping({"admin/customer/create"})
//    public String create(Model model) {
//        model.addAttribute("customer", new FuramaCustomer());
//        return "customer/create";
//    }

    @PostMapping("admin/customer")
    public ModelAndView createBlog(@ModelAttribute(name = "customer") FuramaCustomer customer){
        customer.setBirthday(Date.valueOf("1988-01-01"));
        customerService.saveCustomer(customer);
        System.out.println(customer);
        ModelAndView modelAndView = new ModelAndView("customer/index");
//        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("blog", new FuramaCustomer());
        modelAndView.addObject("message", "New blog created successfully");
        modelAndView.addObject("customerAdd", new FuramaCustomer());
        return modelAndView;
    }

    @GetMapping({"admin/customer/{id}/edit"})
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", this.customerService.getCustomerById(id));
        return "customer/edit";
    }

    @PostMapping({"admin/customer/update"})
    public String update(FuramaCustomer customer, RedirectAttributes redirect) {
        this.customerService.updateCustomer(customer.getId(), customer);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:admin/customer";
    }

    @GetMapping({"admin/customer/{id}/delete"})
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", this.customerService.getCustomerById(id));
        return "customer/delete";
    }

    @PostMapping({"admin/customer/delete"})
    public String delete(FuramaCustomer customer, RedirectAttributes redirect) {
        this.customerService.deleteCustomerById(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping({"admin/customer/{id}/view"})
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", this.customerService.getCustomerById(id));
        return "view";
    }
}
