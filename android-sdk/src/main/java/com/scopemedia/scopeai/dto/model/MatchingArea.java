package com.scopemedia.scopeai.dto.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchingArea extends Area implements Parcelable {

    @JsonProperty("tag")
    @SerializedName("tag")
    protected String tag;

    public MatchingArea() {
        super();
    }

    /**
     * Set an area of an image with a tag
     * @param startX start position X
     * @param startY start position Y
     * @param width width
     * @param height height
     * @param tag tag
     */
    public MatchingArea(int startX, int startY, int width, int height, String tag) {
        super(startX, startY, width, height);
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.tag);
    }

    protected MatchingArea(Parcel in) {
        super(in);
        this.tag = in.readString();
    }

    public static final Creator<MatchingArea> CREATOR = new Creator<MatchingArea>() {
        @Override
        public MatchingArea createFromParcel(Parcel source) {
            return new MatchingArea(source);
        }

        @Override
        public MatchingArea[] newArray(int size) {
            return new MatchingArea[size];
        }
    };
}
