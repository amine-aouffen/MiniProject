package tdm.miniproject.adapters;


import android.app.ActionBar;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.widget.LinearLayout.LayoutParams;

import java.util.ArrayList;

import tdm.miniproject.R;
import tdm.miniproject.job.Order;
import tdm.miniproject.support.CartElement;

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
        titleTxtView.setText("Commande "+position);
        TextView dateTxtView=(TextView)view.findViewById(R.id.orderItemDate);
        dateTxtView.setText(ordersList.get(position).getDate());
        TextView totalTxtView=(TextView)view.findViewById(R.id.orderItemTotal);
        totalTxtView.setText(ordersList.get(position).getTotalCost()+" DA");
        TextView statusTxtView=(TextView)view.findViewById(R.id.orderItemStatus);
        ImageView statusIcon = (ImageView)view.findViewById(R.id.orderItemStatusIcon);
        switch (ordersList.get(position).getStatus()){
            case ON_DELEVERY:
                statusTxtView.setText("En cours de livraison. ");
                statusIcon.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
                break;
            case ON_PREPARATION:
                statusTxtView.setText("En cours de préparation. ");
                statusIcon.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
                break;
            default:
                break;
        }
        showAllProductsInOrderItemList(view, position);

    }

    private void showAllProductsInOrderItemList(View view, int position) {
        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.orderItemProductsList);
        for(int i =0;i<ordersList.get(position).getCart().getElementsList().size();i++){
            showOneProductInOrderItemList(linearLayout, position, i);
        }
    }

    private void showOneProductInOrderItemList(LinearLayout linearLayout, int cartPos, int productPos) {
        CartElement cartElement = ordersList.get(cartPos).getCart().getCartElement(productPos);
        TextView productTextView = new TextView(context);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        productTextView.setLayoutParams(layoutParams);
        productTextView.setText(cartElement.getProduct().getName() + " " + cartElement.getProduct().getPrice() + " DA " + "X" + cartElement.getQuantity());
        linearLayout.addView(productTextView);
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
