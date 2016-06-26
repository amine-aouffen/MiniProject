package tdm.miniproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import tdm.miniproject.R;
import tdm.miniproject.adapters.CategoryAdapter;
import tdm.miniproject.adapters.PagerAdapter;


import tdm.miniproject.handlers.ProductFragmentHandler;
import tdm.miniproject.managers.HttpManager;

public class MainActivity extends AppCompatActivity {

    private PagerAdapter pagerAdapter;
    private ViewPager viewPager;
    private Spinner categorySpinner;
    private  static int spinnerIndex=-1;
    private  static int tabIndex=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseToolBar();
        initialiseSpinner();
        initialiseTabNavigation();
    }

    public void initialiseToolBar(){
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.mainToolBar);
        setSupportActionBar(mainToolbar);
    }

    public void initialiseTabNavigation(){

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),new ProductFragmentHandler(this,R.id.twoPanesFragment));
        viewPager = (ViewPager) findViewById(R.id.mainViewPager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        if(tabIndex!=-1) viewPager.setCurrentItem(tabIndex);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initialiseSpinner() {
        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        CategoryAdapter categoryAdapter = new CategoryAdapter(this);
        categorySpinner.setAdapter(categoryAdapter);
        if(spinnerIndex!=-1) categorySpinner.setSelection(spinnerIndex);
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pagerAdapter.setCategoryByPosition(position);
                pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void showChartActivity(MenuItem item) {
            Intent intent = new Intent(this,CartActivity.class);
            startActivity(intent);
    }

    public void showOrdersActivity(MenuItem item) {
        Intent intent = new Intent(this,OrdersActivity.class);
        startActivity(intent);
    }


   /* protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("spinnerIndex", categorySpinner.getSelectedItemPosition());
        outState.putInt("tabIndex", viewPager.getCurrentItem());

    }*/
/*
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
        //TODO uncomment for showing first product after flip
       if (isTwoPanes()){
            int l = spinnerIndex;
            if(l!=-1)
            switch (tabIndex){
                case 0:

                    for(int k = 0; k<= productByCatLists.get(l).size(); k++){
                        if (productByCatLists.get(l).get(k).getConsumer()==Consumer.MAN){
                            showProductDetailsInFrag(productByCatLists.get(l).get(k));
                            break;
                        }
                    }
                    break;
                case 1:
                    for(int k = 0; k<= productByCatLists.get(l).size(); k++){
                        if (productByCatLists.get(l).get(k).getConsumer()==Consumer.WOMAN){
                            showProductDetailsInFrag(productByCatLists.get(l).get(k));
                            break;
                        }
                    }
                    break;
                case 2:
                    for(int k = 0; k<= productByCatLists.get(l).size(); k++){
                        if (productByCatLists.get(l).get(k).getConsumer()==Consumer.KID){
                            showProductDetailsInFrag(productByCatLists.get(l).get(k));
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }


    }
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //TODO get the notification  status from local source
        boolean notification=false;
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