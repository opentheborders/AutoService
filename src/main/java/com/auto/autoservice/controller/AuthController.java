package com.auto.autoservice.controller;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.auto.autoservice.model.ERole;
import com.auto.autoservice.model.auth.Role;
import com.auto.autoservice.model.auth.User;
import com.auto.autoservice.model.data.Auto;
import com.auto.autoservice.payload.request.LoginRequest;
import com.auto.autoservice.payload.request.SignupRequest;
import com.auto.autoservice.payload.response.JwtResponse;
import com.auto.autoservice.payload.response.MessageResponse;
import com.auto.autoservice.repository.auth.RoleRepository;
import com.auto.autoservice.repository.auth.UserRepository;
import com.auto.autoservice.jwt.JwtUtils;
import com.auto.autoservice.repository.work.AutoRepository;
import com.auto.autoservice.services.auth.UserDetailsImpl;
import com.auto.autoservice.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    AutoRepository autoRepository;
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/jwt")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return ok(jwt);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

    userService.createUser(signUpRequest);

    return ok("User Registered Successfully");
    }

}