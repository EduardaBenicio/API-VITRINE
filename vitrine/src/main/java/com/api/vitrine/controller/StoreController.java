package com.api.vitrine.controller;

import com.api.vitrine.model.Request;
import com.api.vitrine.model.Store;
import com.api.vitrine.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Store>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(storeService.findAll());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Store> save(@RequestBody Store store){

        return ResponseEntity.status(HttpStatus.CREATED).body(storeService.save(store));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Store> findById(@PathVariable Long id){

        Store store = storeService.findById(id);

        if(store != null){
            return ResponseEntity.status(HttpStatus.OK).body(store);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    //FIND BY ID
    @GetMapping(path = "/request/{id}")
    public ResponseEntity<List<Request>> findRequest(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(storeService.findAllRequests(id));
    }


    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(storeService.findById(id) != null){
            storeService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Loja deletada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loja Não existe!");
        }
    }
}
