package com.tmt.baithi.controller;

import com.tmt.baithi.entity.Product;
import com.tmt.baithi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ModelAndView getAllCustomer(@PageableDefault(value = 3) Pageable pageable,
                                       @RequestParam(name = "name") Optional<String> name, Model model) {
        Page<Product> productList;
        pageable = PageRequest.of(pageable.getPageNumber(), 8, Sort.by("name").descending());

        if (name.isPresent()) {
            productList = productService.findAllByNameContaining(name.get(), pageable);
            model.addAttribute("name", name.get());
        } else {
            productList = productService.getAllProducts(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("listProduct", productList);
        return modelAndView;
    }

    @GetMapping({"product/create"})
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("product/create")
    public String create(@ModelAttribute(name = "product") Product product, RedirectAttributes redirect) {
        product.setCreate_day(new Date());
        productService.saveProduct(product);
        redirect.addFlashAttribute("message", "New product created successfully");
        return "redirect:/product";
    }

    @GetMapping("product/{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ModelAndView("edit", "product", product);
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("product/update")
    public ModelAndView update(@ModelAttribute("product") Product product) {
        product.setCreate_day(new Date());
        productService.saveProduct(product);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }

    @GetMapping({"product/{id}/delete"})
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("product", this.productService.getProductById(id));
        return "delete";
    }

    @PostMapping({"product/delete"})
    public String delete(Product product, RedirectAttributes redirect) {
        this.productService.deleteProductById(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }
}
