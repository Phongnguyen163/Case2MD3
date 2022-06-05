package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    CategoryService categoryService = new CategoryServiceImpl();
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryid = request.getParameter("categoryid");
        String key = request.getParameter("key");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        List<Product> products = productService.findAll();
        if (categoryid != null) {
            products = productService.findAllByClass(Integer.parseInt(categoryid));
        }
        if (key != null) {
            products = productService.findAllByNameContains(key);
        }
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
