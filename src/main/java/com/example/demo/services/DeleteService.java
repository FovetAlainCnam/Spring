package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteService implements CrudFactory {
    @Override
    public Crudable performService(Crudable crudable, JpaRepository jpaRepository, String service) {
        jpaRepository.delete(crudable);
        return null;
    }
}
