package tdm.miniproject.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import tdm.miniproject.R;
import tdm.miniproject.adapters.OrderAdapter;
import tdm.miniproject.fragments.OrderDetailsFragment;
import tdm.miniproject.fragments.ProductDetailFragment;
import tdm.miniproject.job.Order;
import tdm.miniproject.managers.HttpManager;
import tdm.miniproject.managers.RequestManager;
import tdm.miniproject.managers.UserManager;
import tdm.miniproject.support.GetOrdersResponse;

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
        new GetOrdersTask().execute();
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
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_home);
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
           // intent.putExtra("order",(Order)listView.getAdapter().getItem(position));
            startActivity(intent);
        }else {
            Bundle bundle = new Bundle();
           // bundle.putSerializable("order",(Order)listView.getAdapter().getItem(position));
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

    private void returnToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    public class GetOrdersTask extends AsyncTask<Void,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {

            return new HttpManager().getDataFromServiceURI(RequestManager.getRequestGetOrders());
        }

        @Override
        protected void onPostExecute(String s) {
            GetOrdersResponse getOrdersResponse = new Gson().fromJson(s,GetOrdersResponse.class);
            if(getOrdersResponse.getCode()==1){
                listView.setAdapter(new OrderAdapter(getParent(),(ArrayList<Order>) getOrdersResponse.getOrders()));
            }else{
                Toast.makeText(getApplicationContext(), "Vous devez être connecter !", Toast.LENGTH_SHORT).show();
                UserManager.setDisconnected(getApplicationContext());
                returnToMainActivity();
            }
        }
    }



}
