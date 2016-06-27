package com.mshop.backend.Util;

import com.mshop.backend.model.Order;

import java.util.List;

/**
 * Created by Salah on 27/06/2016.
 */
public class getOrdersResponse extends GeneralResponse {
    private List<Order> orders;

    public getOrdersResponse(int code, String description, List<Order> orders) {
        super(code, description);
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
