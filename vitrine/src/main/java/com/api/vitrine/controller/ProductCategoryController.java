package com.api.vitrine.controller;

import com.api.vitrine.model.ProductCategory;
import com.api.vitrine.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/productCategory")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping(path = "/all/{id}")
    public ResponseEntity<List<ProductCategory>> listAll(@PathVariable  Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productCategoryService.findAll(id));
    }

    @PostMapping(path = "/save")
    public ResponseEntity<ProductCategory> save(@RequestBody ProductCategory productCategory){

        return ResponseEntity.status(HttpStatus.CREATED).body(productCategoryService.save(productCategory));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductCategory> findById(@PathVariable Long id){

        ProductCategory productCategory = productCategoryService.findById(id);

        if(productCategory != null){
            return ResponseEntity.status(HttpStatus.OK).body(productCategory);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(productCategoryService.findById(id) != null){
            productCategoryService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Categoria deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria Não existe!");
        }
    }
}
