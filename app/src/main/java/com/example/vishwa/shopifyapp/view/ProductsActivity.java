package com.example.vishwa.shopifyapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.vishwa.shopifyapp.R;
import com.example.vishwa.shopifyapp.model.entities.Product;
import com.example.vishwa.shopifyapp.presenter.ProductsPresenterImpl;
import com.example.vishwa.shopifyapp.presenter.entities.ProductsPresenter;
import com.example.vishwa.shopifyapp.view.adapter.ProductsAdapter;
import com.example.vishwa.shopifyapp.view.entities.ProductView;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.List;

public class ProductsActivity extends AppCompatActivity implements ProductView {

    private ProductsPresenter productsPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent intent = getIntent();

        String tagString = intent.getStringExtra("tag_name");

        recyclerView = findViewById(R.id.product_recycler_view);

        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getApplicationContext());

        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);

        flexboxLayoutManager.setJustifyContent(JustifyContent.CENTER);

        flexboxLayoutManager.setAlignItems(JustifyContent.CENTER);

        productsPresenter = new ProductsPresenterImpl();
        productsPresenter.bindView(this);
        productsPresenter.showProducts(tagString);

        recyclerView.setLayoutManager(flexboxLayoutManager);
    }

    @Override
    public void onProductsFound(List<Product> products) {
        ProductsAdapter productsAdapter = new ProductsAdapter(getApplicationContext(), products);
        recyclerView.setAdapter(productsAdapter);
        Toast.makeText(this, "Products successfully loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Error loading products", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        productsPresenter.unbindView();
        super.onDestroy();
    }
}
