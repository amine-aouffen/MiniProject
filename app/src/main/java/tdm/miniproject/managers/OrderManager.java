package tdm.miniproject.managers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import tdm.miniproject.job.Cart;
import tdm.miniproject.job.Order;
import tdm.miniproject.job.OrderLine;
import tdm.miniproject.job.Product;
import tdm.miniproject.receivers.ClearCartReceiver;
import tdm.miniproject.support.CartElement;

/**
 * Created by amine on 27/06/2016.
 */
public class OrderManager {
    public static final String spName="orderFile";
    public static final String ordersIdListName="orderIds";

    public static Order createOrderFromCurentCart(Context context){
        Order order = new Order();
        List<OrderLine> orderLines = new ArrayList<>();
        Cart cart = CartManager.getCart(context);
        //order.setId();
        //order.setIdClient();
        //order.setOrderDate();
        order.setPrice(cart.getTotalCost());
        //order.setState();
        for(int i =0;i<cart.getElementsList().size();i++){
            CartElement cartElement = cart.getCartElement(i);
            OrderLine orderLine = new OrderLine();
            orderLine.setProductName(cartElement.getProduct().getName());
            orderLine.setQuantity(cartElement.getQuantity());
            orderLine.setLigneNumber(i);
            orderLine.setUnitPrice(cartElement.getProduct().getPrice());
            orderLine.setSize(cartElement.getSize());
            orderLines.add(orderLine);
        }
        order.setOrderLines(orderLines);
        return order;
    }

}
