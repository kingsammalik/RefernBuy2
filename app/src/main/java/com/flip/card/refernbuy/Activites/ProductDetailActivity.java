package com.flip.card.refernbuy.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flip.card.refernbuy.R;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        getSupportActionBar().hide();
    }
}
