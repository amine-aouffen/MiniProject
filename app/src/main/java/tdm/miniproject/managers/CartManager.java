package tdm.miniproject.managers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import tdm.miniproject.job.Cart;
import tdm.miniproject.job.Product;
import tdm.miniproject.receivers.ClearCartReceiver;
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
                Cart cart = new Gson().fromJson(cartJSON, Cart.class);
                return cart;
            } else {
                return null;
            }
        }else{
            return null;
        }
    }
    public static void addProductToCart(Context context, Product product, String size,int quantity){
        Cart cart = CartManager.getCart(context);
        if(cart==null){
            cart = new Cart();
            //Lancement de l'alarm (durée de validation du chariot est 4 heures
            TasksManager.setClearCartAlarm(context,20);
        }
        cart.add(new CartElement(product,size,quantity));
        saveCart(context, cart);

    }

        public static void deleteProductFromCart(Context context, String productName,String size) {
            Cart cart = CartManager.getCart(context);
            if (cart != null) {
                cart.removeCartElement(productName,size);
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


    public static int incProductQuantity(Context context, String productName,String size) {
        Cart cart = CartManager.getCart(context);
        if (cart != null) {
            boolean found = false;
            int i = cart.getElementsList().size();
            while (i > 0 && !found) {
                i--;
                if (cart.getCartElement(i).getProduct().getName().equals(productName)
                        &&cart.getCartElement(i).getSize().equals(size)) {
                    found = true;
                    cart.getCartElement(i).incQunatity();

                }
            }
            if (found) {
                saveCart(context, cart);
                return cart.getCartElement(i).getQuantity();
            } else {
                return 0;
            }

        }else return 0;
    }



    public static int decProductQuantity(Context context, String productName,String size) {
        Cart cart = CartManager.getCart(context);
        if (cart != null) {
            boolean found = false;
            int i = cart.getElementsList().size();
            while (i > 0 && !found) {
                i--;
                if (cart.getCartElement(i).getProduct().getName().equals(productName)
                        &&cart.getCartElement(i).getSize().equals(size)) {
                    found = true;
                    cart.getCartElement(i).decQuantity();

                }
            }
            if (found) {
                saveCart(context, cart);
                return cart.getCartElement(i).getQuantity();
            } else {
                return 0;
            }

        }else return 0;
    }

    public static void deleteCart(Context context){
        saveCart(context,null);
    }

}
