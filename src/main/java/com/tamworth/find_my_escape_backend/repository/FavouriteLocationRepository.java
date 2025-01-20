package com.tamworth.find_my_escape_backend.repository;

import com.tamworth.find_my_escape_backend.model.FavouriteLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FavouriteLocationRepository extends JpaRepository<FavouriteLocation, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM FavouriteLocation fl WHERE fl.locationId = :locationId AND fl.favLocationUser.userId = :userId")
    void deleteByLocationIdAndUserId(Long locationId, String userId);
}