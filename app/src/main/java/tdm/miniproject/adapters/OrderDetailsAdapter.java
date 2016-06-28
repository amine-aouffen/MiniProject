package tdm.miniproject.adapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

import tdm.miniproject.R;
import tdm.miniproject.Utils.ServiceUtil;
import tdm.miniproject.job.Order;
import tdm.miniproject.job.OrderLine;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.CartElement;
import tdm.miniproject.tasks.GetPhotoTask;

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
        return order.getOrderLines().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflateView(convertView);
        showProductAsItem(view,order.getOrderLines().get(position));
        return view;
    }


    private void showProductAsItem(View view, OrderLine orderLine) {
        ImageView productPhotoImageView = (ImageView) view.findViewById(R.id.orderDetailsItemImage);
        new GetPhotoTask(productPhotoImageView).execute(orderLine.getProductName(), ServiceUtil.getScreenDensity((AppCompatActivity)context));

        TextView productNameTextView=(TextView)view.findViewById(R.id.orderDetailsItemName);
        productNameTextView.setText(orderLine.getProductName()+" "+orderLine.getSize());

        TextView productDescriptionTextView=(TextView)view.findViewById(R.id.orderDetailsItemDescription);
        productDescriptionTextView.setText(orderLine.getLigneNumber()+"");

        TextView productPriceTextView=(TextView)view.findViewById(R.id.orderDetailsItemPrice);
        productPriceTextView.setText(orderLine.getUnitPrice() + "DA x"+orderLine.getQuantity()+"="+orderLine.getUnitPrice()*orderLine.getQuantity()+" DA");

        TextView productQuantityTextView = (TextView) view.findViewById(R.id.orderDetailsItemQuantity);
        productQuantityTextView.setText("X"+orderLine.getQuantity());
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
