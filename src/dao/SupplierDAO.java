package dao;

import db.DBConnection;
import model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SupplierDAO {

    public void addSupplier(Supplier supplier) {

        String query =
                "INSERT INTO suppliers(supplier_name, phone) VALUES(?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, supplier.getSupplierName());
            ps.setString(2, supplier.getPhone());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Supplier Added Successfully");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewSuppliers() {

        String query = "SELECT * FROM suppliers";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== Supplier List =====");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("supplier_id") + " | " +
                                rs.getString("supplier_name") + " | " +
                                rs.getString("phone")
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateSupplier(int id, String phone) {

        String query =
                "UPDATE suppliers SET phone=? WHERE supplier_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, phone);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Supplier Updated Successfully");
            } else {
                System.out.println("Supplier Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteSupplier(int id) {

        String query =
                "DELETE FROM suppliers WHERE supplier_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Supplier Deleted Successfully");
            } else {
                System.out.println("Supplier Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}