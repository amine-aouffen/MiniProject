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
import android.widget.Toast;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import tdm.miniproject.R;
import tdm.miniproject.adapters.ProductAdapter;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.ProductListFragmentListener;


public class ProductListFragment extends Fragment {
    private String title="tab";
    private ArrayList<Product> productsList;
    private ProductAdapter productAdapter;
    private ProductListFragmentListener listener;
    private ListView productListView;
    private View fragView=null;

    public ProductListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragView = inflater.inflate(R.layout.fragment_product_list,container,false);
        prepareFragment(fragView);
        setItemClickListener();
        return fragView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (fragView!=null)prepareFragment(fragView);
    }

    private void prepareFragment(View view) {
        productListView = (ListView) view.findViewById(R.id.productList);
        Bundle bundle = getArguments();
        if(bundle!=null){
            productsList=(ArrayList<Product>)bundle.get("productsList");
            if(productAdapter==null)productAdapter=new ProductAdapter(getActivity(),productsList);
            productListView.setAdapter(productAdapter);
        }

    }

    private void setItemClickListener() {
        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = productsList.get(position);
                showProductDetails(product);
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

    public void showProductDetails(Product product){
       try{
           listener.showProductDetails(product);
       }catch (Exception e){

       }
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
