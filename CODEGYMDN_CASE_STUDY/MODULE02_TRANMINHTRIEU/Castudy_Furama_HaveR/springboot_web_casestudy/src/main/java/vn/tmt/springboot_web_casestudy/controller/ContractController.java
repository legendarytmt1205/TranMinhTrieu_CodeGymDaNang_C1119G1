package vn.tmt.springboot_web_casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.tmt.springboot_web_casestudy.entity.*;
import vn.tmt.springboot_web_casestudy.service.*;

import javax.validation.Valid;

@Controller
public class ContractController {

    @Autowired
    ContractService contractService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceService serviceService;

    @ModelAttribute("employees")
    public Iterable<Employee> getAllEmployee(){
        return employeeService.findAll();
    }

    @ModelAttribute("services")
    public Iterable<Services> typeServices(Pageable pageable){
        return serviceService.getAllServices(pageable);
    }

    @ModelAttribute("customers")
    public Iterable<Customer> typeRents(Pageable pageable){
        return customerService.getAllCustomers(pageable);
    }

    @GetMapping("admin/contract")
    public String createContract(Model model){
       model.addAttribute("contract",new Contract());
        return "contract/create";
    }

    @PostMapping("admin/contract/create")
    public ModelAndView createContract(@Valid @ModelAttribute(name = "contract") Contract contract, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ModelAndView("contract/create");
        } else {
            contractService.saveContract(contract);
            ModelAndView modelAndView = new ModelAndView("contract/create");
            modelAndView.addObject("contract", new Contract());
            modelAndView.addObject("message", "New contract created successfully");
            return modelAndView;
        }
    }
}
