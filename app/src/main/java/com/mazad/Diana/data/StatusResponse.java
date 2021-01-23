package com.mazad.Diana.data;

import com.google.gson.annotations.SerializedName;

public class StatusResponse {
    @SerializedName("status")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
