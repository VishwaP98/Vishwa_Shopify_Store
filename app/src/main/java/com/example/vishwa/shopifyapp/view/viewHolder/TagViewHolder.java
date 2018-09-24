package com.example.vishwa.shopifyapp.view.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vishwa.shopifyapp.R;

public class TagViewHolder extends RecyclerView.ViewHolder {

    private TextView tagString;

    public TagViewHolder(@NonNull View itemView) {
        super(itemView);

        tagString = itemView.findViewById(R.id.tag_string);
    }

    public TextView getTagStringTextView() {
        return tagString;
    }
}
