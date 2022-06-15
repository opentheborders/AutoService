package com.auto.autoservice.controller;


import com.auto.autoservice.jwt.JwtUtils;
import com.auto.autoservice.model.ERole;
import com.auto.autoservice.model.auth.Role;
import com.auto.autoservice.model.auth.User;
import com.auto.autoservice.model.data.Auto;
import com.auto.autoservice.payload.request.SignupRequest;
import com.auto.autoservice.payload.response.JwtResponse;
import com.auto.autoservice.payload.response.MessageResponse;
import com.auto.autoservice.repository.auth.RoleRepository;
import com.auto.autoservice.repository.auth.UserRepository;
import com.auto.autoservice.repository.work.AutoRepository;
import com.auto.autoservice.services.auth.UserDetailsImpl;
import com.auto.autoservice.services.auth.UserDetailsServiceImpl;
import com.auto.autoservice.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test")
public class TestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/all")
    public String allAccess() {

        return "Public Content.";
    }

    //User page. Any role access. This page is open for USER MODERATOR ADMIN

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> userAccess(@AuthenticationPrincipal UserDetails userDetails) {

        return ok(userDetailsServiceImpl.loadUserByUsername(userDetails.getUsername()));

        }

    @DeleteMapping("/user/deleteauto")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteAuto(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        autoRepository.deleteById(userDetails.getAuto().getId());

        return ok("Ok");
    }

    //Moderator page. Moderator access
    @GetMapping("/mod/userlist")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> userList(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        return ok(userRepository.findAll());
    }

    @GetMapping("/mod/autolist")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> autoList(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        return ok(autoRepository.findAll());
    }


    @PostMapping("/mod/signup")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> registerUser(@AuthenticationPrincipal UserDetailsImpl userDetails, @Valid @RequestBody SignupRequest signUpRequest) {

        userService.createUser(signUpRequest);

        return ok("User Registered Successfully");
    }

    @PostMapping("/mod/deleteuser/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<?> deleteUser(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable String id) {

        userRepository.deleteById(id);

        return ok("DELETED");
    }



}