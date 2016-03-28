package tdm.miniproject.activities;

import tdm.miniproject.R;
import tdm.miniproject.adapters.CategoryAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Spinner;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        initialiseToolBar();
    }

    public void initialiseToolBar(){
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.chartToolBar);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Icon getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_favorite_black);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cart,menu);

        return true;
    }
}
