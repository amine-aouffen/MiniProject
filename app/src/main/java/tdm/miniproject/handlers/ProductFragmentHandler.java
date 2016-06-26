package tdm.miniproject.handlers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import tdm.miniproject.R;

import tdm.miniproject.activities.ProductDetailActivity;
import tdm.miniproject.fragments.ProductDetailFragment;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.CartElement;
import tdm.miniproject.support.ProductListFragmentListener;

/**
 * Created by amine on 25/06/2016.
 */
public class ProductFragmentHandler implements ProductListFragmentListener{
    Context context;
    AppCompatActivity activity;
    int idResFragmentForReplace;

    public ProductFragmentHandler(Context context,int idResFragmentForReplace) {
        this.context = context;
        activity = (AppCompatActivity)context;
        this.idResFragmentForReplace=idResFragmentForReplace;
    }

    @Override
    public void showProductDetails(Product product) {
        if(!isTwoPanes()) {
            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("product", product);
            activity.startActivity(intent);
        }else{
            showProductDetailsInFrag(product);
        }
    }

    public void addProductToCart(Product product) {
        //TODO uncomment these 3 lines to show size choice window
//        Intent intent = new Intent(context,PreferenceChooser.class);
//        intent.putExtra("product",product);
//        activity.startActivityForResult(intent,PREFERENCE_CHOOSE_REQUEST);
        CartElement cartElement = new CartElement(product);
        //TODO add the product to local cart and execute the alarm (4hours)
    }

    boolean isTwoPanes(){
        if((activity.findViewById(idResFragmentForReplace)==null)){
            return false;
        }
        return true;
    }

    private void showProductDetailsInFrag(Product product) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", product);
        ProductDetailFragment fragment = new ProductDetailFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(idResFragmentForReplace,fragment);
        fragTransaction.commit();
    }
}
