package tdm.miniproject.job;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Order {
    private Cart cart;
    private float totalCost;
    private OrderStatus status;
    private String date;

    public Order(Cart cart) {
        this.cart = cart;
        totalCost=cart.getTotalCost();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy_HH:mm");
        date=sdf.format(new Date());
        status=OrderStatus.ON_PREPARATION;
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
