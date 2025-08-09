package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT * FROM products";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getString("barcode")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void addProduct(String name, String category, double price, int quantity, String barcode) {
        try (Connection conn = Database.getConnection()) {
            String sql = "INSERT INTO products (name, category, price, quantity, barcode) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, category);
            stmt.setDouble(3, price);
            stmt.setInt(4, quantity);
            stmt.setString(5, barcode);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
