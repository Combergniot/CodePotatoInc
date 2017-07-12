package com.webmodels.model;

import java.util.HashMap;


public class PanaPageStructure extends PageStructure {
    
    private HashMap<String,Link> models;

    public HashMap<String, Link> getModels() {
        return models;
    }

    public void setModels(HashMap<String, Link> models) {
        this.models = models;
    }
    
    
    
}
