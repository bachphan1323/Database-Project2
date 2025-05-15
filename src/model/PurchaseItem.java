package model;

public class PurchaseItem {
    private int purchase_itemID; // foreign key to Purchase 
    private int product_itemID; //  foreign key to Product
    private int quantity;

    public PurchaseItem(int purchase_itemID, int product_itemID, int quantity) {
        this.purchase_itemID = purchase_itemID;
        this.product_itemID = product_itemID;
        this.quantity = quantity;
    }

    public int getPurchase_itemID() {
        return purchase_itemID;
    }
    public int getProduct_itemID() {
        return product_itemID;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setPurchase_itemID(int purchase_itemID) {
        this.purchase_itemID = purchase_itemID;
    }
    public void setProduct_itemID(int product_itemID) {
        this.product_itemID = product_itemID;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
