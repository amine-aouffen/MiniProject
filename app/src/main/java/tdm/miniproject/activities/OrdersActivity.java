package tdm.miniproject.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import tdm.miniproject.R;
import tdm.miniproject.adapters.OrderAdapter;

public class OrdersActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        initialiseToolBar();
        prepareListView();
    }

    private void prepareListView() {
        listView =(ListView) findViewById(R.id.ordersList);
        listView.setAdapter(new OrderAdapter(this, MainActivity.getOrders()));
    }

    public void initialiseToolBar(){
        Toolbar cartToolbar = (Toolbar) findViewById(R.id.ordersToolBar);
        setSupportActionBar(cartToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_store_white_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_orders, menu);
        return true;
    }
}
