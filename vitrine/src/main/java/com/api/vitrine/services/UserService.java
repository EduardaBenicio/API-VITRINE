package com.api.vitrine.services;

import com.api.vitrine.model.Usuario;
import com.api.vitrine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<Usuario> findAll(){

        return userRepository.findAll();
    }

    public Usuario save(Usuario usuario){

        return userRepository.save(usuario);
    }

    public Usuario update(Usuario usuario){

        return userRepository.save(usuario);
    }

    public Usuario findById(Long id){
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id).get();
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        userRepository.deleteById(id);
    }
}
