import controller.ProductCatalogController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new ProductCatalogController().router();
    }
}