package tdm.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

import tdm.miniproject.R;
import tdm.miniproject.job.Cart;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.CartElement;

/**
 * Created by Home on 27/03/2016.
 */
public class CartAdapter extends BaseAdapter {
    private Cart cart;
    private Context context;

    public CartAdapter(Context context,Cart cart) {
        this.context=context;
        this.cart = cart;
    }

    @Override
    public int getCount() {
        return cart.getElementsList().size();
    }

    @Override
    public Object getItem(int position) {
        return cart.getCartElement(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view=inflater.inflate(R.layout.item_chart_list,null);
        }
        final CartElement cartElement =(CartElement) getItem(position);
        Product product = cartElement.getProduct();
        TextView cartItemName=(TextView)view.findViewById(R.id.cartItemName);
        cartItemName.setText(product.getName());
        TextView cartItemDesc=(TextView)view.findViewById(R.id.cartItemDescription);
        cartItemDesc.setText(product.getDescription());
        TextView cartItemPrice=(TextView)view.findViewById(R.id.cartItemPrice);
        cartItemPrice.setText(product.getPrice()+" DA");

        final TextView cartItemQuantity= (TextView)view.findViewById(R.id.cartItemQuantity);
        cartItemQuantity.setText(cartElement.getQuantity()+"");

        ImageView cartItemPhoto =(ImageView) view.findViewById(R.id.cartItemImage);
        cartItemPhoto.setImageResource(product.getProductPhoto());
        Button cartItemDelete= (Button)view.findViewById(R.id.cartItemDelete);
        cartItemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.removeCartElement(position);
                notifyDataSetChanged();

            }
        });
        Button cartItemIncQuantity= (Button)view.findViewById(R.id.cartItemIncQuantity);
        cartItemIncQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartElement.incQunatity();
                cartItemQuantity.setText(cartElement.getQuantity() + "");
            }
        });
        Button cartItemDecQuantity= (Button)view.findViewById(R.id.cartItemDecQuantity);
        cartItemDecQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartElement.decQuantity();
                cartItemQuantity.setText(cartElement.getQuantity()+ "");
            }
        });
        return view;
    }
}
