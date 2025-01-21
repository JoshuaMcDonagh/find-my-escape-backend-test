package com.tamworth.find_my_escape_backend.controller;

import com.tamworth.find_my_escape_backend.model.FavouriteActivity;
import com.tamworth.find_my_escape_backend.service.FavouriteActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favourite-activities")
public class FavouriteActivityController {

    private final FavouriteActivityService favouriteActivityService;

    public FavouriteActivityController(FavouriteActivityService favouriteActivityService) {
        this.favouriteActivityService = favouriteActivityService;
    }

    @PostMapping("/{locationId}")
    public ResponseEntity<FavouriteActivity> addActivityToLocation(
            @PathVariable Long locationId,
            @RequestBody FavouriteActivity activity) {
        FavouriteActivity createdActivity = favouriteActivityService.addActivityToLocation(activity, locationId);
        return ResponseEntity.ok(createdActivity);
    }

    @DeleteMapping("/{activityId}")
    public ResponseEntity<Void> removeActivityFromLocation(@PathVariable Long activityId) {
        favouriteActivityService.removeActivityFromLocation(activityId);
        return ResponseEntity.noContent().build();
    }
}