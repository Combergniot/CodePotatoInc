package com.webmodels.model;

import java.util.List;

public class PanaProduct extends Product {

    private String symbol;
    private String heroImage;
    private String heading;
    private String subHeading;
    private List<String> images360;
    private List<Feature> features;
    private List<String> icons;
    private String dimensionImage;
    private List<String> videos;
    private String specUrl;

    public PanaProduct(String url) {
        super(url);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(String heroImage) {
        this.heroImage = heroImage;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public List<String> getImages360() {
        return images360;
    }

    public void setImages360(List<String> images360) {
        this.images360 = images360;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<String> getIcons() {
        return icons;
    }

    public void setIcons(List<String> icons) {
        this.icons = icons;
    }

    public String getDimensionImage() {
        return dimensionImage;
    }

    public void setDimensionImage(String dimensionImage) {
        this.dimensionImage = dimensionImage;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public String getSpecUrl() {
        return specUrl;
    }

    public void setSpecUrl(String specUrl) {
        this.specUrl = specUrl;
    }

    @Override
    public String toString() {
        return "PanaProduct{" + "symbol=" + symbol + ", heroImage=" + heroImage + ", heading=" + heading + ", subHeading=" + subHeading + ", images360=" + images360 + ", features=" + features + ", icons=" + icons + ", dimensionImage=" + dimensionImage + ", videos=" + videos + ", specUrl=" + specUrl + '}';
    }

}
