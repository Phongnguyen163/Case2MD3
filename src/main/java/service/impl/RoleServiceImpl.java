package service.impl;

import model.Role;
import model.User;
import service.RoleService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    public RoleServiceImpl() {
    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/case3?useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException ignored) {

        }
        return connection;
    }

    @Override
    public void add(Role role) {

    }

    @Override
    public Role findById(int id) {
        Role role = new Role();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select id,name from case3.role where id=?")) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                role = new Role(id, name);
            }
        } catch (SQLException ignored) {

        }
        return role;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public List<Role> findByName(String name) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Role role) {
        return false;
    }
    public List<Role> findAllUser(List<User> users){
        List<Role> list = new ArrayList<>();
        for (User user : users) {
            Role role = findById(user.getRoleID());
            list.add(role);
        }
        return list;
    }
}
