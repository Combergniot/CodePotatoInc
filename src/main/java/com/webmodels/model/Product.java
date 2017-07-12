package com.webmodels.model;

/**
 * Created by Marcin on 2017-06-06.
 */
public abstract class Product {

    private String name;
    private String url;

    public Product(String url){
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
