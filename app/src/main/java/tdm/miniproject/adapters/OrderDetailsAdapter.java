package tdm.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

import tdm.miniproject.R;
import tdm.miniproject.job.Order;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.CartElement;

/**
 * Created by amine on 24/04/2016.
 */
public class OrderDetailsAdapter extends BaseAdapter {
    private Order order;
    private Context context;

    public OrderDetailsAdapter(Context context, Order order) {
        this.context = context;
        this.order = order;
    }

    @Override
    public int getCount() {
        return order.getCart().getElementsList().size();
    }

    @Override
    public Object getItem(int position) {
        return order.getCart().getElementsList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflateView(convertView);
        showProductAsItem(view,order.getCart().getCartElement(position));
        return view;
    }


    private void showProductAsItem(View view, CartElement cartElement) {
        ImageView productPhotoImageView = (ImageView) view.findViewById(R.id.orderDetailsItemImage);
        productPhotoImageView.setImageResource(cartElement.getProduct().getProductPhoto());

        TextView productNameTextView=(TextView)view.findViewById(R.id.orderDetailsItemName);
        productNameTextView.setText(cartElement.getProduct().getName());

        TextView productDescriptionTextView=(TextView)view.findViewById(R.id.orderDetailsItemDescription);
        productDescriptionTextView.setText(cartElement.getProduct().getDescription());

        TextView productPriceTextView=(TextView)view.findViewById(R.id.orderDetailsItemPrice);
        productPriceTextView.setText(cartElement.getProduct().getPrice() + "DA x"+cartElement.getQuantity()+"="+cartElement.getProduct().getPrice()*cartElement.getQuantity()+" DA");

        TextView productQuantityTextView = (TextView) view.findViewById(R.id.orderDetailsItemQuantity);
        productQuantityTextView.setText("X"+cartElement.getQuantity());
    }

    private View inflateView(View convertView) {
        View view = convertView;
        if(view==null){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(context);
            view=inflater.inflate(R.layout.item_order_details, null);
        }
        return view;
    }
}
