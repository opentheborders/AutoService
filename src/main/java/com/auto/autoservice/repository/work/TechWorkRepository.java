package com.auto.autoservice.repository.work;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.auto.autoservice.model.data.TechWork;

import java.util.Optional;
import java.util.Set;


public interface TechWorkRepository extends MongoRepository<TechWork, String>{

    Optional<TechWork> findByTechWorkName(String techWorkName);
    Boolean existsByTechWorkName(String techWorkName);

    TechWork findByTechWorkName(Set<TechWork> techWorks);
    // List<TechWork> findAll();

  }
