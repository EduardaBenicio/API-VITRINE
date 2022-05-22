package com.api.vitrine.services;

import com.api.vitrine.model.Store;
import com.api.vitrine.model.StoreOwner;
import com.api.vitrine.repository.StoreOwnerRepository;
import com.api.vitrine.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    public List<Store> findAll(){

        return storeRepository.findAll();
    }

    public Store save(Store store){

        return storeRepository.save(store);
    }

    public Store update(Store store){

        return storeRepository.save(store);
    }

    public Store findById(Long id){
        if(storeRepository.findById(id).isPresent()){
            return storeRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        storeRepository.deleteById(id);
    }
}
