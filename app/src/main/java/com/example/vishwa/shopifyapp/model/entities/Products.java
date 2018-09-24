package com.example.vishwa.shopifyapp.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Products {

    @SerializedName("products")
    @Expose
    private List<Product> productsList = new ArrayList<>();

    public List<Product> getProductsList(){
        return productsList;
    }
}
