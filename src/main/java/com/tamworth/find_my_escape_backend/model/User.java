package com.tamworth.find_my_escape_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@Table(name = "USER")
public class User {
    @Id
    @NonNull
    @Column
    private String userId;

    @Column
    private String name;

    @Column
    private String emailAddress;

    @Column
    private String current_Search;


    @OneToMany(mappedBy = "favLocationUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FavouriteLocation> favouriteLocations = new HashSet<>();

//    @OneToMany
//    @JoinTable(
//            name= "UserFavouriteLocation",
//            joinColumns = @JoinColumn(name = "userId"),
//            inverseJoinColumns = @JoinColumn(name = "locationId"),
//            uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "locationId"})
//    )
//    private Set<FavouriteLocation> favouriteLocations = new HashSet<>();
//
//    @OneToMany
//    @JoinTable(
//            name= "UserFavouriteActivity",
//            joinColumns = @JoinColumn(name = "userId"),
//            inverseJoinColumns = @JoinColumn(name = "activityId"),
//            uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "activityId"})
//    )

    public User() {
    }

    public User(@NonNull String userId, String name, String emailAddress, String current_Search, Set<FavouriteLocation> favouriteLocations) {
        this.userId = userId;
        this.name = name;
        this.emailAddress = emailAddress;
        this.current_Search = current_Search;
        this.favouriteLocations = favouriteLocations;
    }

    public @NonNull String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
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

    public String getCurrent_Search() {
        return current_Search;
    }

    public void setCurrent_Search(String current_Search) {
        this.current_Search = current_Search;
    }

    public Set<FavouriteLocation> getFavouriteLocations() {
        return favouriteLocations;
    }

    public void setFavouriteLocations(Set<FavouriteLocation> favouriteLocations) {
        this.favouriteLocations = favouriteLocations;
    }
}
