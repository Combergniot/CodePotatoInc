package com.webmodels.data.imageapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class I {

    @SerializedName("n")
    @Expose
    private String n;

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "I{" + "n=" + n + '}';
    }

    
}
