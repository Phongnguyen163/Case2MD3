package service.impl;

import model.User;
import service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/case3?useSSL=false", "root", "1234");
        } catch (SQLException | ClassNotFoundException ignored) {

        }
        return connection;
    }
    @Override
    public void add(User user) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into case3.user(username,password,name,phoneNumber,roleId ) values (?,?,?,?,2)")) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3,user.getName());
            preparedStatement.setString(4,user.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {

        }

    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from case3.user where id =?")) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String phone = rs.getString("phoneNumber");
                int roleId = rs.getInt("roleId");
                user = new User(id, username, password,name,phone,roleId);
            }
        } catch (SQLException ignored) {
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from case3.user where roleId=2")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String phone = rs.getString("phoneNumber");
                int roleId = rs.getInt("roleId");
                users.add(new User(id, username, password,name,phone,roleId));
            }
        } catch (SQLException ignored) {

        }
        return users;
    }


    @Override
    public List<User> findByName(String name) {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from case3.user where roleId=2 and name like ?; ")) {
            preparedStatement.setString(1, '%'+name+'%');
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nameFind = rs.getString("name");
                String phone = rs.getString("phoneNumber");
                int roleId = rs.getInt("roleId");
                users.add(new User(id,username,password,nameFind,phone,roleId));
            }
        } catch (SQLException ignored) {

        }
        return users;
    }
    public List<User> findByUserName(String name) {
        List<User> user = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from case3.user where username = ?; ")) {
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String usernameFind = rs.getString("username");
                String password = rs.getString("password");
                String nameFind = rs.getString("name");
                String phone = rs.getString("phoneNumber");
                int roleId = rs.getInt("roleId");
                user.add(new User(id,usernameFind,password,nameFind,phone,roleId));
                return user;
            }
        } catch (SQLException ignored) {

        }
        return null;
    }
    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement("delete from case3.user where id=?")) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    @Override
    public boolean update(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update case3.user set password=?,name=?,phoneNumber =?,roleId=? where id=?;")) {
            preparedStatement.setString(1,user.getPassword());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setInt(4, user.getRoleID());
            preparedStatement.setInt(5, user.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public User findByUserNamePassword(String username,String password) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from case3.user where username like ? and password like ?")) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String usr = rs.getString("username");
                String pw = rs.getString("password");
                String name = rs.getString("name");
                String phone = rs.getString("phoneNumber");
                int roleId = rs.getInt("roleId");
                user = new User(id, usr, pw,name,phone,roleId);
            }
        } catch (SQLException ignored) {
        }
        return user;
    }

}
