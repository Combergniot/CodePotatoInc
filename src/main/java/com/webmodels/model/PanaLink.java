package com.webmodels.model;

import java.util.HashMap;

public class PanaLink extends Link {
    
    // product name, product url
    // TODO: refactor into composition instead of HashMap 
    private HashMap<String,String> link;

    public HashMap<String, String> getLink() {
        return link;
    }

    public void setLink(HashMap<String, String> link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "PanaLink{" + "link=" + link + '}';
    }
    
    
    
    
    
}
