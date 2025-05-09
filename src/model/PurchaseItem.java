package model;

public class PurchaseItem {
    private int purchase_itemID;
    private int quantity;

    public PurchaseItem(int purchase_itemID, int quantity) {
        this.purchase_itemID = purchase_itemID;
        this.quantity = quantity;
    }

    public int getPurchase_itemID() {
        return purchase_itemID;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setPurchase_itemID(int purchase_itemID) {
        this.purchase_itemID = purchase_itemID;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
