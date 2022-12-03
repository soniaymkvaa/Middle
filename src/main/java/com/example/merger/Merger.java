package com.example.merger;

import com.example.brandfetch.Brandfetch;
import com.example.google.GooglePlaces;
import com.example.parser.Parser;
import com.example.pdl.PDL;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class Merger {
    private String domain;
    private GooglePlaces googleResponse;
    private PDL pdlResponse;
    private Brandfetch brandFetchResponse;
    private Parser parserResponse;
    public Merger(String domain_company) throws IOException, InterruptedException, UnirestException {
        domain = domain_company;
        googleResponse = new GooglePlaces(domain_company);
        pdlResponse = new PDL(domain_company);
        parserResponse = new Parser(domain_company);
        brandFetchResponse = new Brandfetch(domain_company);

    }
    public String getName(){
        return parserResponse.getName();
    }
    public String getTwitter(){
        String brandFetchTwitter = brandFetchResponse.getTwitter();
        if(brandFetchTwitter==null){
            return parserResponse.getTwitter();
        }
        else{
            return brandFetchTwitter;
        }
    }
    public String getFacebook(){
        String brandFetchFacebook = brandFetchResponse.getFacebook();
        if(brandFetchFacebook==null){
            return parserResponse.getFacebook();
        }
        else{
            return brandFetchFacebook;
        }
    }
    public String getLogo() {
        return brandFetchResponse.getLogo();
    }
    public String getIcon(){
        String brandFetchIcon = brandFetchResponse.getIcon();
        if(brandFetchIcon==null){
            return parserResponse.getIcon();
        }
        else{
            return brandFetchIcon;
        }
    }
    public String getEmployees(){
        return pdlResponse.getEmployees();
    }
    public String getAddress(){
        return googleResponse.getAddress();
    }
}
