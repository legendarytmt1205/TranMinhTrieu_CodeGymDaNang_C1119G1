package com.tmt.cotroller;

import com.tmt.model.Product;
import com.tmt.service.ItemCartService;
import com.tmt.service.ItemCartServiceImpl;
import com.tmt.service.ProductService;
import com.tmt.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ItemCartServlet",urlPatterns = "/item")
public class ItemCartServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();
    private ItemCartService itemCartService = new ItemCartServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products", products);
        RequestDispatcher rp = request.getRequestDispatcher("views/show_shop_cart.jsp");
        rp.forward(request, response);
    }
}
