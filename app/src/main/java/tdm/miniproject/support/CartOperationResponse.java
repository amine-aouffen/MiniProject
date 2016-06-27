package tdm.miniproject.support;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 25/06/2016.
 */
public class CartOperationResponse extends GeneralResponse {

    private String type;
    private String productName;
    private List<String> sizes = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }
}
