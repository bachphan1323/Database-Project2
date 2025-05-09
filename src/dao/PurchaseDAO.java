package dao;

import model.Purchase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO {

    public void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS purchase (
                purchaseID INTEGER PRIMARY KEY,
                purchase_date TEXT NOT NULL,
                totalPrice REAL NOT NULL,
                pur_itemID INTEGER NOT NULL,
                pur_cusID INTEGER NOT NULL,
                FOREIGN KEY (pur_cusID) REFERENCES customer(customerID)
            );
            """;

        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSampleData() {
        String sql = "INSERT OR IGNORE INTO purchase(purchaseID, purchase_date, totalPrice, pur_itemID, pur_cusID) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 1);
            pstmt.setString(2, "2024-05-01");
            pstmt.setDouble(3, 49.99);
            pstmt.setInt(4, 1001);
            pstmt.setInt(5, 1); // refers to Alice Nguyen
            pstmt.executeUpdate();

            pstmt.setInt(1, 2);
            pstmt.setString(2, "2024-05-03");
            pstmt.setDouble(3, 89.50);
            pstmt.setInt(4, 1002);
            pstmt.setInt(5, 2); // refers to Bob Tran
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Purchase> getAllPurchases() {
        List<Purchase> purchases = new ArrayList<>();
        String sql = "SELECT * FROM purchase";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                purchases.add(new Purchase(
                    rs.getInt("purchaseID"),
                    rs.getString("purchase_date"),
                    rs.getDouble("totalPrice"),
                    rs.getInt("pur_itemID"),
                    rs.getInt("pur_cusID")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchases;
    }
}

