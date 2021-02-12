package com.scopemedia.api.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.api.dto.model.Tag;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PredictionResponse extends ScopeResponse implements Parcelable {

    @JsonProperty("tags")
    private Tag[] tags;

    public PredictionResponse() {
        super();
    }

    /**
     * Returns all tags based on the prediction models
     * @return {@link Tag}
     */
    public Tag[] getTags() {
        return tags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelableArray(tags, PARCELABLE_WRITE_RETURN_VALUE);
    }

    private PredictionResponse(Parcel in) {
        super(in);
        this.tags = (Tag[]) in.readParcelableArray(Tag.class.getClassLoader());
    }

    public static final Creator<PredictionResponse> CREATOR = new Creator<PredictionResponse>() {
        @Override
        public PredictionResponse[] newArray(int size) {
            return new PredictionResponse[size];
        }

        @Override
        public PredictionResponse createFromParcel(Parcel source) {
            return new PredictionResponse(source);
        }
    };
}
