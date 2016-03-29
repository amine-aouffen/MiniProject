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
import tdm.miniproject.adapters.ProductAdapter;
import tdm.miniproject.fragments.ProductListFragment;
import tdm.miniproject.job.Cart;
import tdm.miniproject.job.Category;
import tdm.miniproject.job.Consumer;
import tdm.miniproject.job.Product;

public class MainActivity extends AppCompatActivity {
    private List<Category> categoriesList;
    private Cart cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateExamples();
        initialiseToolBar();
        initialiseTabNavigation();


    }
    public void initialiseToolBar(){
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.mainToolBar);
        setSupportActionBar(mainToolbar);
    }

    public void initialiseTabNavigation(){
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        for (int i=0;i<=2;i++){
            ProductListFragment fragment = new ProductListFragment();
            fragment.setTitle("tab" + i);
            Bundle bundle = new Bundle();
            ProductAdapter productAdapter = new ProductAdapter(this,categoriesList.get(i));
            bundle.putSerializable("adapter",productAdapter);
            fragment.setArguments(bundle);
            pagerAdapter.addFragment(fragment);


        }
        ViewPager viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        MenuItem item = menu.findItem(R.id.categorySpinner);
        Spinner categorySpinner = (Spinner) item.getActionView();
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoriesList);
        categorySpinner.setAdapter(categoryAdapter);

        return true;
    }


    public void generateExamples(){
        //Creation of product categories list
        categoriesList= new ArrayList<Category>();
        //Creation of some product categories
        Category categorie1 = new Category("Polos");
        Category categorie2 = new Category("Chaussures");
        Category categorie3 = new Category("Vestes");
        Category categorie4 = new Category("Pantalons");
        Category categorie5 = new Category("Accessoires");
        //Creation of 10 products for each categorie
        //Categorie1
        categorie1.add(new Product("Polo1",1400,"Un tres bon pull",R.drawable.blaser_homme_hiver, Consumer.MAN));
        categorie1.add(new Product("Polo2",1500,"Un tres bon pull",R.drawable.blaser_homme_hiver, Consumer.MAN));
        categorie1.add(new Product("Polo3",1350,"Un tres bon pull",R.drawable.blaser_homme_hiver, Consumer.MAN));
        categorie1.add(new Product("Polo4",800,"Un tres bon pull",R.drawable.blaser_homme_hiver, Consumer.MAN));
        categorie1.add(new Product("Polo5",900,"Un tres bon pull",R.drawable.blaser_homme_hiver, Consumer.MAN));
        categorie1.add(new Product("Polo6",670,"Un tres bon pull",R.drawable.blaser_homme_hiver, Consumer.MAN));
        categorie1.add(new Product("Polo7",392,"Un tres bon pull",R.drawable.blaser_homme_hiver, Consumer.MAN));
        categorie1.add(new Product("Polo8",1400,"Un tres bon pull",R.drawable.blaser_homme_hiver, Consumer.MAN));
        categorie1.add(new Product("Polo9",1600,"Un tres bon pull",R.drawable.blaser_homme_hiver, Consumer.MAN));
        categorie1.add(new Product("Polo10",1090,"Un tres bon pull",R.drawable.blaser_homme_hiver, Consumer.MAN));
        //Categorie2
        //Categorie3
        //Categorie4
        //Categorie5

        //Adding categories to the categories list
        categoriesList.add(categorie1);
        categoriesList.add(categorie2);
        categoriesList.add(categorie3);
        categoriesList.add(categorie4);
        categoriesList.add(categorie5);
    }

    public void showChartActivity(MenuItem item) {
        Intent intent = new Intent(this,CartActivity.class);
        startActivity(intent);

    }
}