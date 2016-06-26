package tdm.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import tdm.miniproject.R;
import tdm.miniproject.Utils.ServiceUtil;
import tdm.miniproject.activities.MainActivity;
import tdm.miniproject.job.Product;

/**
 * Created by Home on 23/03/2016.
 */
public class ProductAdapter extends BaseAdapter implements Filterable,Serializable{
    private Context context;
    private ArrayList<Product> productsListFiltred;
    private ArrayList<Product> productsList;
    private ItemFilter filter;

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsListFiltred = productsList;
        this.productsList = productsList;
    }


    public ProductAdapter(Context context,ArrayList<Product> productsList) {
        this.context=context;
        this.productsListFiltred=productsList;
        this.productsList=productsList;
        this.filter = new ItemFilter();
    }


    @Override
    public int getCount() {
        return productsListFiltred.size();
    }

    @Override
    public Object getItem(int position) {
        return productsListFiltred.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflateView(convertView);
        final Product product = productsListFiltred.get(position);
        showProductAsItem(view, product);
        setAddCartBtnListener(view, product);
        return view;
    }

    private void showProductAsItem(View view, Product product) {
        ImageView productPhotoImageView = (ImageView) view.findViewById(R.id.productItemImage);
        productPhotoImageView.setImageBitmap(ServiceUtil.getBitmapFromString(product.getPhoto()));

        TextView productNameTextView=(TextView)view.findViewById(R.id.productItemName);
        productNameTextView.setText(product.getName());

        TextView productDescriptionTextView=(TextView)view.findViewById(R.id.productItemDescription);
        productDescriptionTextView.setText(product.getDescription());

        TextView productPriceTextView=(TextView)view.findViewById(R.id.productItemPrice);
        productPriceTextView.setText(product.getPrice() + " DA");
    }

    private void setAddCartBtnListener(View view, final Product product) {
        Button addCartButton = (Button) view.findViewById(R.id.productItemAddCart);
        addCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(new AlphaAnimation(1F,0.5F));
                //TODO add product to local cart
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
        return filter;
    }


    private class ItemFilter extends  Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString().toLowerCase();
            Toast.makeText(context, "this is " + filterString, Toast.LENGTH_SHORT).show();
            FilterResults filterResults = new FilterResults();
            Iterator<Product> iterator = productsList.iterator();
            Product product;
            ArrayList<Product> resultProductsList = new ArrayList<>(productsList.size());
            product=iterator.next();
            while(iterator.hasNext()){
                if(product.getName().toLowerCase().contains(filterString)){
                    resultProductsList.add(product);
                }
            }
            filterResults.count=resultProductsList.size();
            filterResults.values=resultProductsList;
            return filterResults ;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            productsListFiltred=(ArrayList<Product>)results.values;
            notifyDataSetChanged();
        }


    }

}
