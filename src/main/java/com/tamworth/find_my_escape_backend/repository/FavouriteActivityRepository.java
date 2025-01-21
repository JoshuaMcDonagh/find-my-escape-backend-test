package com.tamworth.find_my_escape_backend.repository;

import com.tamworth.find_my_escape_backend.model.FavouriteActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteActivityRepository extends JpaRepository<FavouriteActivity, Long> {
}