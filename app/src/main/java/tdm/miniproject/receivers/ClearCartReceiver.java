package tdm.miniproject.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import tdm.miniproject.job.Cart;
import tdm.miniproject.managers.CartManager;
import tdm.miniproject.support.CartElement;
import tdm.miniproject.support.CartOperationRequest;
import tdm.miniproject.taches.AddToCartTask;

/**
 * Created by amine on 27/06/2016.
 */
public class ClearCartReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Cart cart = CartManager.getCart(context);
        if(cart!=null){
            for(int i=0;i<cart.getElementsList().size();i++){
                CartElement cartElement = cart.getCartElement(i);
                CartOperationRequest cartOperationRequest = new CartOperationRequest();
                cartOperationRequest.setProductName(cartElement.getProduct().getName());
                cartOperationRequest.setQuantity(cartElement.getQuantity());
                cartOperationRequest.setSize(cartElement.getSize());
                cartOperationRequest.setType("MATH_OPERATION");
                new AddToCartTask(context,cartElement.getProduct(),cartElement.getSize(),cartElement.getQuantity(),null).execute(cartOperationRequest);
            }
        }
        Toast.makeText(context, "Le chariot est utilisé depuis 4h !", Toast.LENGTH_SHORT).show();
    }
}
