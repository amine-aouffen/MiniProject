package tdm.miniproject.adapters;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tdm.miniproject.R;
import tdm.miniproject.activities.MainActivity;
import tdm.miniproject.job.Consumer;
import tdm.miniproject.job.Product;

/**
 * Created by Home on 23/03/2016.
 */
public class ProductAdapter extends BaseAdapter implements Filterable,Serializable{
    private Context context;

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    private ArrayList<Product> productsList;
    public ProductAdapter(Context context,ArrayList<Product> productsList) {
        this.context=context;
        this.productsList=productsList;
    }


    @Override
    public int getCount() {
        return productsList.size();
    }

    @Override
    public Object getItem(int position) {
        return productsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflateView(convertView);
        final Product product = productsList.get(position);
        showProductAsItem(view, product);
        setAddCartBtnListener(view, product);
        return view;
    }

    private void showProductAsItem(View view, Product product) {
        ImageView productPhotoImageView = (ImageView) view.findViewById(R.id.productItemImage);
        productPhotoImageView.setImageResource(product.getProductPhoto());

        TextView productNameTextView=(TextView)view.findViewById(R.id.productItemName);
        productNameTextView.setText(product.getName());

        TextView productDescriptionTextView=(TextView)view.findViewById(R.id.productItemDescription);
        productDescriptionTextView.setText(product.getDescription());

        TextView productPriceTextView=(TextView)view.findViewById(R.id.productItemPrice);
        productPriceTextView.setText(product.getPrice()+" DA");
    }

    private void setAddCartBtnListener(View view, final Product product) {
        Button addCartButton = (Button) view.findViewById(R.id.productItemAddCart);
        addCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).addProductToCart(product);
            }
        });
    }

    private View inflateView(View convertView) {
        View view = convertView;
        if(view==null){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(context);
            view=inflater.inflate(R.layout.item_product_list, null);
        }
        return view;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
