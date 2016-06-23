package com.mshop.backend.Util;

import com.mshop.backend.Util.JsonResponse;

/**
 * Created by Dell on 23/06/2016.
 */
public class OrderJsonResponse extends JsonResponse {

    private int orderId;
    private String state;

    public OrderJsonResponse(int code, String description, int orderId) {
        super(code, description);
        this.orderId = orderId;
    }

    public OrderJsonResponse(int code, String description, int orderId, String state) {
        super(code, description);
        this.orderId = orderId;
        this.state = state;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
