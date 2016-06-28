package tdm.miniproject.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import tdm.miniproject.R;
import tdm.miniproject.adapters.CartAdapter;
import tdm.miniproject.adapters.CartAdapter.QuantityHandler;
import tdm.miniproject.job.Cart;
import tdm.miniproject.job.Order;
import tdm.miniproject.managers.CartManager;
import tdm.miniproject.managers.HttpManager;
import tdm.miniproject.managers.OrderManager;
import tdm.miniproject.managers.RequestManager;
import tdm.miniproject.managers.UserManager;
import tdm.miniproject.support.CartElement;
import tdm.miniproject.support.CartOperationRequest;
import tdm.miniproject.support.OrderResponse;
import tdm.miniproject.taches.AddToCartTask;

public class CartActivity extends AppCompatActivity {
    final private int LOGIN_REQUEST = 1;
    private ListView listView;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        initialiseToolBar();
        prepareListView();
    }

    private void prepareListView() {
        listView = (ListView) findViewById(R.id.cartList);
        Cart cart=  CartManager.getCart(this);
        if(cart!=null){
            CartAdapter cartAdapter = new CartAdapter(this,cart);
            listView.setAdapter(cartAdapter);
        }

    }

    public void initialiseToolBar() {
        Toolbar cartToolbar = (Toolbar) findViewById(R.id.chartToolBar);
        setSupportActionBar(cartToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cart, menu);
        return true;
    }


    public void validateOrder(MenuItem item) {
        validateOrderRequest();
    }

    public void showLoginActivity() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }


    public void cleanCart(MenuItem item) {
        Cart cart = CartManager.getCart(this);
        if(cart!=null){
            for(int i=0;i<cart.getElementsList().size();i++){
                CartElement cartElement = cart.getCartElement(i);
                CartOperationRequest cartOperationRequest = new CartOperationRequest();
                cartOperationRequest.setProductName(cartElement.getProduct().getName());
                cartOperationRequest.setQuantity(cartElement.getQuantity());
                cartOperationRequest.setSize(cartElement.getSize());
                cartOperationRequest.setType("MATH_OPERATION");
                new AddToCartTask(this,cartElement.getProduct(),cartElement.getSize(),cartElement.getQuantity(),null).execute(cartOperationRequest);
            }
        }
    }

    public void updateListAfterDeleteCart(){
        listView.setAdapter(new CartAdapter(this,new Cart()));
    }
/*

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOGIN_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                if (MainActivity.connect(data.getStringExtra("user"), data.getStringExtra("pass"))) {
                    //connected
                    validateOrder();
                } else {
                    //False password
                    Toast.makeText(CartActivity.this, "Nom d'utilisateur/Mot de passe incorrect", Toast.LENGTH_SHORT).show();
                    showLoginActivity();
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Authentification canceled
            }
        }
    }
*/

    private void validateOrderRequest() {
        if(UserManager.isConnected(this)){
            validateOrder();
        }else{
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }


    }

    private void validateOrder() {
        Order order = OrderManager.createOrderFromCurentCart(this);
        new ValidateOrderTask().execute(order);
    }

    public void showAddition(MenuItem item) {
        //TODO calcule du montant total du chariot
    }

    public void showOrdersActivity(MenuItem item) {
        Intent intent = new Intent(this,OrdersActivity.class);
        startActivity(intent);
    }

    public class ValidateOrderTask extends AsyncTask<Order,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Order... params) {
            String data = new Gson().toJson(params[0],Order.class);
            return new HttpManager()
                    .postDataToServiceURI(RequestManager.getRequestValidateOrders(),data);
        }

        @Override
        protected void onPostExecute(String s) {
            OrderResponse orderResponse = new Gson().fromJson(s,OrderResponse.class);
            if(orderResponse.getCode()==1){
                //Commande validé avec succès
                Toast.makeText(getParent(), "Commande n° "+orderResponse.getOrderId()+" validée avec succès", Toast.LENGTH_SHORT).show();
                CartManager.deleteCart(getParent());
                updateListAfterDeleteCart();
                //TODO redirect to order activity
            }else{
                Toast.makeText(getApplicationContext(), "Commande non validé, réesayez plus tard!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
