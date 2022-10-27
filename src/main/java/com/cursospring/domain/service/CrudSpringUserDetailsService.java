package com.cursospring.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//Se usa para implementar usuario y contraseña para el acceso a la API usando Spring Boot Security. Donde está el
//Arraylist es para definir los roles del usuario, pero por ahora estará vacio
@Service
public class CrudSpringUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("admin", "{noop}admin", new ArrayList<>());
    }
}
