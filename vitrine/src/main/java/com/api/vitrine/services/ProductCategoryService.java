package com.api.vitrine.services;

import com.api.vitrine.model.ProductCategory;
import com.api.vitrine.model.Store;
import com.api.vitrine.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> findAll(long id){
        List<ProductCategory> categories = new ArrayList<>();
        ProductCategory productCategory = null;
        if(productCategoryRepository.findByStore(id) != null){
            for(int i = 0; i < productCategoryRepository.findByStore(id).size(); i++){
                productCategory = productCategoryRepository.findByStore(id).get(i);
                productCategory.setStore(null);
                categories.add(productCategory);
            }
        }

        return categories;
    }

    public ProductCategory save(ProductCategory productCategory){

        return productCategoryRepository.save(productCategory);
    }

    public ProductCategory update(ProductCategory productCategory){

        return productCategoryRepository.save(productCategory);
    }

    public ProductCategory findById(Long id){
        if(productCategoryRepository.findById(id).isPresent()){
            return productCategoryRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        productCategoryRepository.deleteById(id);
    }
}
