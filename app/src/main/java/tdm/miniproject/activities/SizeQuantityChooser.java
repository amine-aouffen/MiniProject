package tdm.miniproject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import tdm.miniproject.R;
import tdm.miniproject.job.Product;
import tdm.miniproject.managers.HttpManager;
import tdm.miniproject.managers.RequestManager;
import tdm.miniproject.support.CartOperationRequest;
import tdm.miniproject.support.CartOperationResponse;
import tdm.miniproject.tasks.AddToCartTask;

public class SizeQuantityChooser extends AppCompatActivity {
    private Spinner sizeChooser;
    private NumberPicker numberPicker;
    private ProgressBar progress;
    private Button validateButton;
    private Button cancelButton;
    private Product product;
    private List<String> sizes;
    private List<Integer> quantities;
    private TextView txtSize;
    private TextView txtQuant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size_quantity_chooser);
        prepareViews();
    }

    public void prepareViews(){
        progress = (ProgressBar) findViewById(R.id.progressBar);
        sizeChooser = (Spinner) findViewById(R.id.sqChooser);
        numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        validateButton=(Button) findViewById(R.id.validateBtn);
        cancelButton = (Button) findViewById(R.id.cancelBtn);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txtQuant=(TextView) findViewById(R.id.quantityTextView);
        txtSize=(TextView)findViewById(R.id.sizeTextView) ;
        executeMethode();

    }

    private void executeMethode() {
        Intent intent = getIntent();
        if(intent!=null){
            product = (Product) intent.getSerializableExtra("product");
            CartOperationRequest cartOperationRequest = new CartOperationRequest();
            cartOperationRequest.setProductName(product.getName());
            cartOperationRequest.setType("CHECK");
            new CheckCartTask().execute(cartOperationRequest);
        }
    }

    public void setUpChooser() {
        sizeChooser.setAdapter(new SpinAdapter(this));
        sizeChooser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                numberPicker.setMaxValue(quantities.get(position));
                numberPicker.setMinValue(1);
                numberPicker.setValue(1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void endActivity(){
        finish();
    }
    public void setUpValidateListener(){
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO executer la tache AddCartTask
                CartOperationRequest cartOperationRequest = new CartOperationRequest();
                cartOperationRequest.setProductName(product.getName());
                cartOperationRequest.setQuantity(numberPicker.getValue()*-1);
                cartOperationRequest.setSize((String)sizeChooser.getSelectedItem());
                cartOperationRequest.setType("MATH_OPERATION");
                new AddToCartTask(v.getContext(),product,(String)sizeChooser.getSelectedItem(),numberPicker.getValue(),null).execute(cartOperationRequest);
            }
        });
    }

    public void startProgress(){
        numberPicker.setVisibility(View.INVISIBLE);
        sizeChooser.setVisibility(View.INVISIBLE);
        txtQuant.setVisibility(View.INVISIBLE);
        txtSize.setVisibility(View.INVISIBLE);
    }

    public void stopProgress(){
        numberPicker.setVisibility(View.VISIBLE);
        sizeChooser.setVisibility(View.VISIBLE);
        txtQuant.setVisibility(View.VISIBLE);
        txtSize.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);

    }

    public class CheckCartTask extends AsyncTask<CartOperationRequest,Void,String> {


        public CheckCartTask() {

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            startProgress();
        }

        @Override
        protected String doInBackground(CartOperationRequest ... params) {
            String json = new Gson().toJson(params[0],CartOperationRequest.class);

            String result = new HttpManager().postDataToServiceURI(RequestManager.getRequestCartCheck(),json);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            CartOperationResponse response = new Gson().fromJson(s,CartOperationResponse.class);

            if(response.getCode()==-1){
                Toast.makeText(getApplicationContext(), "Produit non disponible !", Toast.LENGTH_SHORT).show();
                endActivity();
            }else{

                sizes=response.getSizes();
                quantities=response.getQuantities();
                setUpChooser();
                setUpValidateListener();
                stopProgress();
            }
        }
    }



    public class SpinAdapter extends BaseAdapter {
        private Context context;
        public SpinAdapter(Context context) {
            this.context=context;
        }

        @Override
        public int getCount() {
            return sizes.size();
        }

        @Override
        public Object getItem(int position) {
            return sizes.get(position) ;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(context);
            textView.setText(sizes.get(position));
            return textView;
        }



    }
}
