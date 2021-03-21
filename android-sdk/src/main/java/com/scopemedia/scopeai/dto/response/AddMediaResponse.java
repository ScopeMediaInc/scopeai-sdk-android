package com.scopemedia.scopeai.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import com.scopemedia.scopeai.dto.model.Media;

/**
 * Created by maikel on 2017-03-27.
 */

/**
 * Return all media files you added to your similar images pool
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddMediaResponse extends ScopeAIResponse implements Parcelable {

    @JsonProperty("medias")
    @SerializedName("medias")
    private Media[] medias;

    public AddMediaResponse() {
    }

    /**
     * Array of Medias you added to your similar images pool
     * @return Array of Medias you added to your similar images pool. See {@link Media}
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

    private AddMediaResponse(Parcel in) {
        super(in);
        this.medias = (Media[]) in.readParcelableArray(Media.class.getClassLoader());
    }

    public static final Creator<AddMediaResponse> CREATOR = new Creator<AddMediaResponse>() {
        @Override
        public AddMediaResponse[] newArray(int size) {
            return new AddMediaResponse[size];
        }

        @Override
        public AddMediaResponse createFromParcel(Parcel source) {
            return new AddMediaResponse(source);
        }
    };
}
