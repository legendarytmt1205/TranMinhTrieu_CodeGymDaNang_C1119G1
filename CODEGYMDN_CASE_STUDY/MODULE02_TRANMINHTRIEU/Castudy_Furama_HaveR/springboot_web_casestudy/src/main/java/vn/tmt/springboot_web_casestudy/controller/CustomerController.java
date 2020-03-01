package vn.tmt.springboot_web_casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.tmt.springboot_web_casestudy.entity.Customer;
import vn.tmt.springboot_web_casestudy.entity.TypeCustomer;
import vn.tmt.springboot_web_casestudy.service.CustomerService;
import vn.tmt.springboot_web_casestudy.service.TypeCustomerService;
import vn.tmt.springboot_web_casestudy.utils.LocalDateFormatter;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    TypeCustomerService typeCustomerService;

    @ModelAttribute("typeCustomer")
    public Iterable<TypeCustomer> typeCustomers(){
        return typeCustomerService.findAll();
    }

    @Autowired
    LocalDateFormatter localDateFormatter;

    @GetMapping("admin/customer")
    public ModelAndView getAllCustomer(@PageableDefault(value = 8) Pageable pageable,
                                       @RequestParam(name = "name") Optional<String> name, Model model){
        Page<Customer> customerList;
        if(name.isPresent()){
            customerList = customerService.findAllByNameContaining(name.get(), pageable);
            model.addAttribute("name",name.get());
        } else {
            customerList = customerService.getAllCustomers(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("customer/index");
        modelAndView.addObject("listCustomer",customerList);
        return modelAndView;
    }

    @GetMapping({"admin/customer/create"})
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("admin/customer/create")
    public ModelAndView createBlog(@Valid @ModelAttribute(name = "customer") Customer customer, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ModelAndView("customer/create");
        } else {
            customerService.saveCustomer(customer);
            ModelAndView modelAndView = new ModelAndView("customer/create");
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("message", "New customer created successfully");
            return modelAndView;
        }
    }

    @GetMapping("admin/customer/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer = customerService.getCustomerById(id);
        if(customer!=null) {
            return new ModelAndView("customer/edit","customer",customer);
        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("admin/customer/update")
    public ModelAndView updateBlog(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ModelAndView("customer/edit");
        } else {
            customerService.saveCustomer(customer);
            ModelAndView modelAndView = new ModelAndView("customer/edit");
            modelAndView.addObject("customer",new Customer());
            modelAndView.addObject("message", "Customer updated successfully");
            return modelAndView;
        }
    }

    @GetMapping({"admin/customer/{id}/delete"})
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("customer", this.customerService.getCustomerById(id));
        return "customer/delete";
    }

    @PostMapping({"admin/customer/delete"})
    public String delete(Customer customer, RedirectAttributes redirect) {
        this.customerService.deleteCustomerById(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/admin/customer";
    }

//    @GetMapping({"admin/customer/{id}/view"})
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("customer", this.customerService.getCustomerById(id));
//        return "view";
//    }
}
