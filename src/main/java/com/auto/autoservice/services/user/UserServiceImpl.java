package com.auto.autoservice.services.user;

import com.auto.autoservice.model.ERole;
import com.auto.autoservice.model.auth.Role;
import com.auto.autoservice.model.auth.User;
import com.auto.autoservice.model.data.Auto;
import com.auto.autoservice.payload.request.LoginRequest;
import com.auto.autoservice.payload.response.MessageResponse;
import com.auto.autoservice.repository.auth.RoleRepository;
import com.auto.autoservice.repository.auth.UserRepository;
import com.auto.autoservice.repository.work.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.auto.autoservice.payload.request.SignupRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Component
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    SignupRequest signupRequest;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AutoRepository autoRepository;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void createUser(SignupRequest signUpRequest) {

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        Auto auto = new Auto(signUpRequest.getAuto());
        autoRepository.save(auto);

        user.setAuto(auto);
        userRepository.save(user);

    }

    }


