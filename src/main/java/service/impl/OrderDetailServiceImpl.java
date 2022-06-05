package service.impl;

import model.OrderDetail;
import model.Product;
import service.OrderDetailService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
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
    public void add(OrderDetail orderDetail) throws SQLException {
        String insertOrderDetail = "insert into case3.orderdetail(orderId, productId, numberOfOrder, intoAmount) values (?,?,?,?)";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertOrderDetail)){
            preparedStatement.setString(1, String.valueOf(orderDetail.getOrder().getId()));
            preparedStatement.setString(2, String.valueOf(orderDetail.getProduct().getId()));
            preparedStatement.setString(3, String.valueOf(orderDetail.getNumberOfOrder()));
            preparedStatement.setString(4, String.valueOf(orderDetail.getIntoAmount()));
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public OrderDetail findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<OrderDetail> findAll() {
        return null;
    }

    @Override
    public List<OrderDetail> findByName(String name) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(OrderDetail orderDetail) throws SQLException {
        return false;
    }

    @Override
    public List<OrderDetail> findByOrderId(String id) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String query = "select od.productId, p.name, numberOfProduct, numberOfOrder, intoAmount\n" +
                "from case3.orderdetail od\n" +
                "join case3.product p on p.id = od.productId where od.orderId = ?";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("bookId");
                String name = resultSet.getString("name");
                int numberOfOrder = resultSet.getInt("numberOfOrder");
                int intoAmount = resultSet.getInt("intoAmount");
                int number = resultSet.getInt("numberOfProduct");
                Product product = new Product(productId, name, number);
                orderDetails.add(new OrderDetail(product, numberOfOrder, intoAmount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetails;
    }
}