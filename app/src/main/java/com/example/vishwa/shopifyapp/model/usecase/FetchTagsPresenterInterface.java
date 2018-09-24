package com.example.vishwa.shopifyapp.model.usecase;

import com.example.vishwa.shopifyapp.model.entities.Product;

import java.util.List;

public interface FetchTagsPresenterInterface {
    void onErrorFetchingTags();

    void onSuccess(List<Product> productList);
}
