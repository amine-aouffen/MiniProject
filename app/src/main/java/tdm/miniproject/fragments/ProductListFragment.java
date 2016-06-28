package tdm.miniproject.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import tdm.miniproject.R;
import tdm.miniproject.Utils.ServiceUtil;
import tdm.miniproject.adapters.ProductAdapter;
import tdm.miniproject.job.Category;
import tdm.miniproject.job.Consumer;
import tdm.miniproject.job.Product;
import tdm.miniproject.managers.HttpManager;
import tdm.miniproject.managers.RequestManager;
import tdm.miniproject.support.ProductListFragmentListener;


public class ProductListFragment extends Fragment {
    private String title="tab";
    private List<Product> productsList;
    private ProductAdapter productAdapter;
    private ProductListFragmentListener listener;
    private ListView productListView;
    private View fragView=null;
    private ProgressBar pb;

    public ProductListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragView = inflater.inflate(R.layout.fragment_product_list,container,false);
        pb = (ProgressBar) fragView.findViewById(R.id.progressBarProd);
        Bundle bundle = getArguments();
        if(bundle!=null){
            Consumer consumer = (Consumer) bundle.get("consumer") ;
            Category category = (Category) bundle.get("category");
            String density = ServiceUtil.getScreenDensity((AppCompatActivity) getActivity());
            String uri = RequestManager.getRequestProductListWP(density,category,consumer);
            new GetProductsTask().execute(uri);
        }

        return fragView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (fragView!=null)prepareFragment(fragView);
    }

    private void prepareFragment(View view) {
        productListView = (ListView) view.findViewById(R.id.productList);


        if(productsList!=null){
            if(productAdapter==null)productAdapter=new ProductAdapter(getActivity(),(ArrayList)productsList);
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

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public void showProductDetails(Product product){
       try{
           listener.showProductDetails(product);
       }catch (Exception e){

       }
    }

    public void showProductList(View view){
        productListView = (ListView) view.findViewById(R.id.productList);
        if(productAdapter==null) productAdapter = new ProductAdapter(getActivity(),(ArrayList)productsList);
        productListView.setAdapter(productAdapter);
        setItemClickListener();
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






    public class GetProductsTask extends AsyncTask<String,Void,List<Product>>{
        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);

        }

        @Override
        protected List<Product> doInBackground(String... params) {
            String jsonList=new HttpManager().getDataFromServiceURI(params[0]);

            Product[] productsArray = new Gson().fromJson(jsonList,Product[].class);
            List<Product> productList = new ArrayList<>(Arrays.asList(productsArray));
            return productList;
        }

        @Override
        protected void onPostExecute(List<Product> productsList) {
            pb.setVisibility(View.INVISIBLE);
            setProductsList(productsList);
            showProductList(fragView);
        }
    }
}
