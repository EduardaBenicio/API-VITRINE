package com.api.vitrine.services;

import com.api.vitrine.model.AddressClient;
import com.api.vitrine.model.ProductCategory;
import com.api.vitrine.repository.AddressClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressClientService {

    @Autowired
    AddressClientRepository addressClientRepository;

    public List<AddressClient> findAll(){

        return addressClientRepository.findAll();
    }

    public AddressClient save(AddressClient addressClient){

        return addressClientRepository.save(addressClient);
    }

    public AddressClient update(AddressClient addressClient){

        return addressClientRepository.save(addressClient);
    }

    public AddressClient findById(Long id){
        if(addressClientRepository.findById(id).isPresent()){
            return addressClientRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE
    public void  delete(Long id){
        addressClientRepository.deleteById(id);
    }
}
