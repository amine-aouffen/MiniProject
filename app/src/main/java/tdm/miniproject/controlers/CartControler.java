package tdm.miniproject.controlers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import tdm.miniproject.activities.MainActivity;
import tdm.miniproject.activities.PreferenceChooser;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.CartElement;

/**
 * Created by amine on 07/05/2016.
 */
public class CartControler {
    private static final int PREFERENCE_CHOOSE_REQUEST=1;
    public static void addProductToCart(Context context, Product product) {
        //TODO uncomment these 3 lines to show size choice window
//        Intent intent = new Intent(context,PreferenceChooser.class);
//        intent.putExtra("product",product);
//        ((AppCompatActivity)context).startActivityForResult(intent,PREFERENCE_CHOOSE_REQUEST);
        CartElement cartElement = new CartElement(product);
        int q = MainActivity.getCart().add(cartElement);
        if (q==1){
            Toast.makeText(context, "Produit ajouté au chariot", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Produit existant, quantité incrémentée "+q, Toast.LENGTH_SHORT).show();
        }
    }
}
