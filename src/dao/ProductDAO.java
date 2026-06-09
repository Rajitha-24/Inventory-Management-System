package dao;

import db.DBConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO {

    public void addProduct(Product product) {

        String query = "INSERT INTO products(product_name, quantity, price) VALUES (?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getQuantity());
            ps.setDouble(3, product.getPrice());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product Added Successfully");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewProducts() {

        String query = "SELECT * FROM products";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== PRODUCT LIST =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("product_name") + " | " +
                                rs.getInt("quantity") + " | " +
                                rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateProduct(int id, int quantity, double price) {

        String query = "UPDATE products SET quantity=?, price=? WHERE product_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, quantity);
            ps.setDouble(2, price);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product Updated Successfully");
            } else {
                System.out.println("Product Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteProduct(int id) {

        String query = "DELETE FROM products WHERE product_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product Deleted Successfully");
            } else {
                System.out.println("Product Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void searchProduct(String productName) {

        String query = "SELECT * FROM products WHERE product_name LIKE ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, "%" + productName + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== SEARCH RESULTS =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("product_name") + " | " +
                                rs.getInt("quantity") + " | " +
                                rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void lowStockProducts() {

        String query = "SELECT * FROM products WHERE quantity < 5";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== LOW STOCK PRODUCTS =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("product_id") + " | " +
                                rs.getString("product_name") + " | " +
                                rs.getInt("quantity") + " | " +
                                rs.getDouble("price")
                );
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public void inventoryReport() {

        String query = "SELECT COUNT(*) AS totalProducts, " +
                "SUM(quantity) AS totalStock, " +
                "SUM(quantity * price) AS inventoryValue " +
                "FROM products";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n===== INVENTORY REPORT =====");

                System.out.println(
                        "Total Products : " +
                                rs.getInt("totalProducts")
                );

                System.out.println(
                        "Total Stock Quantity : " +
                                rs.getInt("totalStock")
                );

                System.out.println(
                        "Total Inventory Value : ₹" +
                                rs.getDouble("inventoryValue")
                );
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}