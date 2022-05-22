package com.api.vitrine.controller;

import com.api.vitrine.model.Request;
import com.api.vitrine.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Request>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(requestService.findAll());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Request> save(@RequestBody Request request){

        return ResponseEntity.status(HttpStatus.CREATED).body(requestService.save(request));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Request> findById(@PathVariable Long id){

        Request request = requestService.findById(id);

        if(request != null){
            return ResponseEntity.status(HttpStatus.OK).body(request);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(requestService.findById(id) != null){
            requestService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Pedido deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido Não existe!");
        }
    }
}
