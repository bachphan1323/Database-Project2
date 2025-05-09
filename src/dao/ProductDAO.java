package dao;

import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS product (
                productID INTEGER PRIMARY KEY,
                prod_name TEXT NOT NULL,
                prod_price INTEGER NOT NULL,
                stock_quantity INTEGER NOT NULL,
                prod_itemID INTEGER NOT NULL
            );
            """;

        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSampleData() {
        String sql = "INSERT OR IGNORE INTO product(productID, prod_name, prod_price, stock_quantity, prod_itemID) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Wireless Mouse");
            pstmt.setInt(3, 25);
            pstmt.setInt(4, 100);
            pstmt.setInt(5, 1001);
            pstmt.executeUpdate();

            pstmt.setInt(1, 2);
            pstmt.setString(2, "Mechanical Keyboard");
            pstmt.setInt(3, 75);
            pstmt.setInt(4, 50);
            pstmt.setInt(5, 1002);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                products.add(new Product(
                    rs.getInt("productID"),
                    rs.getString("prod_name"),
                    rs.getInt("prod_price"),
                    rs.getInt("stock_quantity"),
                    rs.getInt("prod_itemID")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}

