package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.FavouriteActivity;

import java.util.List;

public interface FavouriteActivityService {
    List<FavouriteActivity> getFavouriteActivities(String userId, Long locationId);
    FavouriteActivity addFavouriteActivity(String userId, Long locationId, FavouriteActivity activity);
    void removeFavouriteActivity(String userId, Long locationId, Long activityId);
}