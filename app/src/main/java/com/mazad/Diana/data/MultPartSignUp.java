package com.mazad.Diana.data;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Part;

public class MultPartSignUp {
    public MultipartBody.Part profile_image;
    public RequestBody name;
    public RequestBody email;
    public RequestBody fame;
    public  RequestBody mobile;
    public  RequestBody city;
    public RequestBody password;
    public  RequestBody governorate;
}
