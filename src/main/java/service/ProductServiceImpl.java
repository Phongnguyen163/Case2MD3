package service;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    CategoryService categoryService = new CategoryServiceImpl();
    protected Connection getConnection() {
        Connection connection = null;
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/case3?useSSL=false", "root", "123456");
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

             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {
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

             PreparedStatement preparedStatement = connection.prepareStatement("insert into product (name,img,numberOfProduct,price,categoryid) value (?,?,?,?,?)");) {
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
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findAllOderByAge() {
        return null;
    }
}
