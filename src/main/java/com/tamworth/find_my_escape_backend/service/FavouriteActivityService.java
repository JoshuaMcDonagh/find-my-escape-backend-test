package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.FavouriteActivity;

public interface FavouriteActivityService {
    FavouriteActivity addActivityToLocation(FavouriteActivity activity, Long locationId);
    void removeActivityFromLocation(Long activityId);
}