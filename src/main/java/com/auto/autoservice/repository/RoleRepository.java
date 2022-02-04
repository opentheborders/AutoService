package com.auto.autoservice.repository;

import com.auto.autoservice.model.ERole;
import com.auto.autoservice.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
