package com.api.vitrine.services;

import com.api.vitrine.model.Request;
import com.api.vitrine.model.ShoppingCart;
import com.api.vitrine.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    public List<ShoppingCart> findAll(){

        return shoppingCartRepository.findAll();
    }

    public ShoppingCart save(ShoppingCart shoppingCart){

        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart update(ShoppingCart shoppingCart){

        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart findById(Long id){
        if(shoppingCartRepository.findById(id).isPresent()){
            return shoppingCartRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        shoppingCartRepository.deleteById(id);
    }
}
