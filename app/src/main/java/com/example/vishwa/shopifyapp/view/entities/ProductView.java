package com.example.vishwa.shopifyapp.view.entities;

import com.example.vishwa.shopifyapp.model.entities.Product;

import java.util.List;

public interface ProductView {

    void onProductsFound(List<Product> products);

    void onError();
}
