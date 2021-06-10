package com.example.myproj.model;

public class Sport {
    private String name ;
    private String description;
    private String rate;
    private String price ;
    private int ImageId;

    public Sport() {
    }

    public Sport(String name, String description, String rate, String price, int imageId) {
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.price = price;
        ImageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }
    public String getEmoji(int uni) {
        return new String(Character.toChars(uni));
    }


    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rate='" + rate + '\'' +
                ", price='" + price + '\'' +
                ", ImageId=" + ImageId +
                '}';
    }
}
