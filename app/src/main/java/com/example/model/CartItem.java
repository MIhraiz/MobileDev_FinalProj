package com.example.model;

public class CartItem {
    private String name;
    private String price;
    private int imageID;

    public CartItem() {
    }

    public CartItem(String name, String price, int imageID) {
        this.name = name;
        this.price = price;
        this.imageID = imageID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", imageID=" + imageID +
                '}';
    }
}
