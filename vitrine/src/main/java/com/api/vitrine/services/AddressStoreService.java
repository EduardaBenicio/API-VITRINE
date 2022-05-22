package com.api.vitrine.services;

import com.api.vitrine.model.AddressClient;
import com.api.vitrine.model.AddressStore;
import com.api.vitrine.repository.AddressStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressStoreService {

    @Autowired
    AddressStoreRepository addressStoreRepository;

    public List<AddressStore> findAll(){

        return addressStoreRepository.findAll();
    }

    public AddressStore save(AddressStore addressStore){

        return addressStoreRepository.save(addressStore);
    }

    public AddressStore update(AddressStore addressStore){

        return addressStoreRepository.save(addressStore);
    }

    public AddressStore findById(Long id){
        if(addressStoreRepository.findById(id).isPresent()){
            return addressStoreRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE
    public void  delete(Long id){
        addressStoreRepository.deleteById(id);
    }
}
