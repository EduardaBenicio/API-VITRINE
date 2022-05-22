package com.api.vitrine.services;

import com.api.vitrine.model.AddressStore;
import com.api.vitrine.model.BusinessCategory;
import com.api.vitrine.model.Store;
import com.api.vitrine.repository.BusinessCategoryRepository;
import com.api.vitrine.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessCategoryService {

    @Autowired
    BusinessCategoryRepository businessCategoryRepository;

    @Autowired
    StoreRepository storeRepository;

    public List<BusinessCategory> findAll(){

        return businessCategoryRepository.findAll();
    }
    public List<Store> findAllStore(long id){

        List<Store> lista = storeRepository.findStore(id);

        if(lista != null){
            return lista;
        }else{
            return null;
        }
    }
    public BusinessCategory save(BusinessCategory businessCategory){

        return businessCategoryRepository.save(businessCategory);
    }

    public BusinessCategory update(BusinessCategory businessCategory){

        return businessCategoryRepository.save(businessCategory);
    }

    public BusinessCategory findById(Long id){
        if(businessCategoryRepository.findById(id).isPresent()){
            return businessCategoryRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE
    public void  delete(Long id){
        businessCategoryRepository.deleteById(id);
    }
}
