package com.tamworth.find_my_escape_backend.controller;

import com.tamworth.find_my_escape_backend.model.User;
import com.tamworth.find_my_escape_backend.service.EmailMessageService;
import com.tamworth.find_my_escape_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final EmailMessageService emailMessageService;

    public UserController(UserService userService, EmailMessageService emailMessageService) {
        this.userService = userService;
        this.emailMessageService = emailMessageService;
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);

        emailMessageService.sendWelcomeEmail(
                createdUser.getEmailAddress(),
                createdUser.getName()
        );

        return ResponseEntity.ok(createdUser);
    }

    // Delete a user by ID
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        User deletedUser = userService.getUserById(userId);
        userService.deleteUser(userId);

        emailMessageService.sendAccountDeletionEmail(
                deletedUser.getEmailAddress(),
                deletedUser.getName()
        );

        return ResponseEntity.noContent().build();
    }

    // Update user details
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable String userId,
            @RequestBody User updateUserRequest) {

        User updatedUser = userService.updateUser(
                userId,
                updateUserRequest.getName(),
                updateUserRequest.getEmailAddress()
        );

        emailMessageService.sendChangeOfDetailsEmail(
                updatedUser.getEmailAddress(),
                updatedUser.getName()
        );

        return ResponseEntity.ok(updatedUser);
    }

    // Retrieve user details by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}