package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

// registra a classe como um component do string
// @Component

@Service
public class UserService {

    // injetar dependencia do spring
    @Autowired
    private UserRepository repository;

    // repassa a chamada para o repository.findAll()
    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        
        Optional<User> obj =  repository.findById(id);
        return obj.get();
    }
    
}
