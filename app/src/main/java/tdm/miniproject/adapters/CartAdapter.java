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
import android.widget.Toast;


import tdm.miniproject.R;
import tdm.miniproject.Utils.ServiceUtil;
import tdm.miniproject.job.Cart;

import tdm.miniproject.managers.CartManager;
import tdm.miniproject.support.CartElement;
import tdm.miniproject.support.CartOperationRequest;
import tdm.miniproject.tasks.AddToCartTask;

/**
 * Created by Home on 27/03/2016.
 */
public class CartAdapter extends BaseAdapter {
    private Cart cart;
    private Context context;
    private TextView quantityTV;

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
        quantityTV=cartItemQuantity;

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
        cartItemName.setText(cartElement.getProduct().getName()+" "+cartElement.getSize());

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
                CartOperationRequest cartOperationRequest = new CartOperationRequest();
                cartOperationRequest.setProductName(cartElement.getProduct().getName());
                cartOperationRequest.setQuantity(cartElement.getQuantity());
                cartOperationRequest.setSize(cartElement.getSize());
                cartOperationRequest.setType("MATH_OPERATION");
                new AddToCartTask(context,cartElement.getProduct(),cartElement.getSize(),cartElement.getQuantity(),new QuantityHandler(QuantityHandler.DELETE)).execute(cartOperationRequest);


            }
        });
        //Incement quantity
        Button cartItemIncQuantity= (Button)view.findViewById(R.id.cartItemIncQuantity);
        cartItemIncQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(new AlphaAnimation(1F,0.5F));
                CartOperationRequest cartOperationRequest = new CartOperationRequest();
                cartOperationRequest.setProductName(cartElement.getProduct().getName());
                cartOperationRequest.setQuantity(-1);
                cartOperationRequest.setSize(cartElement.getSize());
                cartOperationRequest.setType("MATH_OPERATION");
                new AddToCartTask(context,cartElement.getProduct(),cartElement.getSize(),cartElement.getQuantity(),new QuantityHandler(QuantityHandler.INCDEC)).execute(cartOperationRequest);


            }
        });
        //Decrement quantity
        Button cartItemDecQuantity= (Button)view.findViewById(R.id.cartItemDecQuantity);
        cartItemDecQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(new AlphaAnimation(1F,0.5F));
                if(cartElement.getQuantity()==1){
                    Toast.makeText(context, "C'est la quantité minimale!", Toast.LENGTH_SHORT).show();
                }
                else{
                    CartOperationRequest cartOperationRequest = new CartOperationRequest();
                    cartOperationRequest.setProductName(cartElement.getProduct().getName());
                    cartOperationRequest.setQuantity(1);
                    cartOperationRequest.setSize(cartElement.getSize());
                    cartOperationRequest.setType("MATH_OPERATION");
                    new AddToCartTask(context,cartElement.getProduct(),cartElement.getSize(),cartElement.getQuantity(),new QuantityHandler(QuantityHandler.INCDEC)).execute(cartOperationRequest);

                }

            }
        });
    }

    public class QuantityHandler {
        public static final int INCDEC = 1;
        public static final int DELETE = 2;
        private int type;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public QuantityHandler(int type) {
            this.type=type;
        }

        public void doPostWork(String productName,String size ,String text){
            if(type==INCDEC){
                quantityTV.setText(text);
            }
            else{//DELETE
                CartManager.deleteProductFromCart(quantityTV.getContext(),productName,size);

            }
            cart=CartManager.getCart(context);
            notifyDataSetChanged();


        }
    }
}
