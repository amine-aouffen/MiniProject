package tdm.miniproject.activities;

import tdm.miniproject.R;
import tdm.miniproject.adapters.CartAdapter;
import tdm.miniproject.adapters.CategoryAdapter;
import tdm.miniproject.job.Product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        initialiseToolBar();
        listView =(ListView) findViewById(R.id.cartList);
        CartAdapter cartAdapter = new CartAdapter(this,MainActivity.getCart());
        listView.setAdapter(cartAdapter);


    }

    public void initialiseToolBar(){
        Toolbar cartToolbar = (Toolbar) findViewById(R.id.chartToolBar);
        setSupportActionBar(cartToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Icon getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_favorite_black);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cart, menu);
        return true;
    }


}
