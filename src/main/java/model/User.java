package model;

public class User {
    private int id;
    private String name;
    private String phongNumber;
    private int roleID;

    public User() {
    }

    public User(int id, String name, String phongNumber, int roleID) {
        this.id = id;
        this.name = name;
        this.phongNumber = phongNumber;
        this.roleID = roleID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhongNumber() {
        return phongNumber;
    }

    public void setPhongNumber(String phongNumber) {
        this.phongNumber = phongNumber;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}
