package com.example.vishwa.shopifyapp.model.usecase;

import android.util.Log;

import com.example.vishwa.shopifyapp.model.entities.Product;
import com.example.vishwa.shopifyapp.model.entities.Products;
import com.example.vishwa.shopifyapp.model.entities.Variant;

import java.util.List;

public class SumProductInventoryUseCaseImpl implements SumProductInventoryUseCase{

    public SumProductInventoryUseCaseImpl() {

    }

    @Override
    public void sumVariantsInventory(List<Product> products) {

        for(Product product : products){
            long sum = 0L;
            for(Variant variant : product.getVariants()) {
                Log.i("Testing", variant.getQuantity() + " variant inventory");
                sum += variant.getQuantity();
            }

            product.setVariantsInventorySum(sum);

            Log.i("Testing", product.getVariantsInventorySum() + " sum ");
        }
    }
}
