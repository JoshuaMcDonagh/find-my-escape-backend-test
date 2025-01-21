package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.FavouriteLocation;
import com.tamworth.find_my_escape_backend.repository.FavouriteLocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FavouriteLocationServiceImpl implements FavouriteLocationService {
    private final FavouriteLocationRepository favouriteLocationRepository;

    public FavouriteLocationServiceImpl(FavouriteLocationRepository favouriteLocationRepository) {
        this.favouriteLocationRepository = favouriteLocationRepository;
    }


    @Override
    public FavouriteLocation getLocationWithActivities(Long locationId) {
        return favouriteLocationRepository.findById(locationId)
                .orElseThrow(() -> new IllegalArgumentException("Location with ID " + locationId + " not found."));
    }

    @Override
    public void deleteFavouriteLocation(Long locationId, String userId) {
        FavouriteLocation location = favouriteLocationRepository.findById(locationId)
                .orElseThrow(() -> new IllegalArgumentException("Location with ID " + locationId + " not found."));
        if (!location.getFavLocationUser().getUserId().equals(userId)) {
            throw new IllegalArgumentException("User ID mismatch. Cannot delete this location.");
        }
        favouriteLocationRepository.delete(location);
    }

    @Override
    public FavouriteLocation createFavouriteLocation(FavouriteLocation location) {
        if (location.getFavLocationUser() == null) {
            throw new IllegalArgumentException("A FavouriteLocation must be associated with a user.");
        }
        return favouriteLocationRepository.save(location);
    }
}
