package com.example.brandfetch;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

public class Brandfetch {

    private JSONObject response;
    private String domain;
    public void getResponse() throws UnirestException {
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get(String.format("https://api.brandfetch.io/v2/brands/%s", domain))
                    .header("Authorization", "Bearer /oI0N2g30fIg5q1mps9unXZeU+C7r3NQfBE4Uq8PeOs=")
                    .asString();
            this.response = new JSONObject(response.getBody());
        }
        catch (Exception e){
            response = null;
        }
    }
    public Brandfetch(String domain_company) throws UnirestException {
        domain = domain_company;
        getResponse();
    }

    public String getFacebook(){
        if(response!=null) {
            try {
                JSONArray arr = response.getJSONArray("links");
                for (int i = 0; i < arr.length(); i++) {
                    if (arr.getJSONObject(i).getString("name").equals("facebook")) {
                        return arr.getJSONObject(i).getString("url");
                    }
                }
            }
            catch (Exception e){
                return null;
            }
        }
        return null;
    }
    @SneakyThrows
    public String getTwitter(){
        if(response!=null) {
            try {
                JSONArray arr = response.getJSONArray("links");
                for (int i = 0; i < arr.length(); i++) {
                    if (arr.getJSONObject(i).getString("name").equals("twitter")) {
                        return arr.getJSONObject(i).getString("url");
                    }
                }
            }
            catch (Exception e){
                return null;
            }
        }
        return null;
    }
    public String getIcon(){
        if(response!=null) {
            try {
                JSONArray arr = response.getJSONArray("logos");
                for (int i = 0; i < arr.length(); ++i) {
                    if (arr.getJSONObject(i).getString("type").equals("icon")) {
                        return arr.getJSONObject(i).getJSONArray("formats").getJSONObject(0).getString("src");
                    }
                }
            }
            catch (Exception e){
                return null;
            }
        }
        return null;
    }
    public String getLogo(){
        if(response!=null) {
            try {
                JSONArray arr = response.getJSONArray("logos");
                for (int i = 0; i < arr.length(); ++i) {
                    if (arr.getJSONObject(i).getString("type").equals("logo")) {
                        return arr.getJSONObject(i).getJSONArray("formats").getJSONObject(0).getString("src");
                    }
                }
            }
            catch (Exception e){
                return null;
            }
        }
        return null;
    }
}
