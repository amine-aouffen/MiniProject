package tdm.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;



import tdm.miniproject.R;
import tdm.miniproject.Utils.ServiceUtil;
import tdm.miniproject.job.Cart;

import tdm.miniproject.managers.CartManager;
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

        View view = inflateView(convertView);

        final CartElement cartElement =(CartElement) getItem(position);
        final TextView cartItemQuantity= (TextView)view.findViewById(R.id.cartItemQuantity);

        showCartElementAsItem(view, cartElement, cartItemQuantity);

        setButtonsListeners(position, view, cartElement, cartItemQuantity);

        return view;
    }

    private View inflateView(View convertView) {
        View view = convertView;
        if (view==null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view=inflater.inflate(R.layout.item_chart_list,null);
        }
        return view;
    }

    private void showCartElementAsItem(View view, CartElement cartElement, TextView cartItemQuantity) {
        TextView cartItemName=(TextView)view.findViewById(R.id.cartItemName);
        cartItemName.setText(cartElement.getProduct().getName());

        TextView cartItemDesc=(TextView)view.findViewById(R.id.cartItemDescription);
        cartItemDesc.setText(cartElement.getProduct().getDescription());

        TextView cartItemPrice=(TextView)view.findViewById(R.id.cartItemPrice);
        cartItemPrice.setText(cartElement.getProduct().getPrice()+" DA");

        cartItemQuantity.setText(cartElement.getQuantity()+"");

        ImageView cartItemPhoto =(ImageView) view.findViewById(R.id.cartItemImage);
        cartItemPhoto.setImageBitmap(ServiceUtil.getBitmapFromString(cartElement.getProduct().getPhoto()));
    }

    private void setButtonsListeners(final int position, final View view, final CartElement cartElement, final TextView cartItemQuantity) {
        //Delete button
        Button cartItemDelete= (Button)view.findViewById(R.id.cartItemDelete);
        cartItemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(new AlphaAnimation(1F,0.5F));
                cart.removeCartElement(position);
                CartManager.deleteProductFromCart(view.getContext(),position);
                notifyDataSetChanged();
            }
        });
        //Incement quantity
        Button cartItemIncQuantity= (Button)view.findViewById(R.id.cartItemIncQuantity);
        cartItemIncQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(new AlphaAnimation(1F,0.5F));
                cartElement.incQunatity();
                cartItemQuantity.setText(cartElement.getQuantity() + "");
                CartManager.incProductQuantity(view.getContext(),position);
            }
        });
        //Decrement quantity
        Button cartItemDecQuantity= (Button)view.findViewById(R.id.cartItemDecQuantity);
        cartItemDecQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(new AlphaAnimation(1F,0.5F));
                cartElement.decQuantity();
                cartItemQuantity.setText(cartElement.getQuantity() + "");
                CartManager.decProductQuantity(view.getContext(),position);

            }
        });
    }
}
