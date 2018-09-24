package com.example.vishwa.shopifyapp.model.entities;

import java.util.List;

public class Tag {

    private String tagString;
    private List<Product> products;

    public Tag(String tagString, List<Product> products){
        this.tagString = tagString;
        this.products = products;
    }

    public String getTagString() {
        return tagString;
    }

    public List<Product> getProducts() {
        return products;
    }
}
