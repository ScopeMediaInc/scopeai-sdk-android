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
 * Created by maikel on 2017-03-27.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimilarImageRequest extends ScopeAIRequest implements Parcelable {

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

    public SimilarImageRequest() {
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param id Media ID
     * @return PredictionRequest
     */
    public SimilarImageRequest setMediaId(long id) {
        this.mediaId = id;
        return this;
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param bitmap encoded media
     * @return SimilarImageRequest
     */
    public SimilarImageRequest setMediaAsBitmap(Bitmap bitmap) {
        this.base64 = Utils.bitmap2base64(bitmap);
        return this;
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param base64 encoded media
     * @return SimilarImageRequest
     */
    public SimilarImageRequest setMediaAsBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    /**
     * Media as ID, Bitmap, Base64 or as URL is required
     * @param url media URL
     * @return SimilarImageRequest
     */
    public SimilarImageRequest setMediaAsUrl(String url) {
        this.mediaUrl = url;
        return this;
    }

    /**
     * @param appId app ID use for similar images.
     * @return SimilarImageRequest
     */
    public SimilarImageRequest setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    /**
     * Set an area which will be used for the similar images
     * @param area Area will be used for the similar images. See {@link Area}
     * @return SimilarImageRequest
     */
    public SimilarImageRequest setArea(Area area) {
        this.area = area;
        return this;
    }

    /**
     * Set gender filter for similar images
     * @param gender Must be either "M" for male or "F" for female
     * @return SimilarImageRequest
     */
    public SimilarImageRequest setGender(String gender) {
        this.gender = gender;
        return this;
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
        dest.writeString(appId);
        dest.writeLong(mediaId);
        dest.writeString(mediaUrl);
        dest.writeString(base64);
        dest.writeParcelable(area, PARCELABLE_WRITE_RETURN_VALUE);
        dest.writeString(gender);
    }

    private SimilarImageRequest(Parcel in) {
        super(in);
        this.appId = in.readString();
        this.mediaId = in.readLong();
        this.mediaUrl = in.readString();
        this.base64 = in.readString();
        this.area = in.readParcelable(Area.class.getClassLoader());
        this.gender = in.readString();
    }

    public static final Creator<SimilarImageRequest> CREATOR = new Creator<SimilarImageRequest>() {
        @Override
        public SimilarImageRequest[] newArray(int size) {
            return new SimilarImageRequest[size];
        }

        @Override
        public SimilarImageRequest createFromParcel(Parcel source) {
            return new SimilarImageRequest(source);
        }
    };
}
