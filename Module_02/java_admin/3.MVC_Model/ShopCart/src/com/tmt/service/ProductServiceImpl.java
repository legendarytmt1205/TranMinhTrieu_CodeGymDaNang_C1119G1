package com.tmt.service;

import com.tmt.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iphone7", "img/iphone-7.jpg", 12000));
        products.put(2, new Product(2, "iphone8", "img/iphone-8.png", 15000));
        products.put(3, new Product(3, "iphone10", "img/iphone-10.jpg", 19000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        List<Product> productList = findAll();
        for (Product product : productList) {
            if (product.getName().equals(name))
                return product;
        }
        return null;
    }
}
