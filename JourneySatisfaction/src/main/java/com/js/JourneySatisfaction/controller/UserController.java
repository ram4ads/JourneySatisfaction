package com.js.JourneySatisfaction.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.js.JourneySatisfaction.model.User1;
import com.js.JourneySatisfaction.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users1")
public class UserController {

    @Autowired
    private UserService userService;

    // Retrieve all users
    @GetMapping
    public ResponseEntity<List<User1>> getAllUsers() {
        List<User1> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Retrieve a specific user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User1> getUserById(@PathVariable Long id) {
        Optional<User1> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<User1> createUser(@RequestBody User1 user) {
        User1 createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    // Update an existing user by ID
    @PutMapping("/{id}")
    public ResponseEntity<User1> updateUser(@PathVariable Long id, @RequestBody User1 user) {
        Optional<User1> updatedUser = userService.updateUser(id, user);
        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}