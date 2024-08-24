package com.api.vitrine.services;

import com.api.vitrine.model.StoreOwner;
import com.api.vitrine.model.Usuario;
import com.api.vitrine.repository.StoreOwnerRepository;
import com.api.vitrine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    StoreOwnerRepository ownerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
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

    public StoreOwner login(String user, String password){
        if(userRepository.login(user, password) != null){
            Usuario usuario = userRepository.login(user, password);
            return ownerRepository.findOwnerByUser(usuario.getId());
        }else{
            return null;
        }
    }

    //DELETE CLIENT
    public void  delete(Long id){
        userRepository.deleteById(id);
    }
}
