package model;

public class Purchase {
    private int purchaseID;
    private String purchase_date;
    private double totalPrice;
    private int pur_itemID;
    private int pur_cusID; 

    public Purchase(int purchaseID, String purchase_date, double totalPrice, int pur_itemID, int pur_cusID) {
        this.purchaseID = purchaseID;
        this.purchase_date = purchase_date;
        this.totalPrice = totalPrice;
        this.pur_itemID = pur_itemID;
        this.pur_cusID = pur_cusID;
    }

    public int getPurchaseID() {
        return purchaseID;
    }
    public String getPurchase_date() {
        return purchase_date;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getPur_itemID() {
        return pur_itemID;
    }
    public int getPur_cusID() {
        return pur_cusID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }
    public void setPurchase_date(String purchase_date) {
        this.purchase_date = purchase_date;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setPur_itemID(int pur_itemID) {
        this.pur_itemID = pur_itemID;
    }
    public void setPur_cusID(int pur_cusID) {
        this.pur_cusID = pur_cusID;
    }
}
