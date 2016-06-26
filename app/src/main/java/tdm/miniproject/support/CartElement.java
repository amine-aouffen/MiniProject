package tdm.miniproject.support;

import java.io.Serializable;

import tdm.miniproject.job.Product;

/**
 * Created by Home on 27/03/2016.
 */
public class CartElement implements Serializable{
    private Product product;
    String size;
    private int quantity;

    public CartElement(Product product,String size) {
        this.product = product;
        this.quantity = 1;
        this.size=size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incQunatity(){
        quantity++;
    }

    public void decQuantity(){
        if (quantity>1){
            quantity--;
        }
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
