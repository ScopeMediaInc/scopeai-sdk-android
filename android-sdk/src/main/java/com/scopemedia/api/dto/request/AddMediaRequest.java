package com.scopemedia.api.dto.request;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.api.dto.model.Media;

/**
 * Created by maikel on 2017-03-27.
 */

/**
 * Create a request to upload new media files to your similar images pool
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddMediaRequest extends ScopeRequest implements Parcelable {

    @JsonProperty("medias")
    private Media[] medias;

    public AddMediaRequest() {
    }

    /**
     * Array of Medias to add to your similar images pool
     * @param medias List of new medias. See {@link Media}
     */
    public AddMediaRequest(Media[] medias) {
        this.medias = medias;
    }

    /**
     * Array of Medias to add to your similar images pool
     * @param medias List of new medias. See {@link Media}
     * @return AddMediaRequest
     */
    public AddMediaRequest setMedias(Media[] medias) {
        this.medias = medias;
        return this;
    }

    @Override
    public boolean checkAllRequired() {
        return medias != null;
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

    private AddMediaRequest(Parcel in) {
        super(in);
        this.medias = (Media[]) in.readParcelableArray(Media.class.getClassLoader());
    }

    public static final Creator<AddMediaRequest> CREATOR = new Creator<AddMediaRequest>() {
        @Override
        public AddMediaRequest[] newArray(int size) {
            return new AddMediaRequest[size];
        }

        @Override
        public AddMediaRequest createFromParcel(Parcel source) {
            return new AddMediaRequest(source);
        }
    };
}
