package com.scopemedia.api.dto.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag implements Parcelable {

    @JsonProperty("label")
    private String label;

    @JsonProperty("score")
    private String score;

    public Tag() {
    }

    public Tag setLabel(String label) {
        this.label = label;
        return this;
    }

    public Tag setScore(String score) {
        this.score = score;
        return this;
    }

    public String getTag() {
        return (label == null) ? "" : label.toLowerCase().trim();
    }

    public double getScore() {
        return Double.parseDouble(score);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.label);
        dest.writeString(this.score);
    }

    public Tag(Parcel in) {
        this.label = in.readString();
        this.score = in.readString();
    }

    public static final Creator<Tag> CREATOR = new Creator<Tag>() {
        @Override
        public Tag[] newArray(int size) {
            return new Tag[size];
        }

        @Override
        public Tag createFromParcel(Parcel source) {
            return new Tag(source);
        }
    };
}