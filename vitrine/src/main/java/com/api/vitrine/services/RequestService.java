package com.api.vitrine.services;

import com.api.vitrine.model.Product;
import com.api.vitrine.model.Request;
import com.api.vitrine.model.RequestProducts;
import com.api.vitrine.repository.ProductRepository;
import com.api.vitrine.repository.RequestProductRepository;
import com.api.vitrine.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RequestProductRepository requestProductRepository;

    public List<Request> findAll(){

        return requestRepository.findAll();
    }

    public Request save(Request request){
        List<RequestProducts> list = request.getRequestProducts();
        Request save = requestRepository.save(request);

        try{
            for(RequestProducts rp: request.getRequestProducts()){
                rp.setRequest(save);
                long newStock = rp.getProduct().getInStock() - rp.getQuantity();
                rp.getProduct().setInStock(newStock);
                productRepository.save(rp.getProduct());
                requestProductRepository.save(rp);
            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        return save;

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
