package com.api.vitrine.services;

import com.api.vitrine.model.Request;
import com.api.vitrine.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public List<Request> findAll(){

        return requestRepository.findAll();
    }

    public Request save(Request request){

        return requestRepository.save(request);
    }

    public Request update(Request request){

        return requestRepository.save(request);
    }

    public Request findById(Long id){
        if(requestRepository.findById(id).isPresent()){
            return requestRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        requestRepository.deleteById(id);
    }
}
