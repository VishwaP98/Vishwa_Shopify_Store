package com.example.vishwa.shopifyapp.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.vishwa.shopifyapp.R;
import com.example.vishwa.shopifyapp.model.entities.Product;
import com.example.vishwa.shopifyapp.view.viewHolder.ProductViewHolder;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private Context context;
    private List<Product> products;
    private LayoutInflater layoutInflater;

    public ProductsAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.products_item, viewGroup, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
        Log.i("Testing", i + " --- title is " + products.get(i).getTitle());
        productViewHolder.getTitle().setText(products.get(i).getTitle());
        productViewHolder.getTitle().setTextSize(25);

        String message = "Units Available : ";
        productViewHolder.getInventoryQuantity().setText(String.valueOf(message + products.get(i).getVariantsInventorySum()));
        productViewHolder.getInventoryQuantity().setTextSize(20);
        Uri uri = Uri.parse(products.get(i).getImage().getImageUrl());
        ImageView imageView = productViewHolder.getImageView();
        Glide.with(context).load(uri).into(imageView);
    }

    @Override
    public int getItemCount() {
        if(products == null) {
            return 0;
        }

        return products.size();
    }
}
