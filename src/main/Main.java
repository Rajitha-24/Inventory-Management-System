package main;

import dao.ProductDAO;
import dao.SupplierDAO;
import dao.UserDAO;
import model.Product;
import model.Supplier;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserDAO userDAO = new UserDAO();

        System.out.println("===== LOGIN =====");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        boolean loginSuccess = userDAO.login(username, password);

        if (!loginSuccess) {
            System.out.println("Invalid Username or Password");
            return;
        }

        System.out.println("Login Successful");

        ProductDAO productDAO = new ProductDAO();
        SupplierDAO supplierDAO = new SupplierDAO();

        while (true) {

            System.out.println("\n===== Inventory Management System =====");

            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Search Product");
            System.out.println("6. Add Supplier");
            System.out.println("7. View Suppliers");
            System.out.println("8. Update Supplier");
            System.out.println("9. Delete Supplier");
            System.out.println("10. Low Stock Alert");
            System.out.println("11. Inventory Report");
            System.out.println("12. Exit");

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

                    productDAO.addProduct(product);

                    break;

                case 2:

                    productDAO.viewProducts();

                    break;

                case 3:

                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQuantity = sc.nextInt();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    productDAO.updateProduct(id, newQuantity, newPrice);

                    break;

                case 4:

                    System.out.print("Enter Product ID To Delete: ");
                    int deleteId = sc.nextInt();

                    productDAO.deleteProduct(deleteId);

                    break;

                case 5:

                    sc.nextLine();

                    System.out.print("Enter Product Name To Search: ");
                    String keyword = sc.nextLine();

                    productDAO.searchProduct(keyword);

                    break;

                case 6:

                    sc.nextLine();

                    System.out.print("Enter Supplier Name: ");
                    String supplierName = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    Supplier supplier = new Supplier(supplierName, phone);

                    supplierDAO.addSupplier(supplier);

                    break;

                case 7:

                    supplierDAO.viewSuppliers();

                    break;

                case 8:

                    System.out.print("Enter Supplier ID: ");
                    int supplierId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Phone Number: ");
                    String newPhone = sc.nextLine();

                    supplierDAO.updateSupplier(supplierId, newPhone);

                    break;

                case 9:

                    System.out.print("Enter Supplier ID To Delete: ");
                    int deleteSupplierId = sc.nextInt();

                    supplierDAO.deleteSupplier(deleteSupplierId);

                    break;

                case 10:

                    productDAO.lowStockProducts();

                    break;

                case 11:

                    productDAO.inventoryReport();

                    break;

                case 12:

                    System.out.println("Thank You!");
                    System.exit(0);

                    break;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}