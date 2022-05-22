package com.api.vitrine.controller;

import com.api.vitrine.model.Request;
import com.api.vitrine.model.ShoppingCart;
import com.api.vitrine.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/shoppingCart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ShoppingCart>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(shoppingCartService.findAll());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<ShoppingCart> save(@RequestBody ShoppingCart shoppingCart){

        return ResponseEntity.status(HttpStatus.CREATED).body(shoppingCartService.save(shoppingCart));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<ShoppingCart> findById(@PathVariable Long id){

        ShoppingCart shoppingCart = shoppingCartService.findById(id);

        if(shoppingCart != null){
            return ResponseEntity.status(HttpStatus.OK).body(shoppingCart);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(shoppingCartService.findById(id) != null){
            shoppingCartService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Carrinho deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrinho Não existe!");
        }
    }
}
