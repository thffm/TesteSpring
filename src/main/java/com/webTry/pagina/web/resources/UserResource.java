package com.webTry.pagina.web.resources;

import com.webTry.pagina.web.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//controle request
@RequestMapping(value = "/users")//caminho que eu quero
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"maria","maria@gmail.com","99999","12345");

        return ResponseEntity.ok().body(u);
    }
}
