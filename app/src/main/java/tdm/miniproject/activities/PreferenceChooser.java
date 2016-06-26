package tdm.miniproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import tdm.miniproject.R;
import tdm.miniproject.job.Product;

public class PreferenceChooser extends AppCompatActivity {
    private Spinner spinner;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_chooser);
        prepareViews();
    }

    public void prepareViews(){
        Intent intent = getIntent();
        if(intent!=null){
            product = (Product) intent.getSerializableExtra("product");
            //TODO change the name of the activity to preference name

        }

    }
}
