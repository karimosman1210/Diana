package com.mazad.Diana.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sale_typeResponse  implements Parcelable {
    private Integer id;
    private String title;

    public Sale_typeResponse(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected Sale_typeResponse(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Sale_typeResponse> CREATOR = new Creator<Sale_typeResponse>() {
        @Override
        public Sale_typeResponse createFromParcel(Parcel in) {
            return new Sale_typeResponse(in);
        }

        @Override
        public Sale_typeResponse[] newArray(int size) {
            return new Sale_typeResponse[size];
        }
    };
}
