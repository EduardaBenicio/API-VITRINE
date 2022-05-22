package com.api.vitrine.controller;

import com.api.vitrine.model.AddressClient;
import com.api.vitrine.model.AddressStore;
import com.api.vitrine.services.AddressStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/addressStore")
public class AddressStoreController {

    @Autowired
    AddressStoreService addressStoreService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<AddressStore>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(addressStoreService.findAll());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<AddressStore> save(@RequestBody AddressStore addressStore){

        return ResponseEntity.status(HttpStatus.CREATED).body(addressStoreService.save(addressStore));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressStore> findById(@PathVariable Long id){

        AddressStore addressStore = addressStoreService.findById(id);

        if(addressStore != null){
            return ResponseEntity.status(HttpStatus.OK).body(addressStore);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(addressStoreService.findById(id) != null){
            addressStoreService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço Não existe!");
        }
    }
}
