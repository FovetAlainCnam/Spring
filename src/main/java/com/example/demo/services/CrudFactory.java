package com.example.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudFactory {
    Crudable performService(Crudable crudable, JpaRepository jpaRepository, String service);
}
