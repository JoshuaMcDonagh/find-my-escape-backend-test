package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.FavouriteLocation;

import java.util.List;

public interface FavouriteLocationService {
    List<FavouriteLocation> getUserFavouriteLocations(String userId);
    FavouriteLocation addFavouriteLocation(String userId, Long locationId);
    void removeFavouriteLocation(String userId, Long locationId);
}