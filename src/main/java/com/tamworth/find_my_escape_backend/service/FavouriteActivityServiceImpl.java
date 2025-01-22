package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.FavouriteActivity;
import com.tamworth.find_my_escape_backend.model.FavouriteLocation;
import com.tamworth.find_my_escape_backend.repository.FavouriteActivityRepository;
import com.tamworth.find_my_escape_backend.repository.FavouriteLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteActivityServiceImpl implements FavouriteActivityService {
    private final FavouriteActivityRepository favouriteActivityRepository;
    private final FavouriteLocationRepository favouriteLocationRepository;

    public FavouriteActivityServiceImpl(FavouriteActivityRepository favouriteActivityRepository, FavouriteLocationRepository favouriteLocationRepository) {
        this.favouriteActivityRepository = favouriteActivityRepository;
        this.favouriteLocationRepository = favouriteLocationRepository;
    }

    @Override
    public List<FavouriteActivity> getFavouriteActivities(String userId, Long locationId) {
        return favouriteActivityRepository.findAllByUser_UserIdAndLocation_LocationId(userId, locationId);
    }

    @Override
    public FavouriteActivity addFavouriteActivity(String userId, Long locationId, FavouriteActivity activity) {
        FavouriteLocation favouriteLocation = favouriteLocationRepository.findAllByUser_UserId(userId)
                .stream()
                .filter(fl -> fl.getLocation().getLocationId().equals(locationId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User has not favourited this location."));
        activity.setUser(favouriteLocation.getUser());
        activity.setLocation(favouriteLocation.getLocation());
        return favouriteActivityRepository.save(activity);
    }

    @Override
    public void removeFavouriteActivity(String userId, Long locationId, Long activityId) {
        FavouriteActivity activity = favouriteActivityRepository.findById(activityId)
                .orElseThrow(() -> new IllegalArgumentException("Activity not found."));
        if (!activity.getUser().getUserId().equals(userId) || !activity.getLocation().getLocationId().equals(locationId)) {
            throw new IllegalArgumentException("Activity does not belong to the user or location.");
        }
        favouriteActivityRepository.delete(activity);
    }
}