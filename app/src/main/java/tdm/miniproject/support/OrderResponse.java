package tdm.miniproject.support;

/**
 * Created by Dell on 23/06/2016.
 */
public class OrderResponse extends GeneralResponse {

    private int orderId;
    private String state;

    public OrderResponse(int code, String description, int orderId) {
        super(code, description);
        this.orderId = orderId;
    }

    public OrderResponse(int code, String description, int orderId, String state) {
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
