package model;

import java.time.LocalDateTime;

public class Oderr {
    private int id;
    private int ownerShopId;
    private int customerId;
    private LocalDateTime date;
    private int totalAmount;
    private String status;

    public Oderr() {
    }

    public Oderr(int id, int ownerShopId, int customerId, LocalDateTime date, int totalAmount, String status) {
        this.id = id;
        this.ownerShopId = ownerShopId;
        this.customerId = customerId;
        this.date = date;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerShopId() {
        return ownerShopId;
    }

    public void setOwnerShopId(int ownerShopId) {
        this.ownerShopId = ownerShopId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
