package com.tmt.baithi.service;

import com.tmt.baithi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable);
    Product getProductById(long id);
    void saveProduct(Product product);
    void deleteProductById(long id);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
