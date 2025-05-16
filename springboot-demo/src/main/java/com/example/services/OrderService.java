package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;

// registra a classe como um component do string
// @Component

@Service
public class OrderService {

    // injetar dependencia do spring
    @Autowired
    private OrderRepository repository;

    // repassa a chamada para o repository.findAll()
    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        
        Optional<Order> obj =  repository.findById(id);
        return obj.get();
    }
    
}
