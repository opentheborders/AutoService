package com.auto.autoservice.repository.auth;

import com.auto.autoservice.model.ERole;
import com.auto.autoservice.model.auth.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);

}
