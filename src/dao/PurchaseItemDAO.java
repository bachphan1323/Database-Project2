package dao;

import model.PurchaseItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseItemDAO {

    public void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS purchase_item (
                purchase_itemID INTEGER PRIMARY KEY,
                quantity INTEGER NOT NULL
            );
            """;

        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSampleData() {
        String sql = "INSERT OR IGNORE INTO purchase_item(purchase_itemID, quantity) VALUES (?, ?)";

        try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 1);
            pstmt.setInt(2, 2); // e.g., 2 items purchased
            pstmt.executeUpdate();

            pstmt.setInt(1, 2);
            pstmt.setInt(2, 5); // e.g., 5 items purchased
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PurchaseItem> getAllPurchaseItems() {
        List<PurchaseItem> items = new ArrayList<>();
        String sql = "SELECT * FROM purchase_item";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                items.add(new PurchaseItem(
                    rs.getInt("purchase_itemID"),
                    rs.getInt("quantity")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}

