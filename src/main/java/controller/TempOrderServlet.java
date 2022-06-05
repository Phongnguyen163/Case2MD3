package controller;

import model.*;
import service.OrderDetailService;
import service.OrderService;
import service.ProductService;
import service.UserService;
import service.impl.OrderDetailServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.TempOrder;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TempOrderServlet", value = "/carts")
public class TempOrderServlet extends HttpServlet {
    ProductService bookService = new ProductServiceImpl();
    TempOrder tempOrderManage = new TempOrder();
    UserService userService = new UserServiceImpl();
    OrderDetailService orderDetailService = new OrderDetailServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession httpSession = request.getSession();
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                deleteItem(request, response, httpSession);
                break;
            case "confirm":
                try {
                    confirmOrder(request, response, httpSession);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showTempOrder(request, response, httpSession);
        }
    }

    private void confirmOrder(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws SQLException, IOException {
        List<TempItem> tempOrder = (List<TempItem>) httpSession.getAttribute("tempOrder");
        int idUser = (int) httpSession.getAttribute("userId");
        User user = userService.findById(idUser);
        LocalDateTime dateOrder = LocalDateTime.now();
        int totalAmount = 0;
        Order order = new Order(user, dateOrder, totalAmount);
        for (TempItem item : tempOrder) {
            int intoAmount = item.getProduct().getPrice() * item.getQuantity();
            orderDetailService.add(new OrderDetail(order, item.getProduct(), item.getQuantity(), intoAmount));
            totalAmount += intoAmount;
        }
        order.setTotalAmount(totalAmount);
        orderService.add(order);
        tempOrder.clear();
        response.sendRedirect("/");
    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws IOException {
        List<TempItem> tempOrder = (List<TempItem>) httpSession.getAttribute("tempOrder");
        int id = Integer.parseInt(request.getParameter("id"));
        for (int i = 0; i < tempOrder.size(); i++) {
            if (tempOrder.get(i).getId() == id) {
                tempOrder.remove(tempOrder.get(i));
            }
        }
        if (tempOrder.size() != 0) {
            response.sendRedirect("/carts");
        }
        else {
            response.sendRedirect("/");
        }
    }

    private void showTempOrder(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart/list.jsp");
        List<TempItem> tempOrder = (List<TempItem>) httpSession.getAttribute("tempOrder");
        if(tempOrder == null) {
            tempOrder = new ArrayList<>();
            httpSession.setAttribute("tempOrder", tempOrder);
        }
        if (tempOrder.size() != 0) {
            List<Integer> intoMoneyList = new ArrayList<>();
            int totalAmount = 0;
            for (TempItem item : tempOrder) {
                int intoMoney = item.getProduct().getPrice() * item.getQuantity();
                intoMoneyList.add(intoMoney);
                totalAmount += intoMoney;
            }
            request.setAttribute("intoMoney", intoMoneyList);
            request.setAttribute("totalAmount", totalAmount);
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession httpSession = request.getSession();
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                try {
                    addToTemp(request, response, httpSession);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void addToTemp(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws SQLException, IOException {
        List<TempItem> tempOrder = (List<TempItem>) httpSession.getAttribute("tempOrder");
        int numberOfOrder = Integer.parseInt(request.getParameter("numberOfOrder"));
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = ProductService.findById(productId);
        TempItem tempItem = new TempItem(product, numberOfOrder);
        if (tempOrder == null) {
            tempOrder = new ArrayList<>();
            httpSession.setAttribute("tempOrder", tempOrder);
        }
        tempOrderManage.addToTemp(tempItem, tempOrder);
        response.sendRedirect("/carts");
    }
}
