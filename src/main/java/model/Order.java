package model;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private User customer;
    private User ownerShop;
    private LocalDateTime date;
    private int totalAmount;
    private int status;

    public Order(int id, LocalDateTime date, int totalAmount) {
        this.id = id;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public Order(int id, User customer, User ownerShop, LocalDateTime date, int totalAmount, int status) {
        this.id = id;
        this.customer = customer;
        this.ownerShop = ownerShop;
        this.date = date;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Order(int id, User customer, LocalDateTime date, int totalAmount) {
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public Order(User customer, LocalDateTime date, int totalAmount) {
        this.customer = customer;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getOwnerShop() {
        return ownerShop;
    }

    public void setOwnerShop(User ownerShop) {
        this.ownerShop = ownerShop;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
