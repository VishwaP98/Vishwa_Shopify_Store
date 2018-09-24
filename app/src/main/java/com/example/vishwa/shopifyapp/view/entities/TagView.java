package com.example.vishwa.shopifyapp.view.entities;

import android.view.View;

import com.example.vishwa.shopifyapp.model.entities.Tag;

import java.util.List;

public interface TagView {

    void onTagsFound(List<Tag> tagList);

    void onError();

    void openProductsPage(View view);

    boolean isNetworkAvailable();
}
