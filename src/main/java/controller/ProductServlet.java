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
    CategoryService categoryService = new CategoryServiceImpl();
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
            case "view":
                showView(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("delete", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/delete.jsp");
        requestDispatcher.forward(request, response);

    }

    private void showView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("product/create.jsp").forward(request,response);
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
                try {
                    CreateForm(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    deleteForm(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showList(request, response);
        }
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("/home");
    }

    private void CreateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        int numberOfProduct = Integer.parseInt(request.getParameter("numberOfProduct"));
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryid = Integer.parseInt(request.getParameter("categoryid"));
        Category categoryz = categoryService.findById(categoryid);
        productService.add(new Product(0,name,img,numberOfProduct,price,categoryz));
        response.sendRedirect("/home");

//        Class clazz = classService.findById(cID);
//        studentService.add(new Student(0,name,age,clazz));
//        response.sendRedirect("/home");
    }
}
