package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class CrudFactoryService implements CrudFactory {
    @Autowired
    private CreateService createService;

    @Autowired
    private DeleteService deleteService;

    @Override
    public Crudable performService(Crudable crudable, JpaRepository jpaRepository, String service) {
        if(service.equals("delete")) {
            return deleteService.performService(crudable, jpaRepository, service);
        } else if(service.equals("create")) {
            return createService.performService(crudable, jpaRepository, service);
        } else {
            return null;
        }
    }
}
