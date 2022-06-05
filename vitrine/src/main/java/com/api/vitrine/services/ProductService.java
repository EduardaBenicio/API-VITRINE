package com.api.vitrine.services;

import com.api.vitrine.model.Product;
import com.api.vitrine.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        List<Product> products = new ArrayList<>();
        Product product = null;
        if(productRepository.findAll() != null){

            for(int i = 0; i < productRepository.findAll().size(); i++){
                product =  productRepository.findAll().get(i);
                product.getProductCategory().setStore(null);
                product.getProductCategory().setProducts(null);
                products.add(product);

            }
        }
        return products;
    }

    public Product save(Product product){

        return productRepository.save(product);
    }

    public Product update(Product product){

        return productRepository.save(product);
    }

    public List<Product> findByCategory(Long id){
        List<Product> products = new ArrayList<>();
        Product product = null;
        if(productRepository.findByProductCategory(id) != null){

            for(int i = 0; i < productRepository.findByProductCategory(id).size(); i++){
                product = productRepository.findByProductCategory(id).get(i);
                product.getProductCategory().setStore(null);
                product.getProductCategory().setProducts(null);
                products.add(product);

            }


            return products;
        }else{
            return null;
        }
    }

    public Product findById(Long id){
        if(productRepository.findById(id).isPresent()){
            Product product = productRepository.findById(id).get();
            product.getProductCategory().setStore(null);
            product.getProductCategory().setProducts(null);
            return product;
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        productRepository.deleteById(id);
    }


}
