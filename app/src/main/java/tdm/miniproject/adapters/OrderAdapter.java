package tdm.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.widget.TextView;
import java.util.ArrayList;

import tdm.miniproject.R;
import tdm.miniproject.job.Order;


public class OrderAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Order> ordersList;

    public OrderAdapter(Context context, ArrayList<Order> ordersList) {
        this.context = context;
        this.ordersList = ordersList;
    }

    @Override
    public int getCount() {
        return ordersList.size();
    }

    @Override
    public Object getItem(int position) {
        return ordersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflateView(convertView);
        showOrderAsItem(view, position);
        return view;
    }

    private void showOrderAsItem(View view, int position) {
        TextView titleTxtView=(TextView)view.findViewById(R.id.orderItemTitle);
        //titleTxtView.setText("Commande n°" + ordersList.get(position).getNumber());
        TextView dateTxtView=(TextView)view.findViewById(R.id.orderItemDate);
        //dateTxtView.setText(ordersList.get(position).getDate());
        TextView totalTxtView=(TextView)view.findViewById(R.id.orderItemTotal);
        //totalTxtView.setText(ordersList.get(position).getTotalCost()+" DA");
        TextView statusTxtView=(TextView)view.findViewById(R.id.orderItemStatus);
        ImageView statusIcon = (ImageView)view.findViewById(R.id.orderItemStatusIcon);
        double a =Math.random()*1000*Math.random()  ;
        int i=((int)a)%2;
        switch (i){
            case 0:
                statusTxtView.setText("En cours de livraison. ");
               // statusIcon.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
                break;
            case 1:
                statusTxtView.setText("En cours de préparation. ");
             //   statusIcon.setImageResource(R.drawable.ic_indeterminate_check_box_black_24dp);
                break;
            default:
                break;
        }

    }



    private View inflateView(View convertView) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view=inflater.inflate(R.layout.item_order_list,null);
        }
        return view;
    }



}
