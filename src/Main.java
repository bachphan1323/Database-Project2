import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.DBConnection;
import dao.PurchaseDAO;
import dao.PurchaseItemDAO;
import dao.CustomerDAO;
import dao.ProductDAO;

import model.Customer;
import model.Purchase;
import model.PurchaseItem;
import model.Product;

public class Main {
    public static void main(String[]args) {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.createTable();
        customerDAO.insertSampleData();

        PurchaseDAO purchaseDAO = new PurchaseDAO();
        purchaseDAO.createTable();
        purchaseDAO.insertSampleData();

        ProductDAO productDAO = new ProductDAO();
        productDAO.createTable();
        productDAO.insertSampleData();

        PurchaseItemDAO purchaseItemDAO = new PurchaseItemDAO();
        purchaseItemDAO.createTable();
        purchaseItemDAO.insertSampleData();

        List<Customer> customers = customerDAO.getAllCustomers();
        for (Customer c : customers) {
            System.out.printf("ID: %d | Name: %s | Email: %s | Phone: %s%n",
                c.getCustomerID(), c.getCname(), c.getEmail(), c.getPhone_num());
        }

        List<Purchase> purchases = purchaseDAO.getAllPurchases();
        System.out.println("\n--- Purchases ---");
        for (Purchase p : purchases) {
            System.out.printf("ID: %d | Date: %s | Total: %.2f",
                p.getPurchaseID(), p.getPurchase_date(), p.getTotalPrice());
        }

        System.out.println("\n--- Products ---");
        List<Product> products = productDAO.getAllProducts();
        for (Product p : products) {
            System.out.printf("ID: %d | Name: %s | Price: %d | Stock: %d",
                p.getProductID(), p.getProd_name(), p.getProd_price(), p.getStock_quantity());
        }

        System.out.println("\n--- Purchase Items ---");
        List<PurchaseItem> items = purchaseItemDAO.getAllPurchaseItems();
        for (PurchaseItem item : items) {
            System.out.printf("Item ID: %d | Quantity: %d%n", item.getPurchase_itemID(), item.getQuantity());
        }
    }
}