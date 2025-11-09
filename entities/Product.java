package entities;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private String productName;
    private String productDescription;
    private String categorie;
    private int price;

    public Product(String productName, String productDescription, String categorie, int price) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.categorie = categorie;
        this.price = price;
    }

    public String getDescription() {
        return productDescription;
    }

    public String getName() {
        return productName;
    }

    public String getCategorie() {
        return categorie;
    }


    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return  productName + '\n' +
                productDescription + '\n' +
                categorie + '\n' +
                price + '\n';
    }

}
