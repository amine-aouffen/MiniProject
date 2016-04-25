package tdm.miniproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import tdm.miniproject.R;
import tdm.miniproject.adapters.OrderAdapter;
import tdm.miniproject.fragments.OrderDetailsFragment;
import tdm.miniproject.fragments.ProductDetailFragment;
import tdm.miniproject.job.Order;

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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showOrder(position);
            }
        });
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

    public void showOrder(int position){
        if(!isTwoPanes()){
            Intent intent = new Intent(this,OrderDetailsActivity.class);
            intent.putExtra("order",(Order)listView.getAdapter().getItem(position));
            startActivity(intent);
        }else {
            Bundle bundle = new Bundle();
            bundle.putSerializable("order",(Order)listView.getAdapter().getItem(position));
            OrderDetailsFragment fragment = new OrderDetailsFragment();
            fragment.setArguments(bundle);
            FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
            fragTransaction.replace(R.id.twoPanesFragment,fragment);
            fragTransaction.commit();
        }
    }
    boolean isTwoPanes(){
        if(findViewById(R.id.twoPanesFragment)==null){
            return false;
        }
        return true;
    }
}
