package com.tamworth.find_my_escape_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "favourite_activity")
public class FavouriteActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long activityId;

    @Column(nullable = false)
    private String activityName;

    @Column(nullable = false)
    private String activityType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locationId", nullable = false)
    private FavouriteLocation favouriteLocation;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public FavouriteLocation getFavouriteLocation() {
        return favouriteLocation;
    }

    public void setFavouriteLocation(FavouriteLocation favouriteLocation) {
        this.favouriteLocation = favouriteLocation;
    }
}