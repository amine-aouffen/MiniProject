package tdm.miniproject.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


import tdm.miniproject.fragments.ProductListFragment;
import tdm.miniproject.job.Category;
import tdm.miniproject.job.Consumer;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.ProductListFragmentListener;


public class PagerAdapter extends FragmentStatePagerAdapter{
    private FragmentManager fragmentManager;
    private ProductListFragmentListener listener;
    private ProductListFragment manFragment;
    private ProductListFragment womanFragment;
    private ProductListFragment kidFragment;
    private Category category = Category.JEANS;



    public PagerAdapter(FragmentManager fragmentManager, ProductListFragmentListener listener) {
        super(fragmentManager);
        this.fragmentManager=fragmentManager;
        this.listener = listener;
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
                kidFragment = createConsumerFragment(Consumer.CHILD);

                return kidFragment;
            default:
                return manFragment;
        }
    }
    private ProductListFragment createConsumerFragment(Consumer consumer){
        ProductListFragment fragment = new ProductListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("category",category);
        bundle.putSerializable("consumer",consumer);
        fragment.setArguments(bundle);
        fragment.setListener(listener);
        return fragment;
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
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void setCategoryByPosition(int position){
        switch (position){
            case 0:
                category = Category.TSHIRT;
                break;
            case 1:
                category = Category.SHOES;
                break;
            case 2:
                category = Category.VESTS;
                break;
            case 3:
                category = Category.JEANS;
                break;
            case 4:
                category = Category.SHIRT;
                break;
        }

        //TODO récupérer les produits par catégories et se notifier
    }

}
