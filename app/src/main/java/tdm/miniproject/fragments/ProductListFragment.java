package tdm.miniproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import tdm.miniproject.R;
import tdm.miniproject.activities.MainActivity;
import tdm.miniproject.adapters.ProductAdapter;
import tdm.miniproject.job.Consumer;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.ProductListFragmentListener;


public class ProductListFragment extends Fragment {
    private String title="tab";
    private ArrayList<Product> productsList;
    private ProductAdapter productAdapter;
    private ProductListFragmentListener listener;
    private ListView productListView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list,container,false);
        prepareFragment(view);
        setItemClickListener();
        return view;
    }

    private void prepareFragment(View view) {
        productListView = (ListView) view.findViewById(R.id.productList);
        Bundle bundle = getArguments();
        if(bundle!=null){
            productsList=(ArrayList<Product>)bundle.get("productsList");
            productAdapter=new ProductAdapter(getActivity(),productsList);
            productListView.setAdapter(productAdapter);
        }

    }

    private void setItemClickListener() {
        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = productsList.get(position);
                showProductDetaills(product);
            }
        });
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setListener(ProductListFragmentListener listener){
        this.listener=listener;
    }

    public void showProductDetaills(Product product){
        listener.showProductDetaills(product);
    }

    public void addProductToCart(Product product){
        listener.addProductToCart(product);
    }

    public void modifyProductList(ArrayList<Product> products){
        this.productsList=products;
        this.productAdapter.setProductsList(products);
        productAdapter.notifyDataSetChanged();
    }

    public void updateProductList(ArrayList<Product> products){
        if(productAdapter!=null) {
            this.productsList = products;
            productAdapter.setProductsList(products);
            productAdapter.notifyDataSetChanged();
        }
    }
}
