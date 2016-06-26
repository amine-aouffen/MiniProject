package tdm.miniproject.job;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Order implements Serializable{
    private int number;
    private ArrayList<OrderLine> orderLines;
    private double totalCost;
    private OrderStatus status;
    private String date;

    public Order(int number,ArrayList<OrderLine> orderLines) {
        this.orderLines=orderLines;
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

    public double getTotalCost() {
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

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
