package com.api.vitrine.services;

import com.api.vitrine.model.Product;
import com.api.vitrine.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){

        return productRepository.findAll();
    }

    public Product save(Product product){

        return productRepository.save(product);
    }

    public Product update(Product product){

        return productRepository.save(product);
    }

    public List<Product> findByCategory(Long id){
        List<Product> produtos = productRepository.findByProductCategory(id);
        if(produtos != null){
            return produtos;
        }else{
            return null;
        }
    }

    public Product findById(Long id){
        if(productRepository.findById(id).isPresent()){
            return productRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        productRepository.deleteById(id);
    }


}
