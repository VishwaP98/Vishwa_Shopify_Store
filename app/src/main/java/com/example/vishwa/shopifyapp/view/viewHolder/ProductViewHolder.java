package com.example.vishwa.shopifyapp.view.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vishwa.shopifyapp.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    private TextView title;

    private TextView inventoryQuantity;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.product_image);
        title = itemView.findViewById(R.id.product_title);
        inventoryQuantity = itemView.findViewById(R.id.product_quantity);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getInventoryQuantity() {
        return inventoryQuantity;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
