package com.webmodels.data.imageapi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Set {

@SerializedName("pv")
@Expose
private String pv;
@SerializedName("type")
@Expose
private String type;
@SerializedName("n")
@Expose
private String n;
@SerializedName("item")
@Expose
private List<Item> item = null;

public String getPv() {
return pv;
}

public void setPv(String pv) {
this.pv = pv;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getN() {
return n;
}

public void setN(String n) {
this.n = n;
}

public List<Item> getItem() {
return item;
}

public void setItem(List<Item> item) {
this.item = item;
}

    @Override
    public String toString() {
        return "Set{" + "pv=" + pv + ", type=" + type + ", n=" + n + ", item=" + item + '}';
    }



}

