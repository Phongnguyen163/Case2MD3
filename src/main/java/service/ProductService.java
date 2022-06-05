package service;

import model.Product;

import java.util.List;

public interface ProductService extends GeneralService<Product>{
    List <Product> findAllByClass (int categoryid);
    List <Product> findAllByNameContains (String name);
}
