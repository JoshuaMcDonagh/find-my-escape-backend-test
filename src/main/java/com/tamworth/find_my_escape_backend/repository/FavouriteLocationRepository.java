package com.tamworth.find_my_escape_backend.repository;

import com.tamworth.find_my_escape_backend.model.FavouriteLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FavouriteLocationRepository extends JpaRepository<FavouriteLocation, Long> {
    List<FavouriteLocation> findAllByUser_UserId(String userId);
}