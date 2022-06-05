package model;

public class OrderDetail {
    private Order order;
    private Product product;
    private int numberOfOrder;
    private int intoAmount;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product, int numberOfOrder, int intoAmount) {
        this.order = order;
        this.product = product;
        this.numberOfOrder = numberOfOrder;
        this.intoAmount = intoAmount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
