package com.api.vitrine.controller;


import com.api.vitrine.model.Product;
import com.api.vitrine.model.ProductPhotos;
import com.api.vitrine.services.ProductPhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/productPhotos")
public class ProductPhotosController {


    @Autowired
    ProductPhotosService productPhotosService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ProductPhotos>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productPhotosService.findAll());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<ProductPhotos> save(@RequestBody ProductPhotos productPhotos){

        return ResponseEntity.status(HttpStatus.CREATED).body(productPhotosService.save(productPhotos));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductPhotos> findById(@PathVariable Long id){

        ProductPhotos productPhotos = productPhotosService.findById(id);

        if(productPhotos != null){
            return ResponseEntity.status(HttpStatus.OK).body(productPhotos);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(productPhotosService.findById(id) != null){
            productPhotosService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Foto deletada com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Foto Não existe!");
        }
    }
}
