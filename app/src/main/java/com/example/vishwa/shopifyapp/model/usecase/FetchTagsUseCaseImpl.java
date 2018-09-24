package com.example.vishwa.shopifyapp.model.usecase;

import android.util.Log;

import com.example.vishwa.shopifyapp.model.retrofit.GetProductsService;
import com.example.vishwa.shopifyapp.model.retrofit.RetrofitClient;
import com.example.vishwa.shopifyapp.model.entities.Product;
import com.example.vishwa.shopifyapp.model.entities.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchTagsUseCaseImpl implements FetchTagsUseCase {

    public FetchTagsUseCaseImpl() {

    }

    @Override
    public void fetchTags(final FetchTagsPresenterInterface presenterInterface) {

        GetProductsService service = RetrofitClient.getRetrofitClient().create(GetProductsService.class);
        Call<Products> products = service.getAllProducts();

        products.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                Products productList = response.body();

                List<Product> products = productList.getProductsList();

                presenterInterface.onSuccess(products);
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                Log.i("Testing", "Something went wrong. Try again " + t);
                presenterInterface.onErrorFetchingTags();
            }
        });
    }
}