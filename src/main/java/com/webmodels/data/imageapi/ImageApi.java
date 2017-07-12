package com.webmodels.data.imageapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageApi {
    

@SerializedName("set")
@Expose
private Set set;

public Set getSet() {
return set;
}

public void setSet(Set set) {
this.set = set;
}

    @Override
    public String toString() {
        return "ImageApi{" + "set=" + set + '}';
    }



}
    

