/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.aptech.controller;

import java.com.aptech.ulti.MSSQLConnection;

import java.com.aptech.ulti.MSSQLConnection;
import java.entity.ItemCart;
import java.entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.model.productModel;

/**
 *
 * @author Trung
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet implements Serializable {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("action") == null) {
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        } else {
            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("buy")) {
                try {
                    Cart_Buy(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (action.equalsIgnoreCase("remove")) {
                Cart_Remove(request, response);
            } else {
                request.getRequestDispatcher("cart.jsp").forward(request, response);
            }
        }

    }

    protected void Cart_Buy(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            List<ItemCart> cart = new ArrayList<ItemCart>();
            MSSQLConnection objDB = new MSSQLConnection();
            String id = request.getParameter("productId");
            String sqlQuery = "Select * from dbo.products where id = " + id;
            ResultSet rs = objDB.query(sqlQuery);
            rs.next();
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getFloat("price"));
            p.setImageURL(rs.getString("imageURL"));
            ItemCart item = new ItemCart(p, 1);
            cart.add(item);
            session.setAttribute("cart", cart);
        } else {
            List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
            int index = isExisting(request.getParameter("productId"), cart);
            if (index == -1) {
                MSSQLConnection objDB = new MSSQLConnection();
                String id = request.getParameter("productId");
                String sqlQuery = "Select * from dbo.products where id = " + id;
                ResultSet rs = objDB.query(sqlQuery);
                rs.next();
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getFloat("price"));
                p.setImageURL(rs.getString("imageURL"));
                ItemCart item = new ItemCart(p, 1);
                cart.add(item);
            } else {
                int quantity = cart.get(index).getQuatity() + 1;
                cart.get(index).setQuatity(quantity);
            }
            session.setAttribute("cart", cart);
        }

        response.sendRedirect("/demo/products");
    }

    private int isExisting(String id, List<ItemCart> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == Integer.parseInt(id)) {
                return i;
            }
        }
        return -1;
    }

    protected void Cart_Remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
        int index = isExisting(request.getParameter("productId"), cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        response.sendRedirect("/demo/cart");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
