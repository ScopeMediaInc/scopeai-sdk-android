package com.scopemedia.api.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scopemedia.api.dto.model.Model;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelResponse extends ScopeResponse implements Parcelable {

    @JsonProperty("models")
    private Model[] models;

    public ModelResponse() {
        super();
    }

    /**
     * Returns all prediction models
     * @return {@link Model}
     */
    public Model[] getModels() {
        return models;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelableArray(models, PARCELABLE_WRITE_RETURN_VALUE);
    }

    private ModelResponse(Parcel in) {
        super(in);
        this.models = (Model[]) in.readParcelableArray(Model.class.getClassLoader());
    }

    public static final Creator<ModelResponse> CREATOR = new Creator<ModelResponse>() {
        @Override
        public ModelResponse[] newArray(int size) {
            return new ModelResponse[size];
        }

        @Override
        public ModelResponse createFromParcel(Parcel source) {
            return new ModelResponse(source);
        }
    };
}
