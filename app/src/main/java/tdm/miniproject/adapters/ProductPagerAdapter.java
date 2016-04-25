package tdm.miniproject.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import tdm.miniproject.R;

/**
 * Created by Salah on 23/04/2016.
 */
public class ProductPagerAdapter  extends FragmentPagerAdapter {

    private Context context;
    private static final int Tab_Count = 3;
    private static final String Tab_Titles[] = {"Hommes", "Femmes", "Enfants"};
    private static final int[] imageResId = {
            R.drawable.ic_action_homme,
            R.drawable.ic_action_femme,
            R.drawable.ic_action_enfant
    };


    public ProductPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    public ProductPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a ProductListFragment.
        // position + 1 refers to section/tab number

        return new Fragment();
       // return ProductListFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return Tab_Count;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (position >= 0 && position <= Tab_Count-1)
            return Tab_Titles[position];
        return null;
    }

    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = null;
//                = LayoutInflater.from(context).inflate(R.layout.fragment_tab, null);
//        TextView tv = (TextView) v.findViewById(R.id.textView);
//        if (position >= 0 && position <= Tab_Count-1) {
//            tv.setText(Tab_Titles[position]);
//            ImageView img = (ImageView) v.findViewById(R.id.imgView);
//            img.setImageResource(imageResId[position]);
//        }
        return v;
    }
}