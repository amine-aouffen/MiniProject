package tdm.miniproject.handlers;

import android.content.Context;

import tdm.miniproject.job.Product;
import tdm.miniproject.managers.CartManager;
import tdm.miniproject.support.CartElement;
import tdm.miniproject.support.CartOperationsListener;

/**
 * Created by amine on 26/06/2016.
 */
public class CartHandler implements CartOperationsListener{
    Context context;

    public CartHandler(Context context) {
        this.context = context;
    }

    public void addProductToCart(Product product, String size,int quantity) {
        CartManager.addProductToCart(context,product,size,quantity);
        //TODO execute the alarm (4hours)
    }

}
