package com.example.google;
import com.google.maps.GeoApiContext;
import com.google.maps.TextSearchRequest;
import com.google.maps.model.PlacesSearchResponse;
import lombok.SneakyThrows;

public class GooglePlaces {
    private String domain;
    @SneakyThrows
    public String getAddress(){
        String API_KEY = "AIzaSyBQZksp4BmTesvoWSH6LWdo1sN8zCmt5aU";
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();
        PlacesSearchResponse placesRespose = new TextSearchRequest(context).query(domain).await();
        String address = placesRespose.results[0].formattedAddress;
        context.shutdown();
        return address;
    }
    public GooglePlaces(String domain_company){
        domain = domain_company;

    }
}