package com.demo.products.demo.controler;

import com.demo.products.demo.entity.Product;
import com.demo.products.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String getAllProduct() {
        List<Product> list = productService.getAllProducts();
        return "/";
    }
}
