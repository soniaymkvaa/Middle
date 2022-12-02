package com.example.parser;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;


public class Parser {
    private String url=null;
    private Document doc = null;

    public void parse() throws IOException {
        Document document = null;
        try{
                document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .get();
        }
        catch (Exception e){
            System.out.println("Not parsable by jsoup(((");
        }
        finally{this.doc = document;}
    }
    public Parser(String domain) throws IOException {
        url = domain;
        parse();
    }
    @SneakyThrows
    public String getName() {
        if (doc!=null){
            return doc.title();
        }
        else{
            return null;
        }
    }
    @SneakyThrows
    public String getFacebook(){
        if (doc!=null){
            String facebook;
            try {
                ArrayList<Element> facebookLink = doc.select("a[href^=https://www.facebook.com/]");
                facebook = facebookLink.get(0).attr("abs:href");
            }
            catch (Exception e){
                facebook = null;
            }
            return facebook;
        }
        else{
            return null;
        }
    }
    @SneakyThrows
    public String getTwitter(){
        if (doc!=null){
            String twitter;
            try {
                ArrayList<Element> twitterLink = doc.select("a[href^=https://twitter.com/]");
                twitter = twitterLink.get(0).attr("abs:href");
            }
            catch (Exception e) {
                twitter = null;
            }
            return twitter;
        }
        else{
            return null;
        }
    }
    @SneakyThrows
    public String getIcon(){
        if (doc!=null){
            String icon;
            try {
                ArrayList<Element> icons = doc.select("head > link[rel=shortcut icon]");
                icon = icons.get(0).attr("abs:href");
            }
            catch (Exception e){
                icon = null;
            }
            return icon;
        }
        else {
            return null;
        }
    }
}
