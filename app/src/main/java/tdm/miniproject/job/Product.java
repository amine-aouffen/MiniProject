package tdm.miniproject.job;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Product implements Serializable{
    private String name;
    private double price;
    private String description;
    private int productPhoto;
    private Consumer consumer;
    private String caracteristics;
    private String preferenceName;
    private Set<String> preferences;



    public Product() {

    }

    public Product(String name, float price, String description, int productPhoto, Consumer consumer, String caracteristics) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productPhoto = productPhoto;
        this.consumer = consumer;
        this.caracteristics=caracteristics;
        this.preferenceName = "Taille";
        this.preferences= new TreeSet<>();
        preferences.add("Small");
        preferences.add("Medium");
        preferences.add("Large");
        preferences.add("X-Large");
        preferences.add("XX-Large");


    }    public Product( String name, float price, String description, int productPhoto, Consumer consumer) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productPhoto = productPhoto;
        this.consumer = consumer;

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

    public int getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(int productPhoto) {
        this.productPhoto = productPhoto;
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

    public String getPreferenceName() {
        return preferenceName;
    }

    public void setPreferenceName(String preferenceName) {
        this.preferenceName = preferenceName;
    }

    public Set<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<String> preferences) {
        this.preferences = preferences;
    }


}
