package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.FavouriteActivity;
import com.tamworth.find_my_escape_backend.model.FavouriteLocation;
import com.tamworth.find_my_escape_backend.repository.FavouriteActivityRepository;
import com.tamworth.find_my_escape_backend.repository.FavouriteLocationRepository;
import org.springframework.stereotype.Service;

@Service
public class FavouriteActivityServiceImpl implements FavouriteActivityService {

    private final FavouriteActivityRepository favouriteActivityRepository;
    private final FavouriteLocationRepository favouriteLocationRepository;

    public FavouriteActivityServiceImpl(FavouriteActivityRepository favouriteActivityRepository, FavouriteLocationRepository favouriteLocationRepository) {
        this.favouriteActivityRepository = favouriteActivityRepository;
        this.favouriteLocationRepository = favouriteLocationRepository;
    }

    @Override
    public FavouriteActivity addActivityToLocation(FavouriteActivity activity, Long locationId) {
        FavouriteLocation location = favouriteLocationRepository.findById(locationId)
                .orElseThrow(() -> new IllegalArgumentException("Location with ID " + locationId + " not found."));
        activity.setFavouriteLocation(location);
        return favouriteActivityRepository.save(activity);
    }

    @Override
    public void removeActivityFromLocation(Long activityId) {
        if (!favouriteActivityRepository.existsById(activityId)) {
            throw new IllegalArgumentException("Activity with ID " + activityId + " does not exist.");
        }
        favouriteActivityRepository.deleteById(activityId);
    }
}