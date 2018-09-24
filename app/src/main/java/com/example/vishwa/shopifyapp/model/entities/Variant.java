package com.example.vishwa.shopifyapp.model.entities;

import com.google.gson.annotations.SerializedName;

public class Variant {

    @SerializedName("id")
    private long id;

    @SerializedName("product_id")
    private long productId;

    @SerializedName("title")
    private String title;

    @SerializedName("price")
    private double price;

    @SerializedName("inventory_quantity")
    private long quantity;

    public long getId(){
        return id;
    }

    public long getProductId(){
        return productId;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public long getQuantity(){
        return quantity;
    }
}