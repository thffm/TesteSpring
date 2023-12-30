package com.webTry.pagina.web.resources;

import com.webTry.pagina.web.entities.Order;
import com.webTry.pagina.web.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//controle request
@RequestMapping(value = "/orders")//caminho que eu quero
public class OrderResource {
    @Autowired//automatico
    private OrderService service;
    @GetMapping//requisicao http
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);//manda respota para o http
    }
}
