package com.example.vishwa.shopifyapp.model.entities;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("id")
    private long imageId;

    @SerializedName("product_id")
    private long productId;

    @SerializedName("src")
    private String imageUrl;

    public long getImageId() {
        return imageId;
    }

    public long getProductId() {
        return productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
