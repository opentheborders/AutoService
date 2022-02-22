package com.auto.autoservice.repository.auth;

import com.auto.autoservice.model.auth.User;
import com.auto.autoservice.model.data.Auto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    List<User> findAll();
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    User save(User user);
}