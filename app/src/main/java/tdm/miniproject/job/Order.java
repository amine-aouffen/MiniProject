package tdm.miniproject.job;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Order implements Serializable{
    private int number;
    private Cart cart;
    private float totalCost;
    private OrderStatus status;
    private String date;

    public Order(Cart cart,int number) {
        this.cart = cart;
        totalCost=cart.getTotalCost();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy_HH:mm");
        date=sdf.format(new Date());
        status=OrderStatus.ON_PREPARATION;
        this.number=number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
