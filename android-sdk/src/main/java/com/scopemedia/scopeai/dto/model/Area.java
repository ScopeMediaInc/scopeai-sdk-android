package com.scopemedia.scopeai.dto.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * @author Maikel Rehl on 6/12/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Area implements Parcelable {

    @JsonProperty("x")
    @SerializedName("x")
    protected int startX;

    @JsonProperty("y")
    @SerializedName("y")
    protected int startY;

    @JsonProperty("w")
    @SerializedName("w")
    protected int width;

    @JsonProperty("h")
    @SerializedName("h")
    protected int height;

    public Area() {
    }

    /**
     * Set an area of an image
     * @param startX start position X
     * @param startY start position Y
     * @param width width
     * @param height height
     */
    public Area(int startX, int startY, int width, int height) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.startX);
        dest.writeInt(this.startY);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
    }

    protected Area(Parcel in) {
        this.startX = in.readInt();
        this.startY = in.readInt();
        this.width = in.readInt();
        this.height = in.readInt();
    }

    public static final Creator<Area> CREATOR = new Creator<Area>() {
        @Override
        public Area createFromParcel(Parcel source) {
            return new Area(source);
        }

        @Override
        public Area[] newArray(int size) {
            return new Area[size];
        }
    };
}