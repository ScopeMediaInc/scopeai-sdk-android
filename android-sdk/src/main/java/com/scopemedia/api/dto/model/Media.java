package com.scopemedia.api.dto.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maikel Rehl on 6/12/2017.
 */

public class Media implements Parcelable {

    @JsonProperty("mediaId")
    private long id;

    @JsonProperty("mediaUrl")
    private String url;

    public Media() {
    }

    public Media setId(long id) {
        this.id = id;
        return this;
    }

    public Media setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     *
     * @return mediaID
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @return media URL
     */
    public String getUrl() {
        return url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.url);
    }

    public Media(Parcel in) {
        this.id = in.readLong();
        this.url = in.readString();
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }

        @Override
        public Media createFromParcel(Parcel source) {
            return new Media(source);
        }
    };
}
