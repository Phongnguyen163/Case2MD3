package service.impl;

import model.Category;
import model.OrderDetail;
import model.Product;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ProductService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    CategoryService categoryService = new CategoryServiceImpl();
    protected Connection getConnection() {
        Connection connection = null;
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/case3?useSSL=false", "root", "1234");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from case3.product");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                int numberOfProduct = rs.getInt("numberOfProduct");
                int price = rs.getInt("price");
                int categoryid = rs.getInt("categoryid");
                Category categoryzz = categoryService.findById(categoryid);
                products.add(new Product(id,name,img,numberOfProduct,price,categoryzz));

            }
        } catch (SQLException e) {
        }

        return products;
    }

    @Override
    public void add(Product product) throws SQLException {
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("insert into case3.product (name,img,numberOfProduct,price,categoryid) value (?,?,?,?,?)");) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImg());
            preparedStatement.setInt(3, product.getNumberOfProduct());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setInt(5, product.getCategoryzz().getId());
            preparedStatement.executeUpdate();

            System.out.println(preparedStatement);

        } catch (SQLException e) {
        }

    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from case3.product where id = ?");) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String img = rs.getString("img");
                int numberOfProduct = rs.getInt("numberOfProduct");
                int price = rs.getInt("price");
                int categoryid = rs.getInt("categoryid");
                Category categoryz = categoryService.findById(categoryid);
                product = new Product(id,name,img,numberOfProduct,price,categoryz);
            }
        } catch (SQLException e) {
        }
        return product;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from case3.product where id=?");) {
            statement.setInt(1, id);
            System.out.println(statement);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        boolean upDate;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = getConnection().prepareStatement("update case3.product set name = ?, img = ?, numberOfProduct = ?, price = ?  where id = ?");) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImg());
            preparedStatement.setInt(3, product.getNumberOfProduct());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setInt(5, product.getId());
            upDate= preparedStatement.executeUpdate()>0;
        }
        return upDate;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }


    @Override
    public List<Product> findAllByClass(int categoryid) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from case3.product where categoryid = ?");) {
            preparedStatement.setInt(1,categoryid);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                int numberOfProduct = rs.getInt("numberOfProduct");
                int price = rs.getInt("price");
                int categoryzid = rs.getInt("categoryid");
                Category categoryzz = categoryService.findById(categoryzid);
                products.add(new Product(id,name,img,numberOfProduct,price,categoryzz));

            }
        } catch (SQLException e) {
        }

        return products;
    }

    @Override
    public List<Product> findAllByNameContains(String key) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from case3.product where name like ?");) {
            preparedStatement.setString(1,"%"+key+"%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String img = rs.getString("img");
                int numberOfProduct = rs.getInt("numberOfProduct");
                int price = rs.getInt("price");
                int categoryzid = rs.getInt("categoryid");
                Category categoryzz = categoryService.findById(categoryzid);
                products.add(new Product(id,name,img,numberOfProduct,price,categoryzz));

            }
        } catch (SQLException e) {
        }

        return products;
    }

    public void editQuantity(List<OrderDetail> orderDetails) {
        for (OrderDetail orderDetail : orderDetails) {
            String editQuantity = "update case3.product set numberOfProduct = ? where id = ?";
            try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(editQuantity)) {
                int number = orderDetail.getProduct().getNumberOfProduct() - orderDetail.getNumberOfOrder();
                preparedStatement.setString(1, String.valueOf(number));
                preparedStatement.setString(2, String.valueOf(orderDetail.getProduct().getId()));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
