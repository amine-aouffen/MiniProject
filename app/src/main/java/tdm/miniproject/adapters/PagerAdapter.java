package tdm.miniproject.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Switch;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

import tdm.miniproject.activities.MainActivity;
import tdm.miniproject.fragments.ProductListFragment;
import tdm.miniproject.job.Category;
import tdm.miniproject.job.Consumer;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.ProductListFragmentListener;


public class PagerAdapter extends FragmentPagerAdapter{
    private FragmentManager fragmentManager;
    private ArrayList<Product> manProductsList;
    private ArrayList<Product> womanProductsList;
    private ArrayList<Product> kidProductsList;
    private ProductListFragmentListener listner;

    public ProductListFragment getWomanFragment() {
        return womanFragment;
    }

    public void setWomanFragment(ProductListFragment womanFragment) {
        this.womanFragment = womanFragment;
    }

    public ProductListFragment getManFragment() {
        return manFragment;
    }

    public void setManFragment(ProductListFragment manFragment) {
        this.manFragment = manFragment;
    }

    public ProductListFragment getKidFragment() {
        return kidFragment;
    }

    public void setKidFragment(ProductListFragment kidFragment) {
        this.kidFragment = kidFragment;
    }

    private ProductListFragment manFragment;
    private ProductListFragment womanFragment;
    private ProductListFragment kidFragment;


    public PagerAdapter(FragmentManager fragmentManager,Category category,ProductListFragmentListener listner) {
        super(fragmentManager);
        this.fragmentManager=fragmentManager;
        this.listner=listner;
        dispatchCategoryToLists(category);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                Toast.makeText((MainActivity)listner, "man", Toast.LENGTH_SHORT).show();
                manFragment = createConsumerFragment(Consumer.MAN);
                return manFragment;
            case 1:
                Toast.makeText((MainActivity)listner, "woman", Toast.LENGTH_SHORT).show();
                womanFragment = createConsumerFragment(Consumer.WOMAN);
                return womanFragment;
            case 2:
                Toast.makeText((MainActivity)listner, "kid", Toast.LENGTH_SHORT).show();
                kidFragment = createConsumerFragment(Consumer.KID);
                return kidFragment;
            default:
                return null;
        }
    }
    private ProductListFragment createConsumerFragment(Consumer consumer){
        ProductListFragment fragment = new ProductListFragment();
        Bundle bundle = new Bundle();
        if(consumer==Consumer.MAN){
            bundle.putSerializable("productsList",manProductsList);
        }else if(consumer==Consumer.WOMAN){
            bundle.putSerializable("productsList",womanProductsList);
        }else{
            bundle.putSerializable("productsList",kidProductsList);
        }
        ((ProductListFragment)fragment).setListener(listner);
        fragment.setArguments(bundle);
        return fragment;
    }
    public void dispatchCategoryToLists(Category category){
        manProductsList=new ArrayList<>();
        womanProductsList=new ArrayList<>();
        kidProductsList=new ArrayList<>();
        Product product;
        for(int i=0;i<category.size();i++){
            product=category.get(i);
            if(product.getConsumer()==Consumer.MAN){
                manProductsList.add(product);
            }else if(product.getConsumer()==Consumer.WOMAN){
                womanProductsList.add(product);
            }else{
                kidProductsList.add(product);
            }
        }
    }
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "Hommes";
            case 1:
                return "Femmes";
            case 2:
                return "Enfants";
            default:
                return null;
        }
    }

    @Override
    public void notifyDataSetChanged() {

            if(manFragment!=null)manFragment.updateProductList(manProductsList);
        if(womanFragment!=null)womanFragment.updateProductList(womanProductsList);
        if(kidFragment!=null)kidFragment.updateProductList(kidProductsList);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
