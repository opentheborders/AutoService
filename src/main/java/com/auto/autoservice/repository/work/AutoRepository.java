package com.auto.autoservice.repository.work;

import com.auto.autoservice.model.data.Auto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface AutoRepository extends MongoRepository<Auto, String> {

    List<Auto> findAll();


}