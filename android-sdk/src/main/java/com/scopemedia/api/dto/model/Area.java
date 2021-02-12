package com.scopemedia.api.dto.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maikel Rehl on 6/12/2017.
 */

public class Area implements Parcelable {

    @JsonProperty("x")
    private int startX;

    @JsonProperty("y")
    private int startY;

    @JsonProperty("w")
    private int width;

    @JsonProperty("h")
    private int height;

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

    public Area(Parcel in) {
        this.startX = in.readInt();
        this.startY = in.readInt();
        this.width = in.readInt();
        this.height = in.readInt();
    }

    public static final Creator<Area> CREATOR = new Creator<Area>() {
        @Override
        public Area[] newArray(int size) {
            return new Area[size];
        }

        @Override
        public Area createFromParcel(Parcel source) {
            return new Area(source);
        }
    };
}
