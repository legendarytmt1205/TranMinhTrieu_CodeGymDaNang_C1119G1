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
import vn.tmt.springboot_web_casestudy.entity.*;
import vn.tmt.springboot_web_casestudy.service.*;

import java.util.Optional;

@Controller
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @Autowired
    TypeRentService typeRentService;

    @Autowired
    TypeServiceService typeServiceService;


    @ModelAttribute("typeServices")
    public Iterable<TypeServices> typeServices(){
        return typeServiceService.findAll();
    }

    @ModelAttribute("typeRents")
    public Iterable<TypeRent> typeRents(){
        return typeRentService.findAll();
    }

    @GetMapping("admin/service")
    public ModelAndView getAllService(@PageableDefault(value = 5) Pageable pageable,
                                       @RequestParam(name = "name") Optional<String> name, Model model){
        Page<Services> serviceList;
        if(name.isPresent()){
            serviceList = serviceService.findAllByNameContaining(name.get(), pageable);
            model.addAttribute("name",name.get());
        } else {
            serviceList = serviceService.getAllServices(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("service/index");
        modelAndView.addObject("listService",serviceList);
        return modelAndView;
    }

    @GetMapping({"admin/service/create"})
    public String create(Model model) {
        model.addAttribute("service", new Services());
        return "service/create";
    }

    @PostMapping("admin/service/create")
    public ModelAndView createService(@ModelAttribute(name = "service") Services service){
        serviceService.saveService(service);
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("service", new Services());
        modelAndView.addObject("message", "New service created successfully");
        return modelAndView;
    }


    @GetMapping("admin/service/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id){
        Services service = serviceService.getServiceById(id);
        System.out.println(service);
        if(service!=null) {
            return new ModelAndView("service/edit","service",service);
        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("admin/service/update")
    public ModelAndView updateService(@ModelAttribute("service") Services service){
        serviceService.saveService(service);
        ModelAndView modelAndView = new ModelAndView("service/edit");
        modelAndView.addObject("service",new Services());
        modelAndView.addObject("message", "Service updated successfully");
        return modelAndView;
    }

    @GetMapping({"admin/service/{id}/delete"})
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("service", serviceService.getServiceById(id));
        return "service/delete";
    }

    @PostMapping({"admin/service/delete"})
    public String delete(Services service, RedirectAttributes redirect) {
        serviceService.deleteServiceById(service.getId());
        redirect.addFlashAttribute("success", "Removed service successfully!");
        return "redirect:/admin/service";
    }

}
