package com.example.merger;

import com.example.Company;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnirestException, IOException, InterruptedException {
        Merger merger = new Merger("ucu.edu.ua");
        Company company = merger.getCompany();
        System.out.println(company.getEmployees());
    }
}
