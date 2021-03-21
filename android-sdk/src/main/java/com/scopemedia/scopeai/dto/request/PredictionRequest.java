package com.scopemedia.scopeai.dto.request;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.scopemedia.scopeai.Utils;
import com.scopemedia.scopeai.dto.model.Area;
import com.scopemedia.scopeai.dto.model.Model;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionRequest extends ScopeAIRequest implements Parcelable {

    @JsonProperty("base64")
    @SerializedName("base64")
    private String base64;

    @JsonProperty("mediaUrl")
    @SerializedName("mediaUrl")
    private String mediaUrl;

    @JsonProperty("modelId")
    @SerializedName("modelId")
    private String modelId;

    @JsonProperty("area")
    @SerializedName("area")
    private Area area;

    public PredictionRequest() {
    }

    /**
     * Media as Base64, Bitmap or as URL is required
     * @param bitmap media
     * @return PredictionRequest
     */
    public PredictionRequest setMediaAsBitmap(Bitmap bitmap) {
        this.base64 = Utils.bitmap2base64(bitmap);
        return this;
    }

    /**
     * Media as Base64, Bitmap or as URL is required
     * @param base64 encoded media
     * @return PredictionRequest
     */
    public PredictionRequest setMediaAsBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    /**
     * Media as Base64, Bitmap or as URL is required
     * @param url media URL
     * @return PredictionRequest
     */
    public PredictionRequest setMediaAsUrl(String url) {
        this.mediaUrl = url;
        return this;
    }

    /**
     * Image as Base64 or as URl is required
     * @param modelId modelId ID use for prediction. See {@link Model}
     * @return PredictionRequest
     */
    public PredictionRequest setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    /**
     * Set an area which will be used for the prediction
     * @param area Area will be use for the prediction. See {@link Area}
     * @return PredictionRequest
     */
    public PredictionRequest setArea(Area area) {
        this.area = area;
        return this;
    }

    @Override
    public boolean checkAllRequired() {
        return (mediaUrl != null || base64 != null) && modelId != null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(modelId);
        dest.writeString(mediaUrl);
        dest.writeString(base64);
        dest.writeParcelable(area, PARCELABLE_WRITE_RETURN_VALUE);
    }

    private PredictionRequest(Parcel in) {
        super(in);
        this.modelId = in.readString();
        this.mediaUrl = in.readString();
        this.base64 = in.readString();
        this.area = in.readParcelable(Area.class.getClassLoader());
    }

    public static final Creator<PredictionRequest> CREATOR = new Creator<PredictionRequest>() {
        @Override
        public PredictionRequest[] newArray(int size) {
            return new PredictionRequest[size];
        }

        @Override
        public PredictionRequest createFromParcel(Parcel source) {
            return new PredictionRequest(source);
        }
    };
}