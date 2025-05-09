package dao;
import model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {
    public void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS customer (
                customerID INTEGER PRIMARY KEY,
                cname TEXT NOT NULL,
                email TEXT UNIQUE NOT NULL,
                phone_num TEXT NOT NULL
            );
            """;
        
        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public void insertSampleData() {
        String sql = "INSERT OR IGNORE INTO customer(customerID, cname, email, phone_num) VALUES(?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 1);
            pstmt.setString(2, "Alice Nguyen");
            pstmt.setString(3, "alice@example.com");
            pstmt.setString(4, "123-456-7890");
            pstmt.executeUpdate();
    
            pstmt.setInt(1, 2);
            pstmt.setString(2, "Bob Tran");
            pstmt.setString(3, "bob@example.com");
            pstmt.setString(4, "987-654-3210");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";
    
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
    
            while (rs.next()) {
                customers.add(new Customer(
                    rs.getInt("customerID"),
                    rs.getString("cname"),
                    rs.getString("email"),
                    rs.getString("phone_num")
                ));
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return customers;
    }
    
    
}
