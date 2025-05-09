package model;

public class Product {
    private int productID;
    private int prod_itemID;
    private String prod_name;
    private int prod_price;
    private int stock_quantity;

    public Product(int productID, String prod_name, int prod_price, int stock_quantity, int prod_itemID) {
        this.productID = productID;
        this.prod_name = prod_name;
        this.prod_price = prod_price;
        this.stock_quantity = stock_quantity;
        this.prod_itemID = prod_itemID;
    }

    public int getProductID() {
        return productID;
    }
    public int getProd_itemID() {
        return prod_itemID;
    }
    public String getProd_name() {
        return prod_name;
    }
    public int getProd_price() {
        return prod_price;
    }
    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    public void setProd_itemID(int prod_itemID) {
        this.prod_itemID = prod_itemID;
    }
    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }
    public void setProd_price(int prod_price) {
        this.prod_price = prod_price;
    }
    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

}
