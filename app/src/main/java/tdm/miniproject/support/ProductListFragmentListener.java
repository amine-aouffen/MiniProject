package tdm.miniproject.support;

import java.io.Serializable;

import tdm.miniproject.job.Product;

/**
 * Created by Home on 29/03/2016.
 */
public interface ProductListFragmentListener extends Serializable {
    void showProductDetails(Product product);
}
