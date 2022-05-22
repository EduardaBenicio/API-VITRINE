package com.api.vitrine.services;

import com.api.vitrine.model.BusinessCategory;
import com.api.vitrine.model.Client;
import com.api.vitrine.repository.BusinessCategoryRepository;
import com.api.vitrine.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){

        return clientRepository.findAll();
    }

    public Client save(Client client){

        return clientRepository.save(client);
    }

    public Client update(Client client){

        return clientRepository.save(client);
    }

    public Client findById(Long id){
        if(clientRepository.findById(id).isPresent()){
            return clientRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE
    public void  delete(Long id){
        clientRepository.deleteById(id);
    }
}
