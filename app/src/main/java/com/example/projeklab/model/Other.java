package com.example.projeklab.model;

public class Other {
    private int image;
    private String name;
    private String desc;
    private String price;

    public Other(int image, String name, String desc, String price) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
