package com.api.vitrine.services;

import com.api.vitrine.model.Request;
import com.api.vitrine.model.RequestProducts;
import com.api.vitrine.model.Store;
import com.api.vitrine.model.StoreOwner;
import com.api.vitrine.repository.RequestRepository;
import com.api.vitrine.repository.StoreOwnerRepository;
import com.api.vitrine.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    RequestRepository requestRepository;

    public List<Store> findAll(){

        return storeRepository.findAll();
    }

    public List<Request> findAllRequests(long id){
        List<Request> requestsStore = new ArrayList<>();
        List<Request> list = requestRepository.findAll();
        try{
            for(Request request: list){
                for(RequestProducts rp: request.getRequestProducts()){
                    if(rp.getProduct().getProductCategory().getStore().getId() == id){
                        requestsStore.add(request);
                        break;
                    }
                }
            }
        }catch (NullPointerException e){
            e.getMessage();
        }
        return requestsStore;
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
