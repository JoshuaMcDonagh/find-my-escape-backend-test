package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.User;
import com.tamworth.find_my_escape_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        if (userRepository.existsById(user.getUserId())) {
            throw new IllegalArgumentException("User with ID " + user.getUserId() + " already exists.");
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User with ID " + userId + " does not exist.");
        }
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(String userId, String name, String emailAddress) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + userId + " not found."));

        if (name != null && !name.isBlank()) {
            user.setName(name);
        }
        if (emailAddress != null && !emailAddress.isBlank()) {
            user.setEmailAddress(emailAddress);
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + userId + " not found."));
    }
}