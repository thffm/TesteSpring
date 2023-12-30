package com.webTry.pagina.web.services;

import com.webTry.pagina.web.entities.Order;
import com.webTry.pagina.web.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Component registra
@Service //registra
public class OrderService {
    @Autowired
    private OrderRepository repository;
    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

}
