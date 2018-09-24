package com.example.vishwa.shopifyapp.presenter;

import android.util.Log;

import com.example.vishwa.shopifyapp.model.entities.Product;
import com.example.vishwa.shopifyapp.model.entities.TagsList;
import com.example.vishwa.shopifyapp.presenter.entities.ProductsPresenter;
import com.example.vishwa.shopifyapp.view.entities.ProductView;

import java.util.List;

public class ProductsPresenterImpl implements ProductsPresenter {

    private ProductView productView;

    public ProductsPresenterImpl() {

    }

    @Override
    public void bindView(ProductView view) {
        productView = view;
    }

    @Override
    public void unbindView() {
        productView = null;
    }

    @Override
    public void showProducts(String tagString) {
        Log.i("Testing", "The tag string is " + tagString);

        List<Product> productList = TagsList.findProducts(tagString);

        Log.i("Testing", "Size of productList is " + productList.size());

        productView.onProductsFound(productList);
    }
}
