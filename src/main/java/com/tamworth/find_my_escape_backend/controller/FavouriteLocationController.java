package com.tamworth.find_my_escape_backend.controller;

import com.tamworth.find_my_escape_backend.model.FavouriteLocation;
import com.tamworth.find_my_escape_backend.service.FavouriteLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favourite-locations")
public class FavouriteLocationController {
    private final FavouriteLocationService favouriteLocationService;

    public FavouriteLocationController(FavouriteLocationService favouriteLocationService) {
        this.favouriteLocationService = favouriteLocationService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FavouriteLocation>> getUserFavouriteLocations(@PathVariable String userId) {
        return ResponseEntity.ok(favouriteLocationService.getUserFavouriteLocations(userId));
    }

    @PostMapping("/{userId}/{locationId}")
    public ResponseEntity<FavouriteLocation> addFavouriteLocation(@PathVariable String userId, @PathVariable Long locationId) {
        return ResponseEntity.ok(favouriteLocationService.addFavouriteLocation(userId, locationId));
    }

    @DeleteMapping("/{userId}/{locationId}")
    public ResponseEntity<Void> removeFavouriteLocation(@PathVariable String userId, @PathVariable Long locationId) {
        favouriteLocationService.removeFavouriteLocation(userId, locationId);
        return ResponseEntity.noContent().build();
    }
}