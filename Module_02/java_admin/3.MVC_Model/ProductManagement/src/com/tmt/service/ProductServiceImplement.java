package com.tmt.service;
import com.tmt.model.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImplement implements ProductService{

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iphone", 12000, "iphoneX", "apple"));
        products.put(2, new Product(2, "note9", 10000, "note", "samsung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getProductId(), product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        List<Product> productList = findAll();
        for (Product product : productList) {
            if (product.getProductName().equals(name))
                return product;
        }
        return null;
    }
}
