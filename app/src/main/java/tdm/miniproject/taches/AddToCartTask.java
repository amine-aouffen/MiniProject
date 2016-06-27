package tdm.miniproject.taches;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import tdm.miniproject.activities.CartActivity;
import tdm.miniproject.activities.SizeQuantityChooser;
import tdm.miniproject.job.Product;
import tdm.miniproject.managers.CartManager;
import tdm.miniproject.managers.HttpManager;
import tdm.miniproject.managers.RequestManager;
import tdm.miniproject.support.CartOperationRequest;
import tdm.miniproject.support.CartOperationResponse;
import tdm.miniproject.adapters.CartAdapter.QuantityHandler;

public class AddToCartTask extends AsyncTask<CartOperationRequest,Void,String> {
    private Context context;
    private String size;
    private int quantity;
    private Product product;
    private QuantityHandler quantityHandler;
    public AddToCartTask(Context context, Product product,String size, int quantity,QuantityHandler quantityHandler) {
        this.context = context;
        this.size=size;
        this.quantity=quantity;
        this.product=product;
        this.quantityHandler = quantityHandler;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(CartOperationRequest... params) {
        String json = new Gson().toJson(params[0],CartOperationRequest.class);
        Log.d("REEQ",json);
        String result = new HttpManager().postDataToServiceURI(RequestManager.getRequestCartCheck(),json);
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("Repoo",s);
        CartOperationResponse response = new Gson().fromJson(s,CartOperationResponse.class);
        if(response.getCode()==-1){
            Toast.makeText(context, "Quantité non disponible !", Toast.LENGTH_SHORT).show();
        }else{
            CartManager.addProductToCart(context,this.product,size,quantity);
            if(context instanceof SizeQuantityChooser){
                ((AppCompatActivity)context).finish();
                Toast.makeText(context,"Produit ajouté au chariot !", Toast.LENGTH_SHORT).show();
            }else{
                if(quantityHandler==null){
                    CartManager.deleteCart(context);
                    if(context instanceof CartActivity)((CartActivity)context).updateListAfterDeleteCart();
                    Toast.makeText(context, "Le chariot a été vidé !", Toast.LENGTH_SHORT).show();
                }else {
                    int q = 0;

                    if (response.getDescription().equals("substraction") && quantityHandler.getType() == QuantityHandler.INCDEC) {
                        q = CartManager.incProductQuantity(context, product.getName(),size);
                        Toast.makeText(context, "Quantité incrémenté par un !", Toast.LENGTH_SHORT).show();
                    } else if (response.getDescription().equals("addition") && quantityHandler.getType() == QuantityHandler.INCDEC) {
                        q = CartManager.decProductQuantity(context, product.getName(),size);
                        Toast.makeText(context, "Quantité décrémenté par un !", Toast.LENGTH_SHORT).show();
                    }
                    quantityHandler.doPostWork(product.getName(),size, q + "");
                }
            }
        }

    }
}