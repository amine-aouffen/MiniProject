package tdm.miniproject.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import tdm.miniproject.R;
import tdm.miniproject.adapters.CategoryAdapter;
import tdm.miniproject.adapters.PagerAdapter;
import tdm.miniproject.fragments.ProductListFragment;
import tdm.miniproject.job.Cart;
import tdm.miniproject.job.Category;
import tdm.miniproject.job.Consumer;
import tdm.miniproject.job.Order;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.CartElement;
import tdm.miniproject.support.ProductListFragmentListener;

public class MainActivity extends AppCompatActivity implements ProductListFragmentListener{
    private ArrayList<Category> categoriesList;
    private static Cart cart;
    private static boolean connected;
    private static ArrayList<Order> orders;
    private PagerAdapter pagerAdapter;
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
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),categoriesList.get(0),this);
        ViewPager viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.categorySpinner);
        Spinner categorySpinner = (Spinner) item.getActionView();
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoriesList);
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pagerAdapter.dispatchCategoryToLists(categoriesList.get(position));
                pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return true;
    }


    public void generateExamples(){
        if (cart==null){
            cart = new Cart();
        }
        if(orders==null){
            orders=new ArrayList<Order>();
        }
        if(categoriesList==null){
            //Creation of product categories list
            categoriesList = new ArrayList<Category>();
            //Creation of some product categories
            Category categorie1 = new Category("Polos");
            Category categorie2 = new Category("Chaussures");
            Category categorie3 = new Category("Vestes");
            Category categorie4 = new Category("Pantalons");
            Category categorie5 = new Category("Accessoires");
            //Creation of 10 products for each categorie
            //Categorie1
            categorie1.add(new Product("Polo1", 1400, "Un tres bon pull", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie1.add(new Product("Polo2", 1500, "Un tres bon pull", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie1.add(new Product("Polo3", 1350, "Un tres bon pull", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie1.add(new Product("Polo4", 800, "Un tres bon pull", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie1.add(new Product("Polo5", 900, "Un tres bon pull", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie1.add(new Product("Polo6", 670, "Un tres bon pull", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie1.add(new Product("Polo7", 392, "Un tres bon pull", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie1.add(new Product("Polo8", 1400, "Un tres bon pull", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie1.add(new Product("Polo9", 1600, "Un tres bon pull", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie1.add(new Product("Polo10", 1090, "Un tres bon pull", R.drawable.blaser_homme_hiver, Consumer.MAN));

            categorie1.add(new Product("Polo1", 1400, "Un tres bon pull pour bébé", R.drawable.ailec, Consumer.KID));
            categorie1.add(new Product("Polo2", 1500, "Un tres bon pull pour bébé", R.drawable.ailec, Consumer.KID));
            categorie1.add(new Product("Polo3", 1350, "Un tres bon pull pour bébé", R.drawable.ailec, Consumer.KID));
            categorie1.add(new Product("Polo4", 800, "Un tres bon pull pour bébé", R.drawable.ailec, Consumer.KID));
            categorie1.add(new Product("Polo5", 900, "Un tres bon pull pour bébé", R.drawable.ailec, Consumer.KID));
            categorie1.add(new Product("Polo6", 670, "Un tres bon pull pour bébé", R.drawable.ailec, Consumer.KID));
            categorie1.add(new Product("Polo7", 392, "Un tres bon pull pour bébé", R.drawable.ailec, Consumer.KID));
            categorie1.add(new Product("Polo8", 1400, "Un tres bon pull pour bébé", R.drawable.ailec, Consumer.KID));
            categorie1.add(new Product("Polo9", 1600, "Un tres bon pull pour bébé", R.drawable.ailec, Consumer.KID));
            categorie1.add(new Product("Polo10", 1090, "Un tres bon pull pour bébé", R.drawable.ailec, Consumer.KID));

            categorie1.add(new Product("Polo1", 1400, "Un tres bon pull pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie1.add(new Product("Polo2", 1500, "Un tres bon pull pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie1.add(new Product("Polo3", 1350, "Un tres bon pull pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie1.add(new Product("Polo4", 800, "Un tres bon pull pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie1.add(new Product("Polo5", 900, "Un tres bon pull pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie1.add(new Product("Polo6", 670, "Un tres bon pull pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie1.add(new Product("Polo7", 392, "Un tres bon pull pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie1.add(new Product("Polo8", 1400, "Un tres bon pull pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie1.add(new Product("Polo9", 1600, "Un tres bon pull pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie1.add(new Product("Polo10", 1090, "Un tres bon pull pour femme", R.drawable.marin, Consumer.WOMAN));

            //Categorie2
            categorie2.add(new Product("Chaussure1", 1400, "Un belle chaussure", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie2.add(new Product("Chaussure2", 1500, "Un belle chaussure", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie2.add(new Product("Chaussure3", 1350, "Un belle chaussure", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie2.add(new Product("Chaussure4", 800, "Un belle chaussure", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie2.add(new Product("Chaussure5", 900, "Un belle chaussure", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie2.add(new Product("Chaussure6", 670, "Un belle chaussure", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie2.add(new Product("Chaussure7", 392, "Un belle chaussure", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie2.add(new Product("Chaussure8", 1400, "Un belle chaussure", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie2.add(new Product("Chaussure9", 1600, "Un belle chaussure", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie2.add(new Product("Chaussure10", 1090, "Un belle chaussure", R.drawable.blaser_homme_hiver, Consumer.MAN));

            categorie2.add(new Product("Chaussure1", 1400, "Un belle chaussure pour bébé", R.drawable.ailec, Consumer.KID));
            categorie2.add(new Product("Chaussure2", 1500, "Un belle chaussure pour bébé", R.drawable.ailec, Consumer.KID));
            categorie2.add(new Product("Chaussure3", 1350, "Un belle chaussure pour bébé", R.drawable.ailec, Consumer.KID));
            categorie2.add(new Product("Chaussure4", 800, "Un belle chaussure pour bébé", R.drawable.ailec, Consumer.KID));
            categorie2.add(new Product("Chaussure5", 900, "Un belle chaussure pour bébé", R.drawable.ailec, Consumer.KID));
            categorie2.add(new Product("Chaussure6", 670, "Un belle chaussure pour bébé", R.drawable.ailec, Consumer.KID));
            categorie2.add(new Product("Chaussure7", 392, "Un belle chaussure pour bébé", R.drawable.ailec, Consumer.KID));
            categorie2.add(new Product("Chaussure8", 1400, "Un belle chaussure pour bébé", R.drawable.ailec, Consumer.KID));
            categorie2.add(new Product("Chaussure9", 1600, "Un belle chaussure pour bébé", R.drawable.ailec, Consumer.KID));
            categorie2.add(new Product("Chaussure10", 1090, "Un belle chaussure pour bébé", R.drawable.ailec, Consumer.KID));

            categorie2.add(new Product("Chaussure1", 1400, "Un belle chaussure pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie2.add(new Product("Chaussure2", 1500, "Un belle chaussure pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie2.add(new Product("Chaussure3", 1350, "Un belle chaussure pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie2.add(new Product("Chaussure4", 800, "Un belle chaussure pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie2.add(new Product("Chaussure5", 900, "Un belle chaussure pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie2.add(new Product("Chaussure6", 670, "Un belle chaussure pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie2.add(new Product("Chaussure7", 392, "Un belle chaussure pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie2.add(new Product("Chaussure8", 1400, "Un belle chaussure pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie2.add(new Product("Chaussure9", 1600, "Un belle chaussure pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie2.add(new Product("Chaussure10", 1090, "Un belle chaussure pour femme", R.drawable.marin, Consumer.WOMAN));
            //Categorie3
            categorie3.add(new Product("veste1", 1400, "Un belle veste", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie3.add(new Product("veste2", 1500, "Un belle veste", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie3.add(new Product("veste3", 1350, "Un belle veste", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie3.add(new Product("veste4", 800, "Un belle veste", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie3.add(new Product("veste5", 900, "Un belle veste", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie3.add(new Product("veste6", 670, "Un belle veste", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie3.add(new Product("veste7", 392, "Un belle veste", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie3.add(new Product("veste8", 1400, "Un belle veste", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie3.add(new Product("veste9", 1600, "Un belle veste", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie3.add(new Product("veste10", 1090, "Un belle veste", R.drawable.blaser_homme_hiver, Consumer.MAN));

            categorie3.add(new Product("veste1", 1400, "Un belle veste pour bébé", R.drawable.ailec, Consumer.KID));
            categorie3.add(new Product("veste2", 1500, "Un belle veste pour bébé", R.drawable.ailec, Consumer.KID));
            categorie3.add(new Product("veste3", 1350, "Un belle veste pour bébé", R.drawable.ailec, Consumer.KID));
            categorie3.add(new Product("veste4", 800, "Un belle veste pour bébé", R.drawable.ailec, Consumer.KID));
            categorie3.add(new Product("veste5", 900, "Un belle veste pour bébé", R.drawable.ailec, Consumer.KID));
            categorie3.add(new Product("veste6", 670, "Un belle veste pour bébé", R.drawable.ailec, Consumer.KID));
            categorie3.add(new Product("veste7", 392, "Un belle veste pour bébé", R.drawable.ailec, Consumer.KID));
            categorie3.add(new Product("veste8", 1400, "Un belle veste pour bébé", R.drawable.ailec, Consumer.KID));
            categorie3.add(new Product("veste9", 1600, "Un belle veste pour bébé", R.drawable.ailec, Consumer.KID));
            categorie3.add(new Product("veste10", 1090, "Un belle veste pour bébé", R.drawable.ailec, Consumer.KID));

            categorie3.add(new Product("veste1", 1400, "Un belle veste pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie3.add(new Product("veste2", 1500, "Un belle veste pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie3.add(new Product("veste3", 1350, "Un belle veste pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie3.add(new Product("veste4", 800, "Un belle veste pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie3.add(new Product("veste5", 900, "Un belle veste pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie3.add(new Product("veste6", 670, "Un belle veste pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie3.add(new Product("veste7", 392, "Un belle veste pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie3.add(new Product("veste8", 1400, "Un belle veste pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie3.add(new Product("veste9", 1600, "Un belle veste pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie3.add(new Product("veste10", 1090, "Un belle veste pour femme", R.drawable.marin, Consumer.WOMAN));
            //Categorie4
            categorie4.add(new Product("pantalon1", 1400, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon2", 1500, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon3", 1350, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon4", 800, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon5", 900, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon6", 670, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon7", 392, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon8", 1400, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon9", 1600, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie4.add(new Product("pantalon10", 1090, "Un beau pantalon", R.drawable.blaser_homme_hiver, Consumer.MAN));

            categorie4.add(new Product("pantalon1", 1400, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon2", 1500, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon3", 1350, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon4", 800, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon5", 900, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon6", 670, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon7", 392, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon8", 1400, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon9", 1600, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));
            categorie4.add(new Product("pantalon10", 1090, "Un beau pantalon pour bébé", R.drawable.ailec, Consumer.KID));

            categorie4.add(new Product("pantalon1", 1400, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon2", 1500, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon3", 1350, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon4", 800, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon5", 900, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon6", 670, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon7", 392, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon8", 1400, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon9", 1600, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie4.add(new Product("pantalon10", 1090, "Un beau pantalon pour femme", R.drawable.marin, Consumer.WOMAN));
            //Categorie5
            categorie5.add(new Product("accessoire1", 1400, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire2", 1500, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire3", 1350, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire4", 800, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire5", 900, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire6", 670, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire7", 392, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire8", 1400, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire9", 1600, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));
            categorie5.add(new Product("accessoire10", 1090, "Un beau accessoire", R.drawable.blaser_homme_hiver, Consumer.MAN));

            categorie5.add(new Product("accessoire1", 1400, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire2", 1500, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire3", 1350, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire4", 800, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire5", 900, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire6", 670, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire7", 392, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire8", 1400, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire9", 1600, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));
            categorie5.add(new Product("accessoire10", 1090, "Un beau accessoire pour bébé", R.drawable.ailec, Consumer.KID));

            categorie5.add(new Product("accessoire1", 1400, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire2", 1500, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire3", 1350, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire4", 800, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire5", 900, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire6", 670, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire7", 392, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire8", 1400, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire9", 1600, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));
            categorie5.add(new Product("accessoire10", 1090, "Un beau accessoire pour femme", R.drawable.marin, Consumer.WOMAN));

            //Adding categories to the categories list
            categoriesList.add(categorie1);
            categoriesList.add(categorie2);
            categoriesList.add(categorie3);
            categoriesList.add(categorie4);
            categoriesList.add(categorie5);
        }
    }

    public void showChartActivity(MenuItem item) {
        Intent intent = new Intent(this,CartActivity.class);
        startActivity(intent);
    }


    @Override
    public void showProductDetaills(Product product) {
        Toast.makeText(this,product.getConsumer().toString()+" to detaille",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ProductDetailActivity.class);
        intent.putExtra("product",product);
        startActivity(intent);

    }

    @Override
    public void addProductToCart(Product product) {
       addProductToSCart(MainActivity.this, product);
    }
    public static void addProductToSCart(Context context,Product product) {
        CartElement cartElement = new CartElement(product);
        int q = cart.add(cartElement);
        if (q==1){
            Toast.makeText(context, "Produit ajouté au chariot", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Produit existant, quantité incrémentée "+q, Toast.LENGTH_SHORT).show();
        }
    }

    public static Cart getCart() {
        return cart;
    }

    public static void setCart(Cart cart) {
        MainActivity.cart = cart;
    }

    public static boolean connect(String user,String password){
        if(user.equals("admin")&&password.equals("admin")){
            setConnected(true);
        }
        else{
            setConnected(false);
        }
        return connected;
    }

    public static boolean isConnected() {
        return connected;
    }

    public static void setConnected(boolean connected) {
        MainActivity.connected = connected;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static void setOrders(ArrayList<Order> orders) {
        MainActivity.orders = orders;
    }

    public void validateCartAsOrder(Cart cart){
        orders.add(new Order(cart));
    }

    public void showOrdersActivity(MenuItem item) {
        Intent intent = new Intent(this,OrdersActivity.class);
        startActivity(intent);
    }
    public ArrayList<Product> filterProductsByConsumer(Category productsList,Consumer consumer){
        ArrayList<Product> list = new ArrayList<>();
        for(int i=0;i<productsList.size();i++){
            if(productsList.get(i).getConsumer()==consumer){
                list.add(productsList.get(i));
            }
        }
        return list;
    }

}