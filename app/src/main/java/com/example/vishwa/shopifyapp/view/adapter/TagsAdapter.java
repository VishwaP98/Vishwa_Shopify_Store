package com.example.vishwa.shopifyapp.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vishwa.shopifyapp.R;
import com.example.vishwa.shopifyapp.view.viewHolder.TagViewHolder;
import com.example.vishwa.shopifyapp.view.entities.TagsClickListener;
import com.example.vishwa.shopifyapp.model.entities.Tag;

import java.util.List;

public class TagsAdapter extends RecyclerView.Adapter<TagViewHolder> {

    private List<Tag> tagStrings;
    private Context context;
    private LayoutInflater layoutInflater;
    private TagsClickListener tagsClickListener;

    public TagsAdapter(Context context, List<Tag> tagStrings, TagsClickListener listener) {
        this.context = context;
        this.tagStrings = tagStrings;
        this.layoutInflater = LayoutInflater.from(context);
        this.tagsClickListener = listener;
    }

    @NonNull
    @Override
    public TagViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.tags_item, viewGroup, false);
        view.setOnClickListener(tagsClickListener);
        TagViewHolder tagViewHolder = new TagViewHolder(view);
        return tagViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TagViewHolder tagViewHolder, int i) {
        tagViewHolder.getTagStringTextView().setText(tagStrings.get(i).getTagString());
        tagViewHolder.getTagStringTextView().setTextSize(25);
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if(tagStrings != null){
            size = tagStrings.size();
        }
        return size;
    }
}
