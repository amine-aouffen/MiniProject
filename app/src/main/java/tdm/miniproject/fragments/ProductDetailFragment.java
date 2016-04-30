package tdm.miniproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import tdm.miniproject.R;
import tdm.miniproject.activities.MainActivity;
import tdm.miniproject.controlers.CartControler;
import tdm.miniproject.job.Product;


/**
 * Created by Home on 23/03/2016.
 */
public class ProductDetailFragment extends Fragment{
    private TextView productName;
    private TextView productDesc;
    private TextView productCara;
    private TextView productPrice;
    private ImageView productPhoto;
    private Button addToCartBtn;
    private Product product;

    public ProductDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_detail,container,false);
        findViews(view);
        showProductDetails();
        return view;
    }

    public void findViews(View view){
        productName = (TextView)view.findViewById(R.id.productDetailName);
        productDesc= (TextView)view.findViewById(R.id.productDetailDesc);
        productPrice= (TextView)view.findViewById(R.id.productDetailPrice);
        productPhoto= (ImageView)view.findViewById(R.id.productDetailImage);
        productCara= (TextView)view.findViewById(R.id.productDetailCara);
        addToCartBtn = (Button) view.findViewById(R.id.productDetailAddCart);
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductToCart();
            }
        });
    }

    public void showProductDetails(){
        Bundle bundle = getArguments();
        if (bundle!=null){
            product = (Product) bundle.get("product");
            productName.setText(product.getName());
            productDesc.setText(product.getDescription());
            productPrice.setText(product.getPrice()+" DA");
            productPhoto.setImageResource(product.getProductPhoto());
            productCara.setText(product.getCaracteristics());
        }

    }
    public void addProductToCart() {
        CartControler.addProductToSCart(getContext(), product);
    }

}
