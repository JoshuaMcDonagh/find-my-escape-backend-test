package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.FavouriteLocation;

public interface FavouriteLocationService {
    void deleteFavouriteLocation(Long locationId, String userId);
    FavouriteLocation getLocationWithActivities(Long locationId);
    FavouriteLocation createFavouriteLocation(FavouriteLocation location);
}