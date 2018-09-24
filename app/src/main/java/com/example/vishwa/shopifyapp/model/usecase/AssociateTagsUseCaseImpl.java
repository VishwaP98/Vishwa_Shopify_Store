package com.example.vishwa.shopifyapp.model.usecase;

import android.util.Log;

import com.example.vishwa.shopifyapp.model.entities.Product;
import com.example.vishwa.shopifyapp.model.entities.Products;
import com.example.vishwa.shopifyapp.model.entities.Tag;
import com.example.vishwa.shopifyapp.model.entities.TagsList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssociateTagsUseCaseImpl implements AssociateTagsUseCase {

    public AssociateTagsUseCaseImpl() {

    }

    @Override
    public TagsList associateTags(List<Product> products) {
        Map<String, List<Product>> productsMap = new HashMap<>();
        for(Product product : products){
            String[] productTags = product.getTags().split(", ");

            for(String tag : productTags) {
                Log.i("Testing", "The tag is " + tag + ".");
                if (!productsMap.containsKey(tag)) {
                    Log.i("Testing", "This tag is not in the map");
                    List<Product> productList = new ArrayList<>();
                    productList.add(product);
                    productsMap.put(tag, productList);
                } else {
                    Log.i("Testing", "This tag is in the map");
                    // if key already there, then just append
                    productsMap.get(tag).add(product);
                }
            }
        }

        TagsList tagsList = new TagsList(productsMap);

        for(String tagString : productsMap.keySet()) {
            Tag tag = new Tag(tagString, productsMap.get(tagString));
            tagsList.addTag(tag);
            Log.i("Testing", tagString + " -- > ");
            for(Product product1 : productsMap.get(tagString)) {
                Log.i("Testing", product1.getTitle());
            }
        }

        // pass the tagsList for the adapter

        return tagsList;
    }
}
