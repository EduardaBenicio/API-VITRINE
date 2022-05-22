package com.api.vitrine.controller;

import com.api.vitrine.model.Specifications;
import com.api.vitrine.services.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/specification")
public class SpecificationsController {

    @Autowired
    SpecificationService specificationService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Specifications>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(specificationService.findAll());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Specifications> save(@RequestBody Specifications specifications){

        return ResponseEntity.status(HttpStatus.CREATED).body(specificationService.save(specifications));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Specifications> findById(@PathVariable Long id){

        Specifications specifications = specificationService.findById(id);

        if(specifications != null){
            return ResponseEntity.status(HttpStatus.OK).body(specifications);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(specificationService.findById(id) != null){
            specificationService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Especificacao deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Especificacao Não existe!");
        }
    }
}
