package com.api.vitrine.controller;

import com.api.vitrine.model.BusinessCategory;
import com.api.vitrine.model.Client;
import com.api.vitrine.model.Request;
import com.api.vitrine.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Client>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }
    @PostMapping(path = "/save")
    public ResponseEntity<Client> save(@RequestBody Client client){

        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
    }
    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){

        Client client = clientService.findById(id);

        if(client != null){
            return ResponseEntity.status(HttpStatus.OK).body(client);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    //FIND BY ID
    @GetMapping(path = "/login/{email}")
    public ResponseEntity<Client> findByEmail(@PathVariable String email){

        Client client = clientService.findByEmail(email);

        if(client != null){
            return ResponseEntity.status(HttpStatus.OK).body(client);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping(path = "/request/{id}")
    public ResponseEntity<List<Request>> findRequest(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(clientService.findRequest(id));
    }
    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(clientService.findById(id) != null){
            clientService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Não existe!");
        }
    }
}
