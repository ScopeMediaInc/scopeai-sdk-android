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
public class Media implements Parcelable {

    @JsonProperty("mediaId")
    @SerializedName("mediaId")
    private long id;

    @JsonProperty("mediaUrl")
    @SerializedName("mediaUrl")
    private String url;

    @JsonProperty("mediaThumbnail")
    @SerializedName("mediaThumbnail")
    private String thumbnail;

    @JsonProperty("metadata")
    @SerializedName("metadata")
    private Metadata metadata;

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

    public Media setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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

    /**
     *
     * @return media thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.url);
        dest.writeString(this.thumbnail);
        dest.writeParcelable(this.metadata, flags);
    }

    protected Media(Parcel in) {
        this.id = in.readLong();
        this.url = in.readString();
        this.thumbnail = in.readString();
        this.metadata = in.readParcelable(Metadata.class.getClassLoader());
    }

    public static final Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel source) {
            return new Media(source);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };
}