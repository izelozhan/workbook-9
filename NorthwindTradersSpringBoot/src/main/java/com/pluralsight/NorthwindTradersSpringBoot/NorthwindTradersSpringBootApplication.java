package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

    public static void main(String[] args) {
        ApplicationContext context;
        context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
        IProductDAO productDAO = context.getBean(IProductDAO.class);

        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                listProducts(productDAO);
            } else if (choice == 2) {
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Category: ");
                String category = scanner.nextLine();

                System.out.print("Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                int nextId = productDAO.getProducts().size() + 1;
                productDAO.getProducts().add(new Product(nextId, name, category, price));
            } else if (choice == 0) {
               running = false;
                System.out.println("Bye!");
            }
        }
        scanner.close();

    }
    private static void printMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. List Products");
        System.out.println("2. Add Product");
        System.out.println("0. Exit");
    }

    private static void  listProducts(IProductDAO productDAO){
        for (Product p : productDAO.getProducts()) {
            System.out.println("Product ID: " + p.getProductId() + " Product Name: " + p.getName());
        }
    }


}
