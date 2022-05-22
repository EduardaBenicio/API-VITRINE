package com.api.vitrine.services;

import com.api.vitrine.model.Client;
import com.api.vitrine.model.ProductPhotos;
import com.api.vitrine.repository.ProductPhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductPhotosService {

    @Autowired
    ProductPhotosRepository productPhotosRepository;

    public List<ProductPhotos> findAll(){

        return productPhotosRepository.findAll();
    }

    public ProductPhotos save(ProductPhotos productPhotos){

        return productPhotosRepository.save(productPhotos);
    }

    public ProductPhotos update(ProductPhotos productPhotos){

        return productPhotosRepository.save(productPhotos);
    }

    public ProductPhotos findById(Long id){
        if(productPhotosRepository.findById(id).isPresent()){
            return productPhotosRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE
    public void  delete(Long id){
        productPhotosRepository.deleteById(id);
    }
}
