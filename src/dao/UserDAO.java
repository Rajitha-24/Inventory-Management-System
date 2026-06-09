package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean login(String username, String password) {

        String query =
                "SELECT * FROM users WHERE username=? AND password=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {

            System.out.println(e);
        }

        return false;
    }
}