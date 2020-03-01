package com.tmt.cotroller;

import com.tmt.model.ItemCart;
import com.tmt.model.Product;
import com.tmt.service.ItemCartService;
import com.tmt.service.ItemCartServiceImpl;
import com.tmt.service.ProductService;
import com.tmt.service.ProductServiceImpl;
import sun.plugin.com.Dispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();
    private ItemCartService itemCartService = new ItemCartServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "buy":
                buyProduct(request, response);
                break;
            case "showCart":
                showShopCart(request,response);
                break;
            case "search":
                showSearchForm(request, response);
                break;
            default:
                showHomePage(request, response);
                break;
        }
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response) {

    }

    private void buyProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ItemCart> itemCartList = new ArrayList<>();
        int qty = 1;
        int id;
        id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        if (product != null) {
            if (request.getParameter("quantity") != null) {
                qty = Integer.parseInt(request.getParameter("quantity"));
            }

            HttpSession session = request.getSession();
            if (request.getAttribute("item") == null) {
                ItemCart itemCart = new ItemCart();
                itemCart.setId(id);
                itemCart.setProduct(product);
                itemCart.setQuantity(qty);
                itemCartList.add(itemCart);
            } else {
                ItemCart itemCart = (ItemCart) session.getAttribute("item");
                itemCartList = itemCartService.findAll();
                boolean check = false;
                for (ItemCart item : itemCartList) {
                    if (item.getProduct().getId() == product.getId()) {
                        item.setQuantity(item.getQuantity() + qty);
                        check = true;
                    }
                }
                if (check == false) {
                    ItemCart item = new ItemCart();
                    item.setId(id);
                    item.setProduct(product);
                    item.setQuantity(qty);
                    itemCartList.add(itemCart);
                }

            }
            System.out.println(itemCartList.get(0).getId());
            session.setAttribute("item", itemCartList);
            response.sendRedirect("views/show_shop_cart.jsp");
        } else {
            response.sendRedirect("views/show_shop_cart.jsp");
        }
    }

    private void showShopCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ItemCart> itemCarts = this.itemCartService.findAll();
        request.setAttribute("itemCarts", itemCarts);
        RequestDispatcher rp = request.getRequestDispatcher("views/show_shop_cart.jsp");
        rp.forward(request, response);
    }

    private void showHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = this.productService.findAll();
        request.setAttribute("products", products);
        RequestDispatcher rp = request.getRequestDispatcher("views/home_page.jsp");
        rp.forward(request, response);
    }
}
