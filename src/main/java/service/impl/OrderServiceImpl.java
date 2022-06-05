package service.impl;

import model.Order;
import model.User;
import service.OrderService;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public void add(Order order) throws SQLException {
        String insertOrder = "insert into case3.orderr(id, customerId, date, totalAmount, status) values (?,?,?,?,1);";
        try (Connection conn = getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(insertOrder)) {
            preparedStatement.setString(1, String.valueOf(order.getId()));
            preparedStatement.setString(2, String.valueOf(order.getCustomer().getId()));
            preparedStatement.setString(3, String.valueOf(order.getDate()));
            preparedStatement.setString(4, String.valueOf(order.getTotalAmount()));
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Order findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        String query = "select o.id, o.customerId, u.name, o.ownerShopId, u2.name, date, totalAmount, o.status\n" +
                "from case3.orderr o\n" +
                "join case3.user u on o.customerId = u.id\n" +
                "join case3.user u2 on o.ownerShopId = u2.id;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customerId");
                String nameCustomer = resultSet.getString("u.name");
                int ownerShopId = resultSet.getInt("ownerShopId");
                String nameOwner = resultSet.getString("u2.name");
                LocalDateTime localDateTime = LocalDateTime.parse(resultSet.getString("date"));
                int totalAmount = resultSet.getInt("totalAmount");
                User customer = new User(customerId, nameCustomer);
                User ownerShop = new User(ownerShopId, nameOwner);
                int status = resultSet.getInt("status");
                Order order = new Order(id, customer, ownerShop, localDateTime, totalAmount, status);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public List<Order> findByName(String name) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    public boolean delete(String id) throws SQLException {
        boolean rowDelete;
        String deleteOrder = "UPDATE case3.orderr set status = 0 where id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(deleteOrder)) {
            preparedStatement.setString(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return false;
    }

    @Override
    public boolean update(Order order) throws SQLException {
        return false;
    }

    public boolean confirm(String id, int ownerShopId) {
        boolean rowUpdate;
        String updateOrder = "update case3.orderr set ownerShopId = ?, status = 2 where id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateOrder)){
            preparedStatement.setString(1, String.valueOf(ownerShopId));
            preparedStatement.setString(2, id);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(String id, int ownerShopId) {
        boolean rowUpdate;
        String updateOrder = "update case3.orderr set ownerShopId = ?, status = 0 where id = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateOrder)){
            preparedStatement.setString(1, String.valueOf(ownerShopId));
            preparedStatement.setString(2, id);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate;
    }

    @Override
    public List<Order> findByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        String query = "select o.id, o.customerId, u.name, date, totalAmount\n" +
                "from  case3.orderr o\n" +
                "join case3.user u on o.customerId = u.id\n" +
                "where o.status = 1 and o.customerId = ?;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, String.valueOf(userId));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customerId");
                String name = resultSet.getString("name");
                LocalDateTime localDateTime = LocalDateTime.parse(resultSet.getString("date"));
                int totalAmount = resultSet.getInt("totalAmount");
                User user = new User(customerId, name);
                Order order = new Order(id, user, localDateTime, totalAmount);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public Order findById(String id) {
        String query = "select id, date, totalAmount from case3.orderr where id = ?";
        Order order = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idFind = resultSet.getInt("id");
                LocalDateTime dateTime = LocalDateTime.parse(resultSet.getString("date"));
                int totalAmount = resultSet.getInt("totalAmount");
                order = new Order(idFind,dateTime, totalAmount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public List<Order> findUnconfirm() {
        List<Order> orders = new ArrayList<>();
        String query = "select o.id, o.customerId, u.name, date, totalAmount\n" +
                "from case3.orderr o\n" +
                "join case3.user u on o.customerId = u.id\n" +
                "where o.status = 1;";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customerId");
                String name = resultSet.getString("name");
                LocalDateTime localDateTime = LocalDateTime.parse(resultSet.getString("date"));
                int totalAmount = resultSet.getInt("totalAmount");
                User user = new User(customerId, name);
                Order order = new Order(id, user, localDateTime, totalAmount);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
}