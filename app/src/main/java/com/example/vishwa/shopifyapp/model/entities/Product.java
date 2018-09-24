package com.example.vishwa.shopifyapp.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("body_html")
    @Expose
    private String description;

    @SerializedName("vendor")
    @Expose
    private String vendor;

    @SerializedName("product_type")
    @Expose
    private String type;

    @SerializedName("tags")
    @Expose
    private String tags;

    @SerializedName("variants")
    @Expose
    private List<Variant> variants;

    private long variantsInventorySum = 0L;

    @SerializedName("image")
    @Expose
    private Image image;

    public Product(){

    }

    public String getTags() {
        return tags;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public long getVariantsInventorySum() {
        return variantsInventorySum;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariantsInventorySum(long variantsInventorySum) {
        this.variantsInventorySum = variantsInventorySum;
    }

    public Image getImage() {
        return image;
    }

}
