package com.scopemedia.api.dto.request;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Maikel Rehl on 6/12/2017.
 */

public abstract class ScopeRequest implements Parcelable {

    public abstract boolean checkAllRequired();

    public ScopeRequest() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    protected ScopeRequest(Parcel in) {
    }
}
