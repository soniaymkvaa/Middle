package com.example.parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Parser p = new Parser("https://google.com/");
        System.out.println(p.getName());
        System.out.println(p.getFacebook());
        System.out.println(p.getTwitter());
        System.out.println(p.getIcon());
    }
}
