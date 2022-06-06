package controller;

import model.Role;
import model.User;
import service.impl.RoleServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();
    RoleServiceImpl roleService = new RoleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateUser(request, response);
                break;
            case "edit":
                showEditUser(request, response);
                break;
            case "delete":
                try {
                    deleteUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                showSearch(request, response);
                break;
            default:
                showListUser(request, response);
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        String name = request.getParameter("name");
        List<User> users = userService.findByName(name);
        List<Role> roles = roleService.findAllUser(users);
        if (users.size() > 0) {
            request.setAttribute("users", users);
            request.setAttribute("roles", roles);
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/users");
        }
    }

    private void showCreateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        request.setAttribute("users", user);
        requestDispatcher.forward(request, response);
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
        List<User> users = userService.findAll();
        List<Role> roles = roleService.findAllUser(users);
        request.setAttribute("users", users);
        request.setAttribute("roles", roles);
        requestDispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        response.sendRedirect("/users");
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        int roleId = 2;
        userService.add(new User(username, password, name, phone, roleId));
        response.sendRedirect("/users");
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        int roleId = 2;
        userService.update(new User(id, username, password, name, phone, roleId));
        response.sendRedirect("/users");
    }
}
