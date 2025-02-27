package com.tamworth.find_my_escape_backend.controller;

import com.tamworth.find_my_escape_backend.model.Location;
import com.tamworth.find_my_escape_backend.service.LocationInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/location")
public class LocationInformationController {

    @Autowired
    LocationInformationService locationInformationService;

    @GetMapping("/information/{locationName}")
    public ResponseEntity<Location> getLocationInformation(@PathVariable String locationName) {
        Location requestedLocation = locationInformationService.findLocationInformation(locationName);
        HttpStatus resultingStatus = requestedLocation.name() == null || requestedLocation.description() == null ? NOT_FOUND : OK;

        return new ResponseEntity<>(requestedLocation, resultingStatus);
    }

}
