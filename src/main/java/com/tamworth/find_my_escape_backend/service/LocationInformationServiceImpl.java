package com.tamworth.find_my_escape_backend.service;


import com.tamworth.find_my_escape_backend.model.Location;
import com.tamworth.find_my_escape_backend.model.records.Page;
import com.tamworth.find_my_escape_backend.model.records.WikiApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LocationInformationServiceImpl implements LocationInformationService {

    @Override
    public Location findLocationInformation(String locationName) {
        String title = null;
        String extract = null;
        String source = null;
        Page extractedPage;
        RestTemplate restTemplate = new RestTemplate();
        String locationInformationEndPoint =
                "https://en.wikipedia.org/w/api.php?action=query&titles="
                + locationName
                + "&format=json&prop=pageimages|extracts&formatversion=2&piprop=original"
                + "&pithumbsize=1000&pilicense=free&exchars=250&exintro=1&explaintext=1";

        WikiApiResponse ApiResponse = restTemplate.getForObject(locationInformationEndPoint, WikiApiResponse.class);

        if(ApiResponse != null) {
            extractedPage = ApiResponse.query().pages().getFirst();

            title = extractedPage.title() != null ? extractedPage.title() : null;
            extract = extractedPage.extract() != null ? extractedPage.extract() : null;
            source = extractedPage.original() != null ? extractedPage.original().source() : null;
        }

        return new Location(title, extract, source);
    }

}