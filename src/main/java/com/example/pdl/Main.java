package com.example.pdl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        PDL p = new PDL("mcdonalds.com");
        System.out.println(p.getEmployees());
    }
}
