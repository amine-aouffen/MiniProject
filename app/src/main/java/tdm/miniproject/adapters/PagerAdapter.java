package tdm.miniproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import tdm.miniproject.fragments.ProductListFragment;


public class PagerAdapter extends FragmentPagerAdapter {
    private FragmentManager fragmentManager;
    private ArrayList<ProductListFragment> fragmentsList;

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.fragmentManager=fragmentManager;
        this.fragmentsList=new ArrayList<>();
    }

    public void addFragment(ProductListFragment fragment){
        fragmentsList.add(fragment);
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = fragmentsList.get(position).getTitle();
        return title;
    }
}
