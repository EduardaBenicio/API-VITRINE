package com.api.vitrine.controller;


import com.api.vitrine.model.Product;
import com.api.vitrine.model.Store;
import com.api.vitrine.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Product>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Product> save(@RequestBody Product product){

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }
    //FIND BY CATEGORY
    @GetMapping(path = "/category/{id}")
    public ResponseEntity<List<Product>> findStores(@PathVariable Long id){

        List<Product> products = productService.findByCategory(id);

        if(products != null){
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){

        Product product = productService.findById(id);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(productService.findById(id) != null){
            productService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("produto deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto Não existe!");
        }
    }
}
