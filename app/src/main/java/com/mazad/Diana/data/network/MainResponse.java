/*
 * Copyright (c) 2020. By Ahmed Noby Ahmed
 */

package com.mazad.Diana.data.network;

import com.google.gson.annotations.SerializedName;

public class MainResponse<T> {
    @SerializedName("success")
    public boolean success;
    @SerializedName("message")
    public String message;
    @SerializedName("statusCode")
    public int statusCode;
    @SerializedName("itemsCount")
    public int itemsCount;
    @SerializedName("data")
    public T data;

}
