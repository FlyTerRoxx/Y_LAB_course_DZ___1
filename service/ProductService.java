package service;

import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private List<Product> products = new ArrayList<>();


    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(String name, String description, String categorie,int price){
        products.add(new Product(name, description,categorie,price));
    }
}
