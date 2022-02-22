package com.auto.autoservice.services.user;

import com.auto.autoservice.model.auth.User;
import com.auto.autoservice.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }



  /*  public List<Auto> findAutosByUsername(String username){
        return userRepository.findAutosByUsername(username);
    }


    public List<Auto> insert(Auto auto){
        return userRepository.insert(auto);
    }

    @Override
    public List<Auto> findTechWorksByUsername(String username) {
        return userRepository.findTechWorksByUsername(username);
    } */
}
