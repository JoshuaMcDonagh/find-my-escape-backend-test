package com.tamworth.find_my_escape_backend.controller;

import com.tamworth.find_my_escape_backend.service.FavouriteLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favourite-locations")
public class FavouriteLocationController {

    private final FavouriteLocationService favouriteLocationService;

    public FavouriteLocationController(FavouriteLocationService favouriteLocationService) {
        this.favouriteLocationService = favouriteLocationService;
    }

    @DeleteMapping("/{locationId}/user/{userId}")
    public ResponseEntity<Void> deleteFavouriteLocation(@PathVariable Long locationId, @PathVariable String userId) {
        favouriteLocationService.deleteFavouriteLocation(locationId, userId);
        return ResponseEntity.noContent().build();
    }
}