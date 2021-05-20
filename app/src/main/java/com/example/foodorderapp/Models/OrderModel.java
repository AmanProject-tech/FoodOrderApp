package com.example.foodorderapp.Models;

public class OrderModel {
    int orderImage;
    String ItemName, price, orderNumber;

    public OrderModel(int orderImage, String itemName, String price, String orderNumber) {
        this.orderImage = orderImage;
        ItemName = itemName;
        this.price = price;
        this.orderNumber = orderNumber;
    }

    public OrderModel() {

    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
