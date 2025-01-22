package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.User;

public interface UserService {
    User createUser(User user); // Create a new user
    void deleteUser(String userId); // Delete a user by ID
    User updateUser(String userId, String name, String emailAddress); // Update user details
    User getUserById(String userId); // Retrieve user details by ID
}