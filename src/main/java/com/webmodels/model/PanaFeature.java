package com.webmodels.model;

/**
 * Created by Marcin on 2017-06-06.
 */
public class PanaFeature  extends Feature {

    private String image;
    private String copy;
    private String videoUrl;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "PanaFeature{" +
                "image='" + image + '\'' +
                ", copy='" + copy + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PanaFeature that = (PanaFeature) o;

        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (copy != null ? !copy.equals(that.copy) : that.copy != null) return false;
        return videoUrl != null ? videoUrl.equals(that.videoUrl) : that.videoUrl == null;
    }

    @Override
    public int hashCode() {
        int result = image != null ? image.hashCode() : 0;
        result = 31 * result + (copy != null ? copy.hashCode() : 0);
        result = 31 * result + (videoUrl != null ? videoUrl.hashCode() : 0);
        return result;
    }
}
