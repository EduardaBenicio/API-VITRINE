package com.api.vitrine.services;

import com.api.vitrine.model.*;
import com.api.vitrine.repository.StoreOwnerRepository;
import com.api.vitrine.repository.StoreRepository;
import com.api.vitrine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreOwnerService {

    @Autowired
    StoreOwnerRepository storeOwnerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    StoreRepository storeRepository;

    public List<StoreOwner> findAll(){

        return storeOwnerRepository.findAll();
    }

    public StoreOwner save(StoreOwner storeOwner){

        if(storeOwner.usuario.getUsername() != null){
            Usuario user = userRepository.save(storeOwner.usuario);
        }
        return storeOwnerRepository.save(storeOwner);
    }

    public List<Store> findAllStore(long id){

        List<Store> lista = storeRepository.findByOwner(id);

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
