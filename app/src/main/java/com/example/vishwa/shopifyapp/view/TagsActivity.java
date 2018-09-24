package com.example.vishwa.shopifyapp.view;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vishwa.shopifyapp.R;
import com.example.vishwa.shopifyapp.model.entities.Tag;
import com.example.vishwa.shopifyapp.model.usecase.FetchTagsUseCaseImpl;
import com.example.vishwa.shopifyapp.presenter.TagsPresenterImpl;
import com.example.vishwa.shopifyapp.presenter.entities.TagsPresenter;
import com.example.vishwa.shopifyapp.view.adapter.TagsAdapter;
import com.example.vishwa.shopifyapp.view.entities.TagView;
import com.example.vishwa.shopifyapp.view.entities.TagsClickListener;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.List;

public class TagsActivity extends AppCompatActivity implements TagView, TagsClickListener {

    private TagsPresenter tagsPresenter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);

        recyclerView = findViewById(R.id.tag_recycler_view);

        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getApplicationContext());

        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);

        flexboxLayoutManager.setJustifyContent(JustifyContent.CENTER);

        flexboxLayoutManager.setAlignItems(AlignItems.CENTER);

        recyclerView.setLayoutManager(flexboxLayoutManager);

        tagsPresenter = new TagsPresenterImpl(new FetchTagsUseCaseImpl());
        tagsPresenter.bindView(this);
        tagsPresenter.showTags();
    }

    @Override
    public void onTagsFound(List<Tag> tagList) {
        TagsAdapter tagsAdapter = new TagsAdapter(this, tagList, this);

        recyclerView.setAdapter(tagsAdapter);

        Toast.makeText(this, "Successfully loaded tags", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Error loading tags", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openProductsPage(View view) {
        // Moving to Products Activity

        TextView textView = view.findViewById(R.id.tag_string);

        String tagString = textView.getText().toString();

        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("tag_name", tagString);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        tagsPresenter.tagClicked(v);
    }


    @Override
    protected void onDestroy() {
        tagsPresenter.unbindView();
        super.onDestroy();
    }

    @Override
    public boolean isNetworkAvailable() {
        // Check if network connection is there, then only get info from rest api
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch(NullPointerException exception) {
            Toast.makeText(this, "Error Collecting information about network", Toast.LENGTH_SHORT).show();
            return false;
        }

        return networkInfo != null && networkInfo.isConnected();
    }
}
