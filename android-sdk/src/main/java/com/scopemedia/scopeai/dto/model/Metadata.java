package com.scopemedia.scopeai.dto.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata implements Parcelable {

    @JsonProperty("itemId")
    @SerializedName("itemId")
    private String itemId;

    @JsonProperty("gender")
    @SerializedName("gender")
    private String gender;

    @JsonProperty("price")
    @SerializedName("price")
    private String price;

    @JsonProperty("appId")
    @SerializedName("appId")
    private String appId;

    @JsonProperty("caption")
    @SerializedName("caption")
    private String caption;

    @JsonProperty("currency")
    @SerializedName("currency")
    private String currency;

    @JsonProperty("source")
    @SerializedName("source")
    private String source;

    @JsonProperty("classification")
    @SerializedName("classification")
    private String classification;

    @JsonProperty("brand")
    @SerializedName("brand")
    private String brand;

    @JsonProperty("store")
    @SerializedName("store")
    private String store;

    @JsonProperty("primary")
    @SerializedName("primary")
    private boolean primary;

    @JsonProperty("shotTime")
    @SerializedName("shotTime")
    private long shotTime;

    @JsonProperty("fashionScore")
    @SerializedName("fashionScore")
    private String fashionScore;

    @JsonProperty("category")
    @SerializedName("category")
    private String category;

    @JsonProperty("subcategory")
    @SerializedName("subcategory")
    private String subcategory;

    public Metadata() {
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public long getShotTime() {
        return shotTime;
    }

    public void setShotTime(long shotTime) {
        this.shotTime = shotTime;
    }

    public String getFashionScore() {
        return fashionScore;
    }

    public void setFashionScore(String fashionScore) {
        this.fashionScore = fashionScore;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.itemId);
        dest.writeString(this.gender);
        dest.writeString(this.price);
        dest.writeString(this.appId);
        dest.writeString(this.caption);
        dest.writeString(this.currency);
        dest.writeString(this.source);
        dest.writeString(this.classification);
        dest.writeString(this.brand);
        dest.writeString(this.store);
        dest.writeByte(this.primary ? (byte) 1 : (byte) 0);
        dest.writeLong(this.shotTime);
        dest.writeString(this.fashionScore);
        dest.writeString(this.category);
        dest.writeString(this.subcategory);
    }

    protected Metadata(Parcel in) {
        this.itemId = in.readString();
        this.gender = in.readString();
        this.price = in.readString();
        this.appId = in.readString();
        this.caption = in.readString();
        this.currency = in.readString();
        this.source = in.readString();
        this.classification = in.readString();
        this.brand = in.readString();
        this.store = in.readString();
        this.primary = in.readByte() != 0;
        this.shotTime = in.readLong();
        this.fashionScore = in.readString();
        this.category = in.readString();
        this.subcategory = in.readString();
    }

    public static final Creator<Metadata> CREATOR = new Creator<Metadata>() {
        @Override
        public Metadata createFromParcel(Parcel source) {
            return new Metadata(source);
        }

        @Override
        public Metadata[] newArray(int size) {
            return new Metadata[size];
        }
    };
}
