package com.scopemedia.api.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.api.dto.model.Media;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SimilarImageResponse extends ScopeResponse implements Parcelable {

    @JsonProperty("medias")
    private Media[] medias;

    public SimilarImageResponse() {
        super();
    }

    /**
     * Returns all similar medias
     * @return {@link Media}
     */
    public Media[] getMedias() {
        return medias;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelableArray(medias, PARCELABLE_WRITE_RETURN_VALUE);
    }

    private SimilarImageResponse(Parcel in) {
        super(in);
        medias = (Media[]) in.readParcelableArray(Media.class.getClassLoader());
    }

    public static final Creator<SimilarImageResponse> CREATOR = new Creator<SimilarImageResponse>() {
        @Override
        public SimilarImageResponse[] newArray(int size) {
            return new SimilarImageResponse[size];
        }

        @Override
        public SimilarImageResponse createFromParcel(Parcel source) {
            return new SimilarImageResponse(source);
        }
    };
}