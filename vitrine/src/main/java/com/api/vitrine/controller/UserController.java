package com.api.vitrine.controller;

import com.api.vitrine.model.Usuario;
import com.api.vitrine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@ResponseBody //RETURN JSON
//@CrossOrigin(originPatterns = "http://localhost/moduloRh/public/", allowCredentials = "true")
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Usuario>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(usuario));
    }

    //FIND BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){

        Usuario usuario = userService.findById(id);

        if(usuario != null){
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //DELETE CLIENT
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id){
        if(userService.findById(id) != null){
            userService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario Não existe!");
        }
    }
}
