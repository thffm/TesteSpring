package com.webTry.pagina.web.resources;

import com.webTry.pagina.web.entities.User;
import com.webTry.pagina.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/{id}")//pegando por id users/id
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);//manda respota para o http
    }

    @PostMapping //para incluir
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        //mandar 201
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
                // converte para uri
        return ResponseEntity.created(uri).body(obj);
    }
}
