package tdm.miniproject.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import com.google.gson.Gson;

import tdm.miniproject.job.Cart;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.CartElement;

/**
 * Created by amine on 26/06/2016.
 */
public class CartManager {
    public static final String spName="cartFile";
    public static final String cartName="cart";


    public static Cart getCart(Context context){
        SharedPreferences sp=context.getSharedPreferences(spName,Context.MODE_PRIVATE);
        if(sp!=null) {
            String cartJSON = sp.getString(cartName,"");
            if (cartJSON != "") {
                Log.d("JSONCART",cartJSON);
                Cart cart = new Gson().fromJson(cartJSON, Cart.class);
                return cart;
            } else {
                return null;
            }
        }else{
            return null;
        }
    }
    public static void addProductToCart(Context context, Product product, String size){

        Cart cart = CartManager.getCart(context);
        if(cart==null)cart = new Cart();
        cart.add(new CartElement(product,size));

        saveCart(context, cart);

    }

    public static void deleteProductFromCart(Context context,int position){

        Cart cart = CartManager.getCart(context);
        if(cart!=null){
            cart.removeCartElement(position);
            saveCart(context, cart);
        }




    }

    private static void saveCart(Context context, Cart cart) {
        SharedPreferences sp=context.getSharedPreferences(spName,Context.MODE_PRIVATE);
        if(sp!=null){
            Editor editor = sp.edit();
            editor.putString(cartName,new Gson().toJson(cart));
            editor.commit();
        }
    }

    public static void incProductQuantity(Context context, int position) {
        Cart cart = CartManager.getCart(context);
        if (cart != null) {
            cart.getCartElement(position).incQunatity();
            saveCart(context, cart);

        }
    }

    public static void decProductQuantity(Context context, int position) {
        Cart cart = CartManager.getCart(context);
        if (cart != null) {
            cart.getCartElement(position).decQuantity();
            saveCart(context, cart);

        }
    }


}
