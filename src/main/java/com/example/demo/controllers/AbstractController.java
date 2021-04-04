package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.CrudFactoryService;
import com.example.demo.services.Crudable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

public abstract class AbstractController {
    @Autowired
    public CrudFactoryService crudFactoryService;

    private JpaRepository jpaRepository;

    public AbstractController(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @GetMapping
    public List<Crudable> getAll() {
        return jpaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Crudable> getOne(@PathVariable Integer id) {
        return jpaRepository.findById(id);
    }


    @DeleteMapping
    public Crudable deleteUser(@PathVariable Integer id) {
        Crudable crudable = (Crudable) jpaRepository.findById(id).orElse(null);
        return (User) crudFactoryService.performService(crudable, jpaRepository, "delete");
    }
}
