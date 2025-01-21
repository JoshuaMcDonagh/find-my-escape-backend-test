package com.tamworth.find_my_escape_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@Table(name = "favourite_activities")
public class FavouriteActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long activityId;

    @Column(nullable = false)
    private String activityName;

    @Column(nullable = false)
    private String activityType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    @JsonBackReference("location-activities")
    private Locations location;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public FavouriteActivity() {
    }

    public FavouriteActivity(Long activityId, String activityName, String activityType, User user, Locations location) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityType = activityType;
        this.user = user;
        this.location = location;
    }
}