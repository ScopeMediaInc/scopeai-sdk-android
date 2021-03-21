package com.scopemedia.scopeai.dto.request;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Maikel Rehl on 6/12/2017.
 */

public abstract class ScopeAIRequest implements Parcelable {

    public abstract boolean checkAllRequired();

    public ScopeAIRequest() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    protected ScopeAIRequest(Parcel in) {
    }
}
