package com.webTry.pagina.web.resources;

import com.webTry.pagina.web.entities.User;
import com.webTry.pagina.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//controle request
@RequestMapping(value = "/users")//caminho que eu quero
public class UserResource {
    @Autowired//automatico
    private UserService service;
    @GetMapping//requisicao http
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")//pegando por id
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);//manda respota para o http
    }
}
