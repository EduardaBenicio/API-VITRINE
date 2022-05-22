package com.api.vitrine.services;

import com.api.vitrine.model.Specifications;
import com.api.vitrine.repository.SpecificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SpecificationService {

    @Autowired
    SpecificationsRepository specificationsRepository;

    public List<Specifications> findAll(){

        return specificationsRepository.findAll();
    }

    public Specifications save(Specifications specifications){

        return specificationsRepository.save(specifications);
    }

    public Specifications update(Specifications specifications){

        return specificationsRepository.save(specifications);
    }

    public Specifications findById(Long id){
        if(specificationsRepository.findById(id).isPresent()){
            return specificationsRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        specificationsRepository.deleteById(id);
    }
}
