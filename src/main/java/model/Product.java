package model;

public class Product {
    private int id;
    private String name;
    private String img;
    private int numberOfProduct;
    private int price;
    private Category categoryzz;

    public Product() {
    }

    public Product(String name, String img, int numberOfProduct, int price, Category categoryzz) {
        this.name = name;
        this.img = img;
        this.numberOfProduct = numberOfProduct;
        this.price = price;
        this.categoryzz = categoryzz;
    }

    public Product(int id, String name, String img, int numberOfProduct, int price, Category categoryzz) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.numberOfProduct = numberOfProduct;
        this.price = price;
        this.categoryzz = categoryzz;
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

    public Category getCategoryzz() {
        return categoryzz;
    }

    public void setCategoryzz(Category categoryzz) {
        this.categoryzz = categoryzz;
    }
}
