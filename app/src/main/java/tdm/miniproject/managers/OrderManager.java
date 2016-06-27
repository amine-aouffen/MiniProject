package tdm.miniproject.managers;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tdm.miniproject.job.Cart;
import tdm.miniproject.job.Order;
import tdm.miniproject.job.OrderLine;
import tdm.miniproject.support.CartElement;

/**
 * Created by amine on 27/06/2016.
 */
public class OrderManager {
    public static Order createOrderFromCurentCart(Context context){
        Order order = new Order();
        //order.setId();
        //order.setIdClient();
        //order.setOrderDate();
        //order.setPrice();
        //order.setState();
        List<OrderLine> orderLines = new ArrayList<>();
        Cart cart = CartManager.getCart(context);
        for(int i =0;i<cart.getElementsList().size();i++){
            CartElement cartElement = cart.getCartElement(i);
            OrderLine orderLine = new OrderLine();
            orderLine.setProductName(cartElement.getProduct().getName());
            orderLine.setQuantity(cartElement.getQuantity());
            orderLine.setLigneNumber(i);
            orderLine.setUnitPrice(cartElement.getProduct().getPrice());
            //orderLine.setOrderID();
            orderLines.add(orderLine);
        }
        order.setOrderLines(orderLines);
        return order;
    }
}
