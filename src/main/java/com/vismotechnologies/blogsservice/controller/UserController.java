package com.vismotechnologies.blogsservice.controller;

import com.vismotechnologies.blogsservice.config.security.jwt.JwtService;
import com.vismotechnologies.blogsservice.model.AuthRequest;
import com.vismotechnologies.blogsservice.model.AuthResp;
import com.vismotechnologies.blogsservice.entity.UserDetailsInfo;
import com.vismotechnologies.blogsservice.model.UserDetailsInfoAdminModel;
import com.vismotechnologies.blogsservice.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name="User Controller")
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/auth/welcome")
    public String welcome() {
        System.out.println("welcome");
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/auth/addUser")
    public UserDetailsInfo addUser(@RequestBody UserDetailsInfo user) {
        System.out.println("save user");
        return userService.save(user);
    }


    @GetMapping("/user/findAllUsers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserDetailsInfoAdminModel>> findAllUsers() {
        System.out.println("findAllUsers");
        return userService.findAll();
    }

    @GetMapping("/user/findByName/{userName}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Optional<UserDetailsInfoAdminModel>> findAllUsers(@PathVariable String userName) {
        return userService.findByName(userName);
    }

    @GetMapping("/user/deleteByName/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteUserByName(@PathVariable int id) {
        System.out.println("delete");
        userService.deleteUserByName(id);
        return new ResponseEntity<>("Resource deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/user/editUser")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserDetailsInfoAdminModel editUser(@RequestBody UserDetailsInfo user) {
        return userService.editUser(user);
    }

    @PostMapping("/auth/authenticate")
    public AuthResp authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        System.out.println("auth");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            AuthResp authResp = new AuthResp();
            authResp.setUsername(authRequest.getUsername());
            authResp.setTocken(jwtService.generateToken(authRequest.getUsername()));
            return authResp;
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }

    }

}
