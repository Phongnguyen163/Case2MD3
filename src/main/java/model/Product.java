package model;

public class Product {
    private int id;
    private String name;
    private int categoryID;
    private String img;
    private int numberOfProduct;
    private int price;

    public Product() {
    }

    public Product(int id, String name, int categoryID, String img, int numberOfProduct, int price) {
        this.id = id;
        this.name = name;
        this.categoryID = categoryID;
        this.img = img;
        this.numberOfProduct = numberOfProduct;
        this.price = price;
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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
