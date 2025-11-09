package controller;

import entities.Product;
import service.ProductService;
import service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ProductCatalogController {
    Scanner scanner = new Scanner(System.in);
    ProductService productService = new ProductService();
    UserService userService = new UserService();

    public void router() throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("\nКаталог товаров\n"
                    + "наберите 1, чтобы добавить товар\n"
                    + "Наберите 2, чтобы найти товар по названию\n"
                    + "Наберите 3, чтобы вывести весь список всех товаров\n"
                    + "Наберите 4 для фильтрация по категории\n"
                    + "Наберите 5, чтобы искать сначала дешевле\n"
                    + "Наберите 6, чтобы искать сначала дороже\n"
                    + "Наберите 7, чтобы выйти\n"
                    + "Наберите 8, чтобы авторизоваться\n"
                    + "Наберите 9, чтобы зарегистрироваться\n"
                    + "Наберите 10, чтобы выйти\n"


                    + "Наберите 100, чтобы добавить базовый список товаров\n"


            );

            switch (scanner.nextInt()) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    getByName();
                    break;
                case 3:
                    getProducts();
                    break;
                case 4:
                    getByCategorie();
                    break;
                case 5:
                    sortByPrice1();
                    break;
                case 6:
                    sortByPrice2();
                    break;
                case 7:
                    System.exit(0);
                    break;
                case 8:
                    auth();
                    break;
                case 9:
                    register();
                    break;
                case 10:
                    return;
                case 100:
                    basicFill();
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    public void addProduct(){
        scanner.nextLine();
        System.out.println("Введите название товара, который хотели бы добавить");
        String name = scanner.nextLine();
        System.out.println("Введите описание для товара");
        String description = scanner.nextLine();
        System.out.println("Введите категорию данного товара");
        String categorie = scanner.nextLine();
        System.out.println("Введите стоимость товара");
        int price = scanner.nextInt();
        productService.addProduct(name, description,categorie,price);
    }

    public void getProducts(){
        productService.getProducts().forEach(System.out::println);
    }


    public void getByName(){
        scanner.nextLine();
        System.out.println("Введите название товара, который ищите");
        String productName = scanner.nextLine();
        productService.getProducts().forEach(product -> {
            if(Objects.equals(product.getName(), productName))
                System.out.println(product.toString());
        });
    }

    public void getByCategorie(){
        scanner.nextLine();
        System.out.println("Введите категорию, которую ищите");
        String categorie = scanner.nextLine();
        productService.getProducts().forEach(product -> {
            if(Objects.equals(product.getCategorie(), categorie))
                System.out.println(product.toString());
        });
    }

    public void sortByPrice1(){
                ArrayList<Product> sortedArr1 = productService.getProducts().stream()
                        .sorted(Comparator.comparing(Product::getPrice))
                        .collect(Collectors.toCollection(ArrayList::new));
                sortedArr1.forEach(System.out::println);
    }

    public void sortByPrice2(){
                ArrayList<Product> sortedArr2 = productService.getProducts().stream()
                        .sorted(Comparator.comparing(Product::getPrice).reversed())
                        .collect(Collectors.toCollection(ArrayList::new));
                sortedArr2.forEach(System.out::println);

    }

    public void auth() throws IOException, ClassNotFoundException {

        scanner.nextLine();
        System.out.println("Введите логин");
        String username = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        userService.authentication(username,password);
    }

    public void register() throws IOException {
        scanner.nextLine();
        System.out.println("Введите логин");
        String username = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        userService.registration(username,password);
    }


    public void basicFill(){
        productService.addProduct("Молоко", "Коровье молоко","Молочные продукты",70);
        productService.addProduct("Мясо", "Говядина","Мясо",500);
        productService.addProduct("Курица","Куриная грудка", "Мясо",350);
        productService.addProduct("Сыр","Бри", "Молочные продукты",300);
        productService.addProduct("Холодильник","Хороший вместительный холодильник", "Техника",70000);
        productService.addProduct("Тостер","Чтобы делать тосты", "Техника",3000);

    }


}
