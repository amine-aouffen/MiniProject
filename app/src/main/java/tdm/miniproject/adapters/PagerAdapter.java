package tdm.miniproject.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

import java.util.ArrayList;


import tdm.miniproject.activities.MainActivity;
import tdm.miniproject.fragments.ProductListFragment;
import tdm.miniproject.job.Category;
import tdm.miniproject.job.Consumer;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.ProductListFragmentListener;


public class PagerAdapter extends FragmentStatePagerAdapter{
    private FragmentManager fragmentManager;
    private ArrayList<Product> manProductsList;
    private ArrayList<Product> womanProductsList;
    private ArrayList<Product> kidProductsList;
    private ProductListFragmentListener listener;
    private ProductListFragment manFragment;
    private ProductListFragment womanFragment;
    private ProductListFragment kidFragment;


    public PagerAdapter(FragmentManager fragmentManager,Category category,ProductListFragmentListener listener) {
        super(fragmentManager);
        this.fragmentManager=fragmentManager;
        this.listener = listener;
        dispatchCategoryToLists(category);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                manFragment = createConsumerFragment(Consumer.MAN);

                return manFragment;
            case 1:
                womanFragment = createConsumerFragment(Consumer.WOMAN);

                return womanFragment;
            case 2:
                kidFragment = createConsumerFragment(Consumer.KID);

                return kidFragment;
            default:
                return manFragment;
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
        fragment.setArguments(bundle);
        fragment.setListener(listener);
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



    public void updateFraments(){
        if(manFragment!=null)manFragment.updateProductList(manProductsList);
        if(womanFragment!=null)womanFragment.updateProductList(womanProductsList);
        if(kidFragment!=null)kidFragment.updateProductList(kidProductsList);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void destroyFragments(){
        manFragment=null;
        womanFragment=null;
        kidFragment=null;
    }

}
