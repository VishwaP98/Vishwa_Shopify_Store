package com.example.vishwa.shopifyapp.model.retrofit;

import com.example.vishwa.shopifyapp.model.entities.Products;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetProductsService {

    @GET("/admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<Products> getAllProducts();
}
