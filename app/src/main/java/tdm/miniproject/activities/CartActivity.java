package tdm.miniproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import tdm.miniproject.R;
import tdm.miniproject.adapters.CartAdapter;
import tdm.miniproject.job.Cart;
import tdm.miniproject.job.Order;

public class CartActivity extends AppCompatActivity {
    final private int LOGIN_REQUEST = 1;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        initialiseToolBar();
        prepareListView();
    }

    private void prepareListView() {
        listView = (ListView) findViewById(R.id.cartList);
        //listView.setAdapter(new CartAdapter(this, MainActivity.getCart()));
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
        //TODO remove the line below after debug to request user auth
        if (true) {
            validateOrder();
        } else {
            showLoginActivity();
        }

    }

    public void showLoginActivity() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    public void cleanCart() {
    }

    public void cleanCart(MenuItem item) {
        cleanCart();
        Toast.makeText(CartActivity.this, "Chariot a été supprimé avec succés", Toast.LENGTH_SHORT).show();
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

    private void validateOrder() {
        Toast.makeText(CartActivity.this, "la commande à été validé", Toast.LENGTH_SHORT).show();
        //MainActivity.getOrders().add(new Order(MainActivity.getCart(),MainActivity.getOrders().size()+1));
        cleanCart();
    }

    public void showAddition(MenuItem item) {
        //TODO calcule du montant total du chariot
    }

    public void showOrdersActivity(MenuItem item) {
        Intent intent = new Intent(this,OrdersActivity.class);
        startActivity(intent);
    }
}
