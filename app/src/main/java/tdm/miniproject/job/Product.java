package tdm.miniproject.job;

import java.io.Serializable;

public class Product implements Serializable{
    private String name;
    private float price;
    private String description;
    private int productPhoto;
    private Consumer consumer;
    private String caracteristics;

    public Product( String name, float price, String description, int productPhoto, Consumer consumer,String caracteristics) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productPhoto = productPhoto;
        this.consumer = consumer;
        this.caracteristics=caracteristics;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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
}
