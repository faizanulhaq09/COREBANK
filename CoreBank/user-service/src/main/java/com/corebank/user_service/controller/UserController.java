package com.corebank.user_service.controller;

import com.corebank.user_service.model.User;
import com.corebank.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST Controller
@RequestMapping("/api/users") // <-- Set the base path here for all endpoints
public class UserController {

    private final UserService userService;

    @Autowired // Injects the UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST /api/users - Create a new user
    @PostMapping // This will now map to POST /api/users (because of class-level @RequestMapping)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // GET /api/users/{id} - Get user by ID
    @GetMapping("/{id}") // This will now map to GET /api/users/{id}
    public ResponseEntity<User> getUserById(@PathVariable Long id ) {
        return userService.getUserById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET /api/users - Get all users
    @GetMapping // This will now map to GET /api/users
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // PUT /api/users/{id} - Update a user
    @PutMapping("/{id}") // This will now map to PUT /api/users/{id}
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        try {
            User updatedUser = userService.updateUser(id, userDetails);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /api/users/{id} - Delete a user
    @DeleteMapping("/{id}") // This will now map to DELETE /api/users/{id}
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}