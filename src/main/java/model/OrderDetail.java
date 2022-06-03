package model;

public class OrderDetail {
    private int orderID;
    private int productId;
    private int numberOfOrder;
    private int intoAmount;

    public OrderDetail() {
    }

    public OrderDetail(int orderID, int productId, int numberOfOrder, int intoAmount) {
        this.orderID = orderID;
        this.productId = productId;
        this.numberOfOrder = numberOfOrder;
        this.intoAmount = intoAmount;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public int getIntoAmount() {
        return intoAmount;
    }

    public void setIntoAmount(int intoAmount) {
        this.intoAmount = intoAmount;
    }
}
