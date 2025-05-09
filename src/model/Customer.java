package model;

public class Customer {
    private int customerID;
    private String cname;
    private String email;
    private String phone_num;

    public Customer(int customerID, String cname, String email, String phone_num) {
        this.customerID = customerID;
        this.cname = cname;
        this.email = email;
        this.phone_num = phone_num;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCname() {
        return cname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
}
