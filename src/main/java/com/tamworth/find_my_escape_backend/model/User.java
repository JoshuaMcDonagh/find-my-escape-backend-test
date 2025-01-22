package com.tamworth.find_my_escape_backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String emailAddress;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<FavouriteLocation> favouriteLocations = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<FavouriteActivity> favouriteActivities = new HashSet<>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Set<FavouriteLocation> getFavouriteLocations() {
        return favouriteLocations;
    }

    public void setFavouriteLocations(Set<FavouriteLocation> favouriteLocations) {
        this.favouriteLocations = favouriteLocations;
    }

    public Set<FavouriteActivity> getFavouriteActivities() {
        return favouriteActivities;
    }

    public void setFavouriteActivities(Set<FavouriteActivity> favouriteActivities) {
        this.favouriteActivities = favouriteActivities;
    }

    public User() {
    }

    public User(String userId, String name, String emailAddress, Set<FavouriteLocation> favouriteLocations, Set<FavouriteActivity> favouriteActivities) {
        this.userId = userId;
        this.name = name;
        this.emailAddress = emailAddress;
        this.favouriteLocations = favouriteLocations;
        this.favouriteActivities = favouriteActivities;
    }
}