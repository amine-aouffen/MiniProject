package com.mshop.backend.model;

/**
 * Created by Dell on 22/06/2016.
 */
public class OrderLine {

    private int ligneNumber;
    private String productName;
    private int quantity;
    private double unitPrice;
    private int orderID;

    public int getLigneNumber() {
        return ligneNumber;
    }

    public void setLigneNumber(int ligneNumber) {
        this.ligneNumber = ligneNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
