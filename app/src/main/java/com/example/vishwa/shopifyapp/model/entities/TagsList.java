package com.example.vishwa.shopifyapp.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TagsList {

    private List<Tag> tagList;
    private static Map<String, List<Product>> tagsMap;

    public TagsList(Map<String, List<Product>> map) {
        tagList = new ArrayList<>();
        tagsMap = map;
    }

    public static List<Product> findProducts(String tagString) {
        if(tagsMap == null || !tagsMap.containsKey(tagString)){
            return null;
        }

        return tagsMap.get(tagString);
    }

    public void addTag(Tag tag) {
        tagList.add(tag);
    }

    public List<Tag> getTagList() {
        return tagList;
    }
}