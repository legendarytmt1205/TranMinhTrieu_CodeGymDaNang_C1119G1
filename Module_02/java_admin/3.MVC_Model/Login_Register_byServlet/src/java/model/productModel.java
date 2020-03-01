/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.aptech.ulti.MSSQLConnection;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trung
 */
public class productModel {

    public Product product = new Product();
    public MSSQLConnection db = new MSSQLConnection();

    public productModel() {
    }

    public productModel(Product product) {
        this.product.setName(product.getName());
        this.product.setImageURL(product.getImageURL());
        this.product.setPrice(product.getPrice());

    }

    public List<Product> listProducts() {
        try {
            List<Product> listProducts = new ArrayList();
            String query = "select * from dbo.products";
            PreparedStatement ps = db.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString("name"));
                p.setImageURL(rs.getString("imageURL"));
                p.setPrice(rs.getFloat("price"));
                p.setId(rs.getInt("id"));
                listProducts.add(p);
            }
            return listProducts;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;

    }

    public List<Product> findByName(String search) throws Exception {
        List<Product> listProducts = new ArrayList();
        String query = "select * from dbo.products where products.name like '%" + search + "%'";

        PreparedStatement ps = db.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product p = new Product();
            p.setName(rs.getString("name"));
            p.setImageURL(rs.getString("imageURL"));
            p.setPrice(rs.getFloat("price"));
            p.setId(rs.getInt("id"));
            listProducts.add(p);
        }
        return listProducts;
    }

}
