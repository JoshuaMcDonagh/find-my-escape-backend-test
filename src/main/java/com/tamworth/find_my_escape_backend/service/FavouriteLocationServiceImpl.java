package com.tamworth.find_my_escape_backend.service;

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
    @Transactional
    public void deleteFavouriteLocation(Long locationId, String userId) {
        favouriteLocationRepository.deleteByLocationIdAndUserId(locationId, userId);
    }
}
