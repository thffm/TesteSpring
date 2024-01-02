package com.webTry.pagina.web.services;

import com.webTry.pagina.web.entities.User;
import com.webTry.pagina.web.repositories.UserRepository;
import com.webTry.pagina.web.services.execptions.DatabaseException;
import com.webTry.pagina.web.services.execptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Component registra
@Service //registra
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return  repository.save(obj);//retorna objeto salvo
    }

    public void delete(Long id){

        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw  new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw  new DatabaseException(e.getMessage());
        }

    }

    public User update(Long id,User obj){
        User entity = repository.getReferenceById(id);//nao vai para o banco de dados ainda
        updateData(entity,obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
