package com.tamworth.find_my_escape_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "favourite_location")
public class FavouriteLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;

    @Column
    private String locationName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User favLocationUser;

    @OneToMany(mappedBy = "favouriteLocation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FavouriteActivity> favouriteActivities = new HashSet<>();

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public User getFavLocationUser() {
        return favLocationUser;
    }

    public void setFavLocationUser(User favLocationUser) {
        this.favLocationUser = favLocationUser;
    }

    public Set<FavouriteActivity> getFavouriteActivities() {
        return favouriteActivities;
    }

    public void setFavouriteActivities(Set<FavouriteActivity> favouriteActivities) {
        this.favouriteActivities = favouriteActivities;
    }
}
