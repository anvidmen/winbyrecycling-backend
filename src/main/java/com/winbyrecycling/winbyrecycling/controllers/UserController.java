package com.winbyrecycling.winbyrecycling.controllers;

import java.net.URI;
import java.util.*;
import com.winbyrecycling.winbyrecycling.models.User;
import com.winbyrecycling.winbyrecycling.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
 
   @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user").toUriString());
        return ResponseEntity.created(uri).body(userService.getUsers());
    }

    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

}
