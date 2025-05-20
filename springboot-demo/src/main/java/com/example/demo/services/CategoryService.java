package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;

// registra a classe como um component do string
// @Component

@Service
public class CategoryService {

    // injetar dependencia do spring
    @Autowired
    private CategoryRepository repository;

    // repassa a chamada para o repository.findAll()
    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        
        Optional<Category> obj =  repository.findById(id);
        return obj.get();
    }
    
}
