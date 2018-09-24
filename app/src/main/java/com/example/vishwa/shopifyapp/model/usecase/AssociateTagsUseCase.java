package com.example.vishwa.shopifyapp.model.usecase;

import com.example.vishwa.shopifyapp.model.entities.Product;
import com.example.vishwa.shopifyapp.model.entities.TagsList;

import java.util.List;

public interface AssociateTagsUseCase {

    TagsList associateTags(List<Product> products);
}
