package com.tamworth.find_my_escape_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;

    @Column(nullable = false, unique = true)
    private String locationName;

    @Column
    private String description;

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