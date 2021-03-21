package com.scopemedia.scopeai.dto.request;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.scopemedia.scopeai.Utils;
import com.scopemedia.scopeai.dto.model.Area;

/**
 * Created by Paul T. on 2020-03-27.
 */

/**
 * Create a request to matching products
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchingImageRequest extends ScopeAIRequest implements Parcelable {

    @JsonProperty("base64")
    @SerializedName("base64")
    private String base64;

    @JsonProperty("mediaId")
    @SerializedName("mediaId")
    private long mediaId;

    @JsonProperty("mediaUrl")
    @SerializedName("mediaUrl")
    private String mediaUrl;

    @JsonProperty("modelId")
    @SerializedName("modelId")
    private String appId;

    @JsonProperty("area")
    @SerializedName("area")
    private Area area;

    @JsonProperty("gender")
    @SerializedName("gender")
    private String gender;

    @JsonProperty("size")
    @SerializedName("size")
    private int size;

    public MatchingImageRequest() {
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param id Media ID
     * @return MatchingImageRequest
     */
    public MatchingImageRequest setMediaId(long id) {
        this.mediaId = id;
        return this;
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param bitmap encoded media
     * @return MatchingImageRequest
     */
    public MatchingImageRequest setMediaAsBitmap(Bitmap bitmap) {
        this.base64 = Utils.bitmap2base64(bitmap);
        return this;
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param base64 encoded media
     * @return MatchingImageRequest
     */
    public MatchingImageRequest setMediaAsBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param url media URL
     * @return MatchingImageRequest
     */
    public MatchingImageRequest setMediaAsUrl(String url) {
        this.mediaUrl = url;
        return this;
    }

    /**
     * @param appId app ID use for matching images.
     * @return MatchingImageRequest
     */
    public MatchingImageRequest setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    /**
     * Set an area which will be used for the matching images
     * @param area Area will be used for the matching images. See {@link Area}
     * @return MatchingImageRequest
     */
    public MatchingImageRequest setArea(Area area) {
        this.area = area;
        return this;
    }

    /**
     * Set gender filter for matching images
     * @param gender Must be either "M" for male or "F" for female
     * @return MatchingImageRequest
     */
    public MatchingImageRequest setGender(String gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Set number of matching image groups returned
     * @param size Default to 3 groups if not set
     */
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean checkAllRequired() {
        return mediaId != 0.0 || mediaUrl != null || base64 != null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.base64);
        dest.writeLong(this.mediaId);
        dest.writeString(this.mediaUrl);
        dest.writeString(this.appId);
        dest.writeParcelable(this.area, flags);
        dest.writeString(this.gender);
        dest.writeInt(this.size);
    }

    protected MatchingImageRequest(Parcel in) {
        super(in);
        this.base64 = in.readString();
        this.mediaId = in.readLong();
        this.mediaUrl = in.readString();
        this.appId = in.readString();
        this.area = in.readParcelable(Area.class.getClassLoader());
        this.gender = in.readString();
        this.size = in.readInt();
    }

    public static final Creator<MatchingImageRequest> CREATOR = new Creator<MatchingImageRequest>() {
        @Override
        public MatchingImageRequest createFromParcel(Parcel source) {
            return new MatchingImageRequest(source);
        }

        @Override
        public MatchingImageRequest[] newArray(int size) {
            return new MatchingImageRequest[size];
        }
    };
}
