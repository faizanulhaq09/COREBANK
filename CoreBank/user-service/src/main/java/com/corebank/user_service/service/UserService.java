package com.corebank.user_service.service;

import com.corebank.user_service.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user); // For registering a new user
    Optional<User> getUserById(Long id); // To find a user by their ID
    List<User> getAllUsers(); // To get a list of all users
    User updateUser(Long id, User userDetails); // To update an existing user
    void deleteUser(Long id); // To delete a user
}
