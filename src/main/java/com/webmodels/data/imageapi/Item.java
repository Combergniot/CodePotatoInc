package com.webmodels.data.imageapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

@SerializedName("i")
@Expose
private I i;
@SerializedName("dx")
@Expose
private String dx;
@SerializedName("dy")
@Expose
private String dy;
@SerializedName("iv")
@Expose
private String iv;

public I getI() {
return i;
}

public void setI(I i) {
this.i = i;
}

public String getDx() {
return dx;
}

public void setDx(String dx) {
this.dx = dx;
}

public String getDy() {
return dy;
}

public void setDy(String dy) {
this.dy = dy;
}

public String getIv() {
return iv;
}

public void setIv(String iv) {
this.iv = iv;
}

    @Override
    public String toString() {
        return "Item{" + "i=" + i + ", dx=" + dx + ", dy=" + dy + ", iv=" + iv + '}';
    }



}
