package com.techelevator.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class NutritionService {

    private static final String API_BASE_URL = "https://api.nal.usda.gov/fdc/v1/";
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = "54ZP8FRpEdIF01LPWpU41mKRUaqrD2XPuF7S5I75";

//    public boolean getNutriFactByFDAId (int id) {
//        boolean success = false;
//        try{
//            restTemplate.exchange(API_BASE_URL+"food/"+id, HttpMethod.GET,makeAuthEntity(),makeAuthEntity(),)
//        }
//    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }
}
