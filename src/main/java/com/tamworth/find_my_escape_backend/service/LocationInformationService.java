package com.tamworth.find_my_escape_backend.service;

import com.tamworth.find_my_escape_backend.model.Location;

public interface LocationInformationService {
    Location findLocationInformation(String locationName);
}
