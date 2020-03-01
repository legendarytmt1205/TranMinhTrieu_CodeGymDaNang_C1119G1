package com.tmt.service;

import com.tmt.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product findByName(String name);
}
