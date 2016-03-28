package tdm.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tdm.miniproject.R;
import tdm.miniproject.job.Product;

/**
 * Created by Home on 23/03/2016.
 */
public class ProductAdapter extends BaseAdapter implements Filterable{
    private Context context;
    private List<Product> productsList;
    public ProductAdapter(Context context,List<Product> productsList) {
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
        View view = convertView;
        if(view==null){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(context);
            view=inflater.inflate(R.layout.item_categorie_list,null);
        }
        return view;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
