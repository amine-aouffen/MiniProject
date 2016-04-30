package tdm.miniproject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import tdm.miniproject.R;
import tdm.miniproject.adapters.CategoryAdapter;
import tdm.miniproject.adapters.PagerAdapter;
import tdm.miniproject.data.ProductData;
import tdm.miniproject.fragments.ProductDetailFragment;
import tdm.miniproject.job.Cart;
import tdm.miniproject.job.Category;
import tdm.miniproject.job.Consumer;
import tdm.miniproject.job.Order;
import tdm.miniproject.job.Product;
import tdm.miniproject.support.CartElement;
import tdm.miniproject.support.ProductListFragmentListener;

public class MainActivity extends AppCompatActivity implements ProductListFragmentListener{
    private ArrayList<Category> categoriesList;
    private static Cart cart = new Cart();
    ;
    private static boolean notification=true;
    private static boolean connected;
    private static ArrayList<Order> orders = new ArrayList<Order>();
    private PagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private Spinner categorySpinner;
    private static  int spinnerIndex=-1;
    private static int tabIndex=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateExamples();
        initialiseToolBar();
        initialiseSpinner();
        initialiseTabNavigation();
    }

    public void initialiseToolBar(){
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.mainToolBar);
        setSupportActionBar(mainToolbar);
    }

    public void initialiseTabNavigation(){
        if(spinnerIndex!=-1)  pagerAdapter = new PagerAdapter(getSupportFragmentManager(),categoriesList.get(spinnerIndex),this);
        else pagerAdapter = new PagerAdapter(getSupportFragmentManager(),categoriesList.get(categorySpinner.getSelectedItemPosition()),this);
        viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        if(tabIndex!=-1) viewPager.setCurrentItem(tabIndex);

//        // Iterate over all tabs and set the custom view
//        for (int i = 0; i < tabLayout.getTabCount(); i++) {
//            TabLayout.Tab tab = tabLayout.getTabAt(i);
//            tab.setCustomView(pagerAdapter.getTabView(i));
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initialiseSpinner() {
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoriesList);
        categorySpinner.setAdapter(categoryAdapter);
        if(spinnerIndex!=-1) categorySpinner.setSelection(spinnerIndex);
        if(spinnerIndex==-1&&isTwoPanes()) showProductDetailsInFrag(categoriesList.get(0).get(0));
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pagerAdapter.dispatchCategoryToLists(categoriesList.get(position));
                //pagerAdapter.updateFraments();
                pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void generateExamples(){
        ProductData productData = new ProductData();
        categoriesList = productData.getCategoriesList();
    }

    public void showChartActivity(MenuItem item) {
            Intent intent = new Intent(this,CartActivity.class);
            startActivity(intent);
    }


    @Override
    public void showProductDetails(Product product) {
        if(!isTwoPanes()) {
            Intent intent = new Intent(this, ProductDetailActivity.class);
            intent.putExtra("product", product);
            startActivity(intent);
        }else{
            showProductDetailsInFrag(product);
        }
    }

    private void showProductDetailsInFrag(Product product) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", product);
        ProductDetailFragment fragment = new ProductDetailFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.twoPanesFragment,fragment);
        fragTransaction.commit();
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

    public void showOrdersActivity(MenuItem item) {
        Intent intent = new Intent(this,OrdersActivity.class);
        startActivity(intent);
    }




    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("spinnerIndex", categorySpinner.getSelectedItemPosition());
        outState.putInt("tabIndex", viewPager.getCurrentItem());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int i = savedInstanceState.getInt("spinnerIndex",-1);
        if(i!=-1){
            spinnerIndex = i;
        }

        int j = savedInstanceState.getInt("tabIndex",-1);
        if(j!=-1){
            tabIndex=j;
        }
        if (isTwoPanes()){
            int l = spinnerIndex;
            if(l!=-1)
            switch (tabIndex){
                case 0:

                    for(int k = 0;k<=categoriesList.get(l).size();k++){
                        if (categoriesList.get(l).get(k).getConsumer()==Consumer.MAN){
                            showProductDetailsInFrag(categoriesList.get(l).get(k));
                            break;
                        }
                    }
                    break;
                case 1:
                    for(int k = 0;k<=categoriesList.get(l).size();k++){
                        if (categoriesList.get(l).get(k).getConsumer()==Consumer.WOMAN){
                            showProductDetailsInFrag(categoriesList.get(l).get(k));
                            break;
                        }
                    }
                    break;
                case 2:
                    for(int k = 0;k<=categoriesList.get(l).size();k++){
                        if (categoriesList.get(l).get(k).getConsumer()==Consumer.KID){
                            showProductDetailsInFrag(categoriesList.get(l).get(k));
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.notificationToggle:
                if(notification==true){
                    notification=false;
                    Toast.makeText(MainActivity.this, "Les notifications sont désactivées. ", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.ic_notifications_off_white_24dp);
                }
                else{
                    notification=true;
                    Toast.makeText(MainActivity.this, "Les notifications sont activées. ", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.ic_notifications_white_24dp);
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    boolean isTwoPanes(){
        if(findViewById(R.id.twoPanesFragment)==null){
            return false;
        }
        return true;
    }
}