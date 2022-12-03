package com.example.pdl;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PDL {
    private String domain;
    private JSONObject response;

    public void getResponse() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://api.peopledatalabs.com/v5/company/enrich?website=%s&pretty=false", domain)))
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("X-API-Key", "0e6d1e2291ce067def630829f587c149c23a30b6fcab63626f5e4a99aa4e8619")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        this.response = new JSONObject(response.body());
    }
    public PDL(String domain_company) throws IOException, InterruptedException {
        domain = domain_company;
        getResponse();

    }
    public String getEmployees(){
        try {
            return Integer.toString(response.getInt("employee_count"));
        }
        catch (Exception e) {
            return null;
        }
    }
}
