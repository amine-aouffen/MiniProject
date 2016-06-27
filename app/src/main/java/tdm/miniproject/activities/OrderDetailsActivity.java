package tdm.miniproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import tdm.miniproject.R;
import tdm.miniproject.adapters.OrderDetailsAdapter;
import tdm.miniproject.job.Order;


public class OrderDetailsActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        initialiseToolBar();
        prepareViews();

    }

    public void initialiseToolBar(){
        Toolbar detailToolbar = (Toolbar) findViewById(R.id.orderDetailToolBar);
        setSupportActionBar(detailToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_home);

    }

    public void prepareViews(){
        listView = (ListView) findViewById(R.id.orderDetailsList);
        Intent intent = getIntent();
        Order order = (Order) intent.getSerializableExtra("order");
        OrderDetailsAdapter adapter = new OrderDetailsAdapter(this,order);
        listView.setAdapter(adapter);
        TextView titleTxtView=(TextView)findViewById(R.id.orderItemTitle);
        titleTxtView.setText("Commande n°"+order.getId());
        TextView dateTxtView=(TextView)findViewById(R.id.orderItemDate);
        dateTxtView.setText(order.getOrderDate().toString());
        TextView totalTxtView=(TextView)findViewById(R.id.orderItemTotal);
        totalTxtView.setText(order.getPrice()+" DA");
        TextView statusTxtView=(TextView)findViewById(R.id.orderItemStatus);
        ImageView statusIcon = (ImageView)findViewById(R.id.orderItemStatusIcon);
        switch (order.getState()){
            case "sdkf":
                statusTxtView.setText("En cours de livraison. ");
           //     statusIcon.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
                break;
            case "sdf":
                statusTxtView.setText("En cours de préparation. ");
             //   statusIcon.setImageResource(R.drawable.ic_indeterminate_check_box_black_24dp);
                break;
        }

    }

    public void prepareOrderInfo(Order order){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_orders_details, menu);
        return true;
    }
}
