package com.tamworth.find_my_escape_backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@Table
public class Locations {
    @Id
    @Column(nullable = false, unique = true)
    private Long locationId;

    @Column
    private String locationName;

    @Column
    private String description;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("location-activities")
    private Set<FavouriteActivity> favouriteActivities = new HashSet<>();

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("location-favourites")
    private Set<FavouriteLocation> favouriteLocations = new HashSet<>();


    public Long getLocationId() {
        return locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getDescription() {
        return description;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Locations() {
    }

    public Locations(Long locationId, String locationName, String description) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.description = description;
    }
}