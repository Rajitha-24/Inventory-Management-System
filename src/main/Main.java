package main;

import dao.ProductDAO;
import model.Product;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProductDAO dao = new ProductDAO();

        System.out.println("===== Inventory Management System =====");

        System.out.println("1. Add Product");
        System.out.println("2. View Products");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");

        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                sc.nextLine();

                System.out.print("Enter Product Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Quantity: ");
                int quantity = sc.nextInt();

                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                Product product = new Product(name, quantity, price);

                dao.addProduct(product);

                break;

            case 2:

                dao.viewProducts();

                break;

            case 3:

                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();

                System.out.print("Enter New Quantity: ");
                int newQuantity = sc.nextInt();

                System.out.print("Enter New Price: ");
                double newPrice = sc.nextDouble();

                dao.updateProduct(id, newQuantity, newPrice);

                break;

            case 4:

                System.out.print("Enter Product ID To Delete: ");

                int deleteId = sc.nextInt();

                dao.deleteProduct(deleteId);

                break;

            default:

                System.out.println("Invalid Choice");
        }
    }
}