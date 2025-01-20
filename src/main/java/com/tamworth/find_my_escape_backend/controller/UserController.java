package com.tamworth.find_my_escape_backend.controller;

import com.tamworth.find_my_escape_backend.model.FavouriteActivity;
import com.tamworth.find_my_escape_backend.model.FavouriteLocation;
import com.tamworth.find_my_escape_backend.model.User;
import com.tamworth.find_my_escape_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    //Get

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(name = "id") String userId) {
        User user = userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/favourites")
    public ResponseEntity<Map<FavouriteLocation, FavouriteActivity>> getFavouritesByUserId(@RequestBody String userId) {
        return null;
    }

    //Put

    @PutMapping("/change/email")
    public HttpStatus changeUserEmail(@RequestBody String userId, String emailAddress) {
        return null;
    }

    @PutMapping("/change/name")
    public HttpStatus changeUserName(@RequestBody String userId, String emailAddress) {
        return null;
    }

    //Post

    @PostMapping("/new")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        Set<FavouriteLocation> favouriteLocations = new HashSet<>();
        User createdUser = new User(user.getUserId(), user.getName(), user.getEmailAddress(), user.getCurrent_Search(),favouriteLocations);
        User user1 = userService.saveUser(createdUser);
        return ResponseEntity.ok(user1);
    }

    @PostMapping("/favourite/location")
    public HttpStatus addFavouriteLocation(@RequestBody String userId, String locationId, String locationName) {
        return null;
    }

    @PutMapping("/favourite/activity")
    public HttpStatus addFavouriteActivity(@RequestBody String userId, String locationId, String activityId, String activityName) {
        return null;
    }

    //Delete

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id") String userId) {
        User user = userService.deleteUserById(userId);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/favourite/location/remove")
    public HttpStatus removeFavouriteLocation(@RequestBody String userId, String locationId) {
        return null;
    }

    @DeleteMapping("/user/favourite/activity/remove")
    public HttpStatus removeFavouriteActivity(@RequestBody String userId, String activityId) {
        return null;
    }

}
