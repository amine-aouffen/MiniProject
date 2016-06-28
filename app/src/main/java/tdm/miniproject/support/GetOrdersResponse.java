package tdm.miniproject.support;



import java.util.List;

import tdm.miniproject.job.Order;

/**
 * Created by Salah on 27/06/2016.
 */
public class GetOrdersResponse extends GeneralResponse {
    private List<Order> orders;

    public GetOrdersResponse(int code, String description, List<Order> orders) {
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
