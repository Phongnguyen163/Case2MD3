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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryServiceImpl categoryService=new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("act");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            default:
                showList(request, response);
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories=categoryService.findAll();
        request.setAttribute("categoryes",categories);
        RequestDispatcher rd=request.getRequestDispatcher("/product/create.jsp");
        rd.forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        List<Product> products = productService.findAll();
        request.setAttribute("ds", products);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("act");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                save(request, response);
                break;
        }

    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name= request.getParameter("name");
        String img= request.getParameter("img");
        int numberOfProduct= Integer.parseInt(request.getParameter("numberOfProduct"));
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryId= Integer.parseInt(request.getParameter("categoryid"));
         Category categoryzz=categoryService.findById(categoryId);
        try {
            productService.add(new Product(name,img,numberOfProduct,price,categoryzz));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/home");
    }

}
