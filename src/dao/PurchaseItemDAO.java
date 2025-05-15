package dao;

import model.PurchaseItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseItemDAO {

    public void createTable() {
        String drop = "DROP TABLE IF EXISTS purchase_item";
        String sql = """
            CREATE TABLE IF NOT EXISTS purchase_item (
                purchase_itemID INTEGER,
                product_itemID INTEGER,
                quantity INTEGER NOT NULL,
                PRIMARY KEY (purchase_itemID, product_itemID),
                FOREIGN KEY (purchase_itemID) REFERENCES purchase(purchaseID),
                FOREIGN KEY (product_itemID) REFERENCES product(productID)
            );
            """;

        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(drop);  
            stmt.execute(sql);   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertSampleData() {
        // Optional: Clear the table before inserting sample data (for clean testing)
        String clearSql = "DELETE FROM purchase_item";

        String sql = "INSERT OR IGNORE INTO purchase_item(purchase_itemID, product_itemID, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            stmt.executeUpdate(clearSql); // comment this out if you want persistent data

            pstmt.setInt(1, 1); // purchaseID
            pstmt.setInt(2, 1); // productID
            pstmt.setInt(3, 2); // quantity
            pstmt.executeUpdate();

            pstmt.setInt(1, 1); // purchaseID
            pstmt.setInt(2, 2); // productID
            pstmt.setInt(3, 1); // quantity
            pstmt.executeUpdate();

            pstmt.setInt(1, 2); // purchaseID
            pstmt.setInt(2, 1); // productID
            pstmt.setInt(3, 3); // quantity
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
                    rs.getInt("product_itemID"),
                    rs.getInt("quantity")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}
