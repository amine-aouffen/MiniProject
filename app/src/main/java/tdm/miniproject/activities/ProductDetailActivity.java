package tdm.miniproject.activities;

import tdm.miniproject.R;
import tdm.miniproject.job.Product;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {
    private TextView productName;
    private TextView productDesc;
    private TextView productCara;
    private TextView productPrice;
    private ImageView productPhoto;
    private Button addToCartBtn;
    private Product product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        initialiseToolBar();
        findViews();
        showProductDetails();

    }
    public void initialiseToolBar(){
        Toolbar detailToolbar = (Toolbar) findViewById(R.id.productDetailToolBar);
        setSupportActionBar(detailToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_store_white_24dp);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu);

        return true;
    }
    public void findViews(){
        productName = (TextView)findViewById(R.id.productDetailName);
        productDesc= (TextView)findViewById(R.id.productDetailDesc);
        productPrice= (TextView)findViewById(R.id.productDetailPrice);
        productPhoto= (ImageView)findViewById(R.id.productDetailImage);
        productCara= (TextView)findViewById(R.id.productDetailCara);
        addToCartBtn = (Button) findViewById(R.id.productDetailAddCart);
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductToCart();
            }
        });

    }

    public void showProductDetails(){
        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("product");
        productName.setText(product.getName());
        productDesc.setText(product.getDescription());
        productPrice.setText(product.getPrice()+" DA");
        productPhoto.setImageResource(product.getProductPhoto());
        productCara.setText("- 100% Couton\n" +
                "- Fabriqué en Italy\n" +
                "- Caractéristique ici\n" +
                "- Dernière caractéristique");
    }

    public void addProductToCart() {
        MainActivity.addProductToSCart(ProductDetailActivity.this, product);
    }

    public void showChartActivity(MenuItem item) {
        Intent intent = new Intent(this,CartActivity.class);
        startActivity(intent);
    }
}
