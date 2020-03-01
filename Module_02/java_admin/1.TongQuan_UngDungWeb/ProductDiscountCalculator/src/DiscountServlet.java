import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/calculator")
public class DiscountServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        int percent = Integer.parseInt(request.getParameter("discount"));
        float discount = (float) (price*percent*0.01);
        float total = price - discount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.print("<h3> Product Description: </h3>" + description);
        writer.print("<h3> Product Price: </h3>" + price);
        writer.print("<h3> Product Percent: </h3>" + percent);
        writer.print("<h3> Product Discount: </h3>" + discount);
        writer.print("<h3> Product Total: </h3>" + total);
        writer.print("</html>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
