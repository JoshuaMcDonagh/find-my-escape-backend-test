package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.FavouriteLocation;
import com.tamworth.find_my_escape_backend.model.Locations;
import com.tamworth.find_my_escape_backend.model.User;
import com.tamworth.find_my_escape_backend.repository.FavouriteLocationRepository;
import com.tamworth.find_my_escape_backend.repository.LocationsRepository;
import com.tamworth.find_my_escape_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FavouriteLocationServiceImpl implements FavouriteLocationService {
    private final FavouriteLocationRepository favouriteLocationRepository;
    private final LocationsRepository locationRepository;
    private final UserRepository userRepository;

    public FavouriteLocationServiceImpl(FavouriteLocationRepository favouriteLocationRepository, LocationsRepository locationRepository, UserRepository userRepository) {
        this.favouriteLocationRepository = favouriteLocationRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<FavouriteLocation> getUserFavouriteLocations(String userId) {
        return favouriteLocationRepository.findAllByUser_UserId(userId);
    }

    @Override
    public FavouriteLocation addFavouriteLocation(String userId, Long locationId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found."));
        Locations location = locationRepository.findById(locationId).orElseThrow(() -> new IllegalArgumentException("Location not found."));
        FavouriteLocation favouriteLocation = new FavouriteLocation(user, location);
        return favouriteLocationRepository.save(favouriteLocation);
    }

    @Override
    public void removeFavouriteLocation(String userId, Long locationId) {
        favouriteLocationRepository.deleteAll(favouriteLocationRepository.findAllByUser_UserId(userId)
                .stream()
                .filter(fl -> fl.getLocation().getLocationId().equals(locationId))
                .toList());
    }
}