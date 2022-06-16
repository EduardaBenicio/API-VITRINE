package com.api.vitrine.controller;

import com.api.vitrine.model.Client;
import com.api.vitrine.model.Store;
import com.api.vitrine.model.StoreOwner;
import com.api.vitrine.services.StoreOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/storeOwner")
public class StoreOwnerController {

    @Autowired
    StoreOwnerService ownerService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<StoreOwner>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.findAll());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<StoreOwner> save(@RequestBody StoreOwner storeOwner){

        return ResponseEntity.status(HttpStatus.CREATED).body(ownerService.save(storeOwner));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<StoreOwner> findById(@PathVariable Long id){

        StoreOwner storeOwner = ownerService.findById(id);

        if(storeOwner != null){
            return ResponseEntity.status(HttpStatus.OK).body(storeOwner);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping(path = "/login/{email}")
    public ResponseEntity<StoreOwner> findByEmail(@PathVariable String email){

        StoreOwner storeOwner = ownerService.findByEmail(email);

        if(storeOwner != null){
            return ResponseEntity.status(HttpStatus.OK).body(storeOwner);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    //FIND BY ID
    @GetMapping(path = "/stores/{id}")
    public ResponseEntity<List<Store>> findStores(@PathVariable Long id){

        List<Store> stores = ownerService.findAllStore(id);

        if(stores != null){
            return ResponseEntity.status(HttpStatus.OK).body(stores);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(ownerService.findById(id) != null){
            ownerService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Lojista deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lojista Não existe!");
        }
    }
}
