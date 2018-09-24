package com.example.vishwa.shopifyapp.presenter;

import android.util.Log;
import android.view.View;

import com.example.vishwa.shopifyapp.model.entities.Product;
import com.example.vishwa.shopifyapp.model.entities.TagsList;
import com.example.vishwa.shopifyapp.model.usecase.AssociateTagsUseCase;
import com.example.vishwa.shopifyapp.model.usecase.AssociateTagsUseCaseImpl;
import com.example.vishwa.shopifyapp.model.usecase.FetchTagsUseCase;
import com.example.vishwa.shopifyapp.model.usecase.SumProductInventoryUseCase;
import com.example.vishwa.shopifyapp.model.usecase.SumProductInventoryUseCaseImpl;
import com.example.vishwa.shopifyapp.presenter.entities.TagsPresenter;
import com.example.vishwa.shopifyapp.view.entities.TagView;

import java.util.List;

public class TagsPresenterImpl implements TagsPresenter {

    private TagView tagView;

    private FetchTagsUseCase fetchTagsUseCase;

    public TagsPresenterImpl(FetchTagsUseCase fetchTagsUseCase) {
        this.fetchTagsUseCase = fetchTagsUseCase;
    }

    @Override
    public void showTags() {
        // run the usecase
        Log.i("Testing", "Network available " + tagView.isNetworkAvailable());
        if(!tagView.isNetworkAvailable()){
            tagView.onError();
        }

        fetchTagsUseCase.fetchTags(this);
    }

    @Override
    public void tagClicked(View view) {
        // open the ProductsActivity
        tagView.openProductsPage(view);
    }

    @Override
    public void bindView(TagView tagView) {
        this.tagView = tagView;
    }

    @Override
    public void onErrorFetchingTags() {
        tagView.onError();
    }

    @Override
    public void onSuccess(List<Product> productList) {
        // Run the associate tags usecase
        AssociateTagsUseCase associateTagsUseCase = new AssociateTagsUseCaseImpl();
        TagsList tags = associateTagsUseCase.associateTags(productList);

        SumProductInventoryUseCase sumProductInventoryUseCase = new SumProductInventoryUseCaseImpl();
        sumProductInventoryUseCase.sumVariantsInventory(productList);

        // Successfully found the tags!
        tagView.onTagsFound(tags.getTagList());
    }

    @Override
    public void unbindView() {
        this.tagView = null;
    }
}
