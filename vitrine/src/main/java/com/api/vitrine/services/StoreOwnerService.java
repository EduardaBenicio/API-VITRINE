package com.api.vitrine.services;

import com.api.vitrine.model.Specifications;
import com.api.vitrine.model.Store;
import com.api.vitrine.model.StoreOwner;
import com.api.vitrine.repository.StoreOwnerRepository;
import com.api.vitrine.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreOwnerService {

    @Autowired
    StoreOwnerRepository storeOwnerRepository;

    @Autowired
    StoreRepository storeRepository;

    public List<StoreOwner> findAll(){

        return storeOwnerRepository.findAll();
    }

    public StoreOwner save(StoreOwner storeOwner){

        return storeOwnerRepository.save(storeOwner);
    }

    public List<Store> findAllStore(long id){

        List<Store> lista = storeRepository.findStore(id);

        if(lista != null){
            return lista;
        }else{
            return null;
        }
    }
    public StoreOwner update(StoreOwner storeOwner){

        return storeOwnerRepository.save(storeOwner);
    }

    public StoreOwner findById(Long id){
        if(storeOwnerRepository.findById(id).isPresent()){
            return storeOwnerRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        storeOwnerRepository.deleteById(id);
    }
}
