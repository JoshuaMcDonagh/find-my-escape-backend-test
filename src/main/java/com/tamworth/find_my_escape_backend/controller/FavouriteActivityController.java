package com.tamworth.find_my_escape_backend.controller;

import com.tamworth.find_my_escape_backend.model.FavouriteActivity;
import com.tamworth.find_my_escape_backend.service.FavouriteActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favourite-activities")
public class FavouriteActivityController {
    private final FavouriteActivityService favouriteActivityService;

    public FavouriteActivityController(FavouriteActivityService favouriteActivityService) {
        this.favouriteActivityService = favouriteActivityService;
    }

    @GetMapping("/{userId}/{locationId}")
    public ResponseEntity<List<FavouriteActivity>> getFavouriteActivities(@PathVariable String userId, @PathVariable Long locationId) {
        return ResponseEntity.ok(favouriteActivityService.getFavouriteActivities(userId, locationId));
    }

    @PostMapping("/{userId}/{locationId}")
    public ResponseEntity<FavouriteActivity> addFavouriteActivity(@PathVariable String userId, @PathVariable Long locationId, @RequestBody FavouriteActivity activity) {
        return ResponseEntity.ok(favouriteActivityService.addFavouriteActivity(userId, locationId, activity));
    }

    @DeleteMapping("/{userId}/{locationId}/{activityId}")
    public ResponseEntity<Void> removeFavouriteActivity(@PathVariable String userId, @PathVariable Long locationId, @PathVariable Long activityId) {
        favouriteActivityService.removeFavouriteActivity(userId, locationId, activityId);
        return ResponseEntity.noContent().build();
    }
}