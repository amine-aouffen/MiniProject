package tdm.miniproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import tdm.miniproject.R;
import tdm.miniproject.adapters.ProductAdapter;

/**
 * Created by Home on 23/03/2016.
 */
public class ProductListFragment extends Fragment {
    private String title="tab";
    private ProductAdapter productAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list,container,false);
        ListView productListView = (ListView) view.findViewById(R.id.productList);
        Bundle bundle = getArguments();
        if(bundle!=null){
            productAdapter=(ProductAdapter)bundle.get("adapter");
            productListView.setAdapter(productAdapter);
        }

        return view;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
