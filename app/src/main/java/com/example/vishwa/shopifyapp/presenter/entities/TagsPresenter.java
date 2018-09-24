package com.example.vishwa.shopifyapp.presenter.entities;

import android.view.View;

import com.example.vishwa.shopifyapp.model.usecase.FetchTagsPresenterInterface;
import com.example.vishwa.shopifyapp.view.entities.TagView;

public interface TagsPresenter extends FetchTagsPresenterInterface {

    void showTags();

    void tagClicked(View view);

    void bindView(TagView tagView);

    void unbindView();
}
