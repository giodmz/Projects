package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

// registra a classe como um component do string
// @Component

@Service
public class ProductService {

    // injetar dependencia do spring
    @Autowired
    private ProductRepository repository;

    // repassa a chamada para o repository.findAll()
    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        
        Optional<Product> obj =  repository.findById(id);
        return obj.get();
    }
    
}
