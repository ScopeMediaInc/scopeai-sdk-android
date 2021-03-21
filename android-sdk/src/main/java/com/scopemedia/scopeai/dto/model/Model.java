package com.scopemedia.scopeai.dto.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by maikel on 2017-03-27.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Model implements Parcelable {

    @JsonProperty("modelId")
    @SerializedName("modelId")
    private String id;

    @JsonProperty("creationTime")
    @SerializedName("creationTime")
    private String creationTime;

    @JsonProperty("description")
    @SerializedName("description")
    private String description;

    @JsonProperty("modelName")
    @SerializedName("modelName")
    private String name;

    @JsonProperty("public")
    @SerializedName("public")
    private boolean publicModel;

    @JsonProperty("status")
    @SerializedName("status")
    private String status;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ", Locale.getDefault());

    public Model() {
    }

    public Model setId(String id) {
        this.id = id;
        return this;
    }

    public Model setCreationTime(String creationTime) {
        this.creationTime = creationTime;
        return this;
    }

    public Model setDescription(String description) {
        this.description = description;
        return this;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public Model setPublicModel(boolean publicModel) {
        this.publicModel = publicModel;
        return this;
    }

    public Model setStatus(String status) {
        this.status = status;
        return this;
    }

    public Model setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    /**
     * @return modelID
     */
    public String getId() {
        return id;
    }

    /**
     * @return creation date
     */
    public Date getCreationTime() {
        try {
            return dateFormat.parse(creationTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return description of the model
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return model name
     */
    public String getName() {
        return name;
    }

    /**
     * @return public model
     */
    public boolean isPublicModel() {
        return publicModel;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.creationTime);
        dest.writeString(this.description);
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeByte((byte) (this.publicModel ? 1 : 0));
        dest.writeString(this.status);
    }

    public Model(Parcel in) {
        this.creationTime = in.readString();
        this.description = in.readString();
        this.id = in.readString();
        this.name = in.readString();
        this.publicModel = (in.readByte() != 0);
        this.status = in.readString();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }

        @Override
        public Model createFromParcel(Parcel source) {
            return new Model(source);
        }
    };
}