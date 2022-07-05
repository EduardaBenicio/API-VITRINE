package com.api.vitrine.controller;

import com.api.vitrine.model.AddressStore;
import com.api.vitrine.model.BusinessCategory;
import com.api.vitrine.model.Store;
import com.api.vitrine.services.BusinessCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/businessCategory")
public class BusinessCategoryController {

    @Autowired
    BusinessCategoryService businessCategoryService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<BusinessCategory>> listAll(){

        return ResponseEntity.status(HttpStatus.OK).body(businessCategoryService.findAll());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<BusinessCategory> save(@RequestBody BusinessCategory businessCategory){

        return ResponseEntity.status(HttpStatus.CREATED).body(businessCategoryService.save(businessCategory));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<BusinessCategory> findById(@PathVariable Long id){

        BusinessCategory businessCategory = businessCategoryService.findById(id);

        if(businessCategory != null){
            return ResponseEntity.status(HttpStatus.OK).body(businessCategory);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    //FIND BY ID
    @GetMapping(path = "/stores/{id}")
    public ResponseEntity<List<Store>> findStores(@PathVariable Long id){

        List<Store> stores = businessCategoryService.findAllStore(id);

        if(stores != null){
            return ResponseEntity.status(HttpStatus.OK).body(stores);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PutMapping(path = "/update")
    public ResponseEntity<BusinessCategory> update(@RequestBody BusinessCategory businessCategory){

        BusinessCategory businessCategoryUpdate = businessCategoryService.findById(businessCategory.getId());

        if(businessCategory != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(businessCategoryService.save(businessCategoryUpdate));
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(businessCategoryService.findById(id) != null){
            businessCategoryService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Categoria de negócio deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria de negócio Não existe!");
        }
    }
}
