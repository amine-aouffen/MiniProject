package com.mshop.backend.model;

public class Product {

    private String name;
    private double price;
    private String description;

    private Consumer consumer;
    private String caracteristics;
    private Category category;
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public String getCaracteristics() {
        return caracteristics;
    }

    public void setCaracteristics(String caracteristics) {
        this.caracteristics = caracteristics;
    }
}
