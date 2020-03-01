package com.codegym.baitap_giohang.controller;


import com.codegym.baitap_giohang.model.GioHang;
import com.codegym.baitap_giohang.model.Product;
import com.codegym.baitap_giohang.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("giohang")
public class ProductController {

   @Autowired
    ProductService productService;

@ModelAttribute("giohang")
public GioHang gioHang(){
    return new GioHang();
}

    @GetMapping("/")
    public ModelAndView home(Pageable pageable){
       ModelAndView modelAndView = new ModelAndView("index","products",productService.getAllProducts(pageable));
        return modelAndView;
    }

    @RequestMapping("/product/add")
    public String add(Model model){
        model.addAttribute("product",new Product());
        return "add";
    }

    @RequestMapping("/product/save")
    public String saveProduct(Product product, RedirectAttributes redirect){
        product.setId((long) (Math.random()*100));
        productService.save(product);
        redirect.addFlashAttribute("success","Add new product success");
        return "redirect:/";
    }

    @RequestMapping("/product/{id}/edit")
    public String edit(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("productE",productService.findByIdNew(id));
        return "edit";
    }

    @RequestMapping("/product/{id}/view")
    public String view(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("productV",productService.findByIdNew(id));
        return "view_product";
    }

    @PostMapping("/product/giohang")
    public String gioHangList(@ModelAttribute("giohang") GioHang gioHang, RedirectAttributes redirect
    ,@RequestParam("id") Long id){
    Product product = productService.findByIdNew(id);
        gioHang.add(product);
        redirect.addFlashAttribute("success","Add product to Gio Hang success");
        return "redirect:/";
    }

    @GetMapping("/showgiohang")
    public ModelAndView showGioHang(@ModelAttribute("giohang") GioHang gioHang){
        for (Product product:gioHang.getProductList()
             ) {
            System.out.println(product.getMoney());

        }
        ModelAndView modelAndView = new ModelAndView("show_gio_hang");
        return modelAndView;
    }

}
