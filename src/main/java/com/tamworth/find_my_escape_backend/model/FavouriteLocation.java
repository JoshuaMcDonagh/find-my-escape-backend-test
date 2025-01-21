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
@Builder
@Table(name = "favourite_locations")
public class FavouriteLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Locations location;

    public FavouriteLocation(User user, Locations location) {
        this.user = user;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Locations getLocation() {
        return location;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FavouriteLocation() {
    }

    public FavouriteLocation(Long id, User user, Locations location) {
        this.id = id;
        this.user = user;
        this.location = location;
    }
}