package tdm.miniproject.job;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Product implements Serializable{
    private String name;
    private double price;
    private String description;
    private String photo;
    private Consumer consumer;
    private String caracteristics;

    public Product() {
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
