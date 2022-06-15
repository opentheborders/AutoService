package com.auto.autoservice.services.user;

import com.auto.autoservice.model.auth.User;
import com.auto.autoservice.payload.request.LoginRequest;
import com.auto.autoservice.payload.request.SignupRequest;

import java.util.List;


public interface UserService {

    List<User> findAll();

    void createUser(SignupRequest signupRequest);

}
