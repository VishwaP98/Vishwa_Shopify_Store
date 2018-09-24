package com.example.vishwa.shopifyapp.presenter.entities;

import com.example.vishwa.shopifyapp.view.entities.ProductView;

public interface ProductsPresenter {

    void showProducts(String tagString);

    void bindView(ProductView view);

    void unbindView();
}