package com.api.vitrine.controller;

import com.api.vitrine.model.AddressClient;
import com.api.vitrine.model.ProductCategory;
import com.api.vitrine.services.AddressClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/addressClient")
public class AddressClientController {

    @Autowired
    AddressClientService addressClientService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<AddressClient>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(addressClientService.findAll());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<AddressClient> save(@RequestBody AddressClient addressClient){

        return ResponseEntity.status(HttpStatus.CREATED).body(addressClientService.save(addressClient));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressClient> findById(@PathVariable Long id){

        AddressClient addressClient = addressClientService.findById(id);

        if(addressClient != null){
            return ResponseEntity.status(HttpStatus.OK).body(addressClient);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(addressClientService.findById(id) != null){
            addressClientService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço Não existe!");
        }
    }
}
