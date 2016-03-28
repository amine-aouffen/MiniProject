package tdm.miniproject.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import tdm.miniproject.R;
import tdm.miniproject.adapters.CategoryAdapter;
import tdm.miniproject.adapters.PagerAdapter;
import tdm.miniproject.fragments.ProductListFragment;
import tdm.miniproject.job.Category;

public class MainActivity extends AppCompatActivity {
    private List<Category> categoriesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseToolBar();
        initialiseTabNavigation();
        generateExample();

    }
    public void initialiseToolBar(){
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.mainToolBar);
        setSupportActionBar(mainToolbar);
    }

    public void initialiseTabNavigation(){
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        for (int i=0;i<=2;i++){
            ProductListFragment fragment = new ProductListFragment();
            fragment.setTitle("tab"+i);
            pagerAdapter.addFragment(fragment);

        }
        ViewPager viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       /** MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        MenuItem item = menu.findItem(R.id.categorySpinner);
        Spinner categorySpinner = (Spinner) item.getActionView();
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoriesList);
        categorySpinner.setAdapter(categoryAdapter);**/
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        MenuItem item = menu.findItem(R.id.categorySpinner);
        Spinner categorySpinner = (Spinner) item.getActionView();
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoriesList);
        categorySpinner.setAdapter(categoryAdapter);

        return true;
    }


    public void generateExample(){
        //Creation of product categories list
        categoriesList= new ArrayList<Category>();
        //Creation of some product categories
        categoriesList.add(new Category("Vêtement"));
        categoriesList.add(new Category("Accessoires"));
        categoriesList.add(new Category("Accessoires 2"));
    }

    public void showChartActivity(MenuItem item) {
        Intent intent = new Intent(this,CartActivity.class);
        startActivity(intent);

    }
}