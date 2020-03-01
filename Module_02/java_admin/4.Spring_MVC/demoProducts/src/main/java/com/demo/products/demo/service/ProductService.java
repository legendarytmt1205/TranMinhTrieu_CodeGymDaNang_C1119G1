package com.demo.products.demo.service;

import com.demo.products.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void saveProduct(Product product);
    void deleteProductById(Long id);
}
