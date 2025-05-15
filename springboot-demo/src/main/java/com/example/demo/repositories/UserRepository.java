package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;


// não precisa do @Repository pois já está sendo herdado do JpaRepository
public interface UserRepository extends JpaRepository<User, Long> {
    
    
}
