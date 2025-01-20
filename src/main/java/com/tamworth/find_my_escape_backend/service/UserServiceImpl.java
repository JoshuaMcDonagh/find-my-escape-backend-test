package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.exception.ResourceNotFoundException;
import com.tamworth.find_my_escape_backend.model.User;
import com.tamworth.find_my_escape_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("For the specified user id: " + userId + ", there is no user information that is found within the database!");
        } else {
            return user.get();
        }
    }

    @Override
    public User saveUser(User user) {
        User user1 = userRepository.save(user);
        return user1;
    }

    @Override
    public User updateUserEmail(String userId, String email) {
        return null;
    }

    @Override
    public User updateUserName(String userId, String name) {
        return null;
    }

    @Override
    public User deleteUserById(String userId) {
        Optional<User> user = userRepository.findById(userId);
        User deletedUser;
        if (user.isPresent()) {
            deletedUser = user.get();
            userRepository.deleteById(userId);
            return deletedUser;
        } else {
            throw new ResourceNotFoundException(String.format("For the following userId: " + userId + ", no user was found in the database"));
        }
    }

    @Override
    public User saveFavouriteLocation(String userId, String locationId, String locationName) {
        return null;
    }

    @Override
    public User saveFavouriteActivity(String userId, String activity, String activityName, String activityType) {
        return null;
    }

    @Override
    public User deleteFavouriteLocationByUserId(String UserId, String locationId) {
        return null;
    }

    @Override
    public User deleteFavouriteActivityByUserId(String UserId, String activity) {
        return null;
    }

    @Override
    public User getAllFavourites(String UserId) {
        return null;
    }
}
