package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.dto.FavouriteLocationRequest;
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


    public List<FavouriteLocation> getUserFavouriteLocations(String userId) {
        return favouriteLocationRepository.findAllByUser_UserId(userId);
    }

    @Transactional
    @Override
    public FavouriteLocation addFavouriteLocation(String userId, FavouriteLocationRequest request) {
        // Validate user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));

        // Check if the location already exists by ID
        Locations location = locationRepository.findById(request.getLocationId())
                .orElseGet(() -> {
                    // Create a new location if it doesn't exist
                    Locations newLocation = new Locations();
                    newLocation.setLocationId(request.getLocationId());
                    newLocation.setLocationName(request.getLocationName());
                    newLocation.setDescription(request.getLocationDescription());
                    return locationRepository.save(newLocation);
                });

        // Check if the user has already favorited this location
        boolean alreadyFavorited = favouriteLocationRepository
                .findAllByUser_UserId(userId)
                .stream()
                .anyMatch(fav -> fav.getLocation().getLocationId().equals(location.getLocationId()));
        if (alreadyFavorited) {
            throw new IllegalArgumentException("User has already favorited this location.");
        }

        // Create the favourite location entry
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