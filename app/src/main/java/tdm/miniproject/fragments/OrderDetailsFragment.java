package tdm.miniproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import tdm.miniproject.R;
import tdm.miniproject.adapters.OrderDetailsAdapter;
import tdm.miniproject.job.Order;

/**
 * Created by amine on 25/04/2016.
 */
public class OrderDetailsFragment extends Fragment{
    public OrderDetailsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orders_details,container,false);
        prepareViews(view);
        return view;
    }

    public void prepareViews(View view){
        Bundle bundle = getArguments();
        if (bundle!=null){
            ListView listView = (ListView) view.findViewById(R.id.orderDetailsList);
            Order order = (Order) bundle.get("order");
            OrderDetailsAdapter adapter = new OrderDetailsAdapter(getContext(),order);
            listView.setAdapter(adapter);
            TextView titleTxtView=(TextView)view.findViewById(R.id.orderItemTitle);
            //titleTxtView.setText("Commande n°"+order.getNumber());
            TextView dateTxtView=(TextView)view.findViewById(R.id.orderItemDate);
            //dateTxtView.setText(order.getDate());
            TextView totalTxtView=(TextView)view.findViewById(R.id.orderItemTotal);
            //totalTxtView.setText(order.getTotalCost()+" DA");
            TextView statusTxtView=(TextView)view.findViewById(R.id.orderItemStatus);
            ImageView statusIcon = (ImageView)view.findViewById(R.id.orderItemStatusIcon);
          /**  switch (order.getStatus()){
                case ON_DELEVERY:
                    statusTxtView.setText("En cours de livraison. ");

                    break;
                case ON_PREPARATION:
                    statusTxtView.setText("En cours de préparation. ");

                    break;
            }**/
        }
    }
}
