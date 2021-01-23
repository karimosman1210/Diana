package com.mazad.Diana.data.network;

import android.content.Context;

import com.mazad.Diana.data.MultPartPostDirectSale;
import com.mazad.Diana.data.MultPartPostMazadSale;
import com.mazad.Diana.data.MultPartSignUp;

import org.json.JSONException;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MainApiBody {
    public static final String JSON_TYPE = "application/json";

    public static MultPartSignUp multPartSignUp (String phone  , String password, String firstName, String neckName
            , String email, File image,String countryId){
        RequestBody nameResponse = null,neckNameResponse= null ,phoneResponse= null ,emailResponse= null,passResponse= null,countryResponse=null ;
        MultipartBody.Part imageResponse  =null ;
        if(image != null) {
            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), image);
            imageResponse = MultipartBody.Part.createFormData("image", image.getName(), reqFile);
        }
        if(phone != null) {
            phoneResponse = RequestBody.create(MediaType.parse(JSON_TYPE), phone);
        }
        if(password != null) {
            passResponse= RequestBody.create(MediaType.parse(JSON_TYPE), password);
        }if(firstName != null) {
            nameResponse= RequestBody.create(MediaType.parse(JSON_TYPE), firstName);
        }if(neckName != null) {
            neckNameResponse= RequestBody.create(MediaType.parse(JSON_TYPE), neckName);
        }if(email != null) {
            emailResponse= RequestBody.create(MediaType.parse(JSON_TYPE), email);
        }
        if(countryId != null) {
            countryResponse= RequestBody.create(MediaType.parse(JSON_TYPE), countryId);
        }


        MultPartSignUp multPartSignUp =new MultPartSignUp();
        multPartSignUp.profile_image=imageResponse;
        multPartSignUp.email=emailResponse;
        multPartSignUp.name=nameResponse;
        multPartSignUp.fame=neckNameResponse;
        multPartSignUp.mobile =phoneResponse ;
        multPartSignUp.password=passResponse ;
        multPartSignUp.governorate=countryResponse ;
        return multPartSignUp;
    }



    public static MultPartPostDirectSale PostDirctBody(String categoryId, String band_rakam, String general_description
            , String price, String publisher_id,String available_number,String keys,String valuses){

        RequestBody categoryIdRequest=null ,band_rakamRequest = null ,general_descriptionRequest = null
                ,priceRequest = null,keyReuest=null,valuesRequest=null  ,pusherRequst=null,available_numberRequest=null ;

        if(categoryId != null) {
            categoryIdRequest = RequestBody.create(MediaType.parse(JSON_TYPE), categoryId);
        }

        if(band_rakam != null) {
            band_rakamRequest = RequestBody.create(MediaType.parse(JSON_TYPE), band_rakam);
        }
        if(keys != null) {
            keyReuest = RequestBody.create(MediaType.parse(JSON_TYPE), keys);
        }
        if(valuses != null) {
            valuesRequest = RequestBody.create(MediaType.parse(JSON_TYPE), valuses);
        }
        if(band_rakam != null) {
            band_rakamRequest = RequestBody.create(MediaType.parse(JSON_TYPE), band_rakam);
        }

        if(general_description != null) {
            general_descriptionRequest = RequestBody.create(MediaType.parse(JSON_TYPE), general_description);
        }
        if(publisher_id != null) {
            pusherRequst = RequestBody.create(MediaType.parse(JSON_TYPE), publisher_id);
        }
        if(available_number != null) {
            available_numberRequest = RequestBody.create(MediaType.parse(JSON_TYPE), available_number);
        }

        if(price != null) {
            priceRequest = RequestBody.create(MediaType.parse(JSON_TYPE), price);
        }

        MultPartPostDirectSale multiPartImage =new MultPartPostDirectSale() ;
        multiPartImage.available_numberRequest = available_numberRequest ;
        multiPartImage.pusherRequst = pusherRequst ;
        multiPartImage.cat_id = categoryIdRequest ;
        multiPartImage.keys = keyReuest ;
        multiPartImage.values = valuesRequest ;
        multiPartImage.general_description= general_descriptionRequest ;
        multiPartImage.band_rkm=band_rakamRequest;
        multiPartImage.price = priceRequest ;
        return multiPartImage;
    }

    public static HashMap<String, String> LoginBoby(String PhoneNumber  , String Password ) throws JSONException {
        HashMap<String, String> params=new HashMap<String, String>();
        params.put("mobile", PhoneNumber);
        params.put("password", Password);

        return params;
    }


    public static MultPartPostMazadSale PostMazadBody(String categoryId, String band_rakam, String general_description
            , String price, String publisher_id,String keys,String valuses,
                                                      String add_time_state, String end_add_time,
                                                      String require_price_enddate, String right_back,
                                                      String raise, String raise_rkm,
                                                      String less_raise, String enter_mazad){

        RequestBody categoryIdRequest=null ,band_rakamRequest = null ,general_descriptionRequest = null
                ,priceRequest = null,keyReuest=null,valuesRequest=null  ,pusherRequst=null
                ,add_time_stateReuest=null,end_add_timeReuest=null,require_price_enddateReuest=null,
                right_backReuest=null,raiseReuest=null,raise_rkmReuest=null,
                less_raiseReuest=null,enter_mazadReuest=null;

        if(categoryId != null) {
            categoryIdRequest = RequestBody.create(MediaType.parse(JSON_TYPE), categoryId);
        }

        if(band_rakam != null) {
            band_rakamRequest = RequestBody.create(MediaType.parse(JSON_TYPE), band_rakam);
        }
        if(keys != null) {
            keyReuest = RequestBody.create(MediaType.parse(JSON_TYPE), keys);
        }
        if(valuses != null) {
            valuesRequest = RequestBody.create(MediaType.parse(JSON_TYPE), valuses);
        }
        if(band_rakam != null) {
            band_rakamRequest = RequestBody.create(MediaType.parse(JSON_TYPE), band_rakam);
        }

        if(general_description != null) {
            general_descriptionRequest = RequestBody.create(MediaType.parse(JSON_TYPE), general_description);
        }
        if(publisher_id != null) {
            pusherRequst = RequestBody.create(MediaType.parse(JSON_TYPE), publisher_id);
        }
        if(price != null) {
            priceRequest = RequestBody.create(MediaType.parse(JSON_TYPE), price);
        }

        if(add_time_state != null) {
            add_time_stateReuest = RequestBody.create(MediaType.parse(JSON_TYPE), add_time_state);
        }

        if(end_add_time != null) {
            end_add_timeReuest = RequestBody.create(MediaType.parse(JSON_TYPE), end_add_time);
        }
        if(require_price_enddate != null) {
            require_price_enddateReuest = RequestBody.create(MediaType.parse(JSON_TYPE), require_price_enddate);
        }

        if(right_back != null) {
            right_backReuest = RequestBody.create(MediaType.parse(JSON_TYPE), right_back);
        }
        if(raise != null) {
            raiseReuest = RequestBody.create(MediaType.parse(JSON_TYPE), raise);
        }
        if(raise_rkm != null) {
            raise_rkmReuest = RequestBody.create(MediaType.parse(JSON_TYPE), raise_rkm);
        }
        if(less_raise != null) {
            less_raiseReuest = RequestBody.create(MediaType.parse(JSON_TYPE), less_raise);
        }
        if(enter_mazad != null) {
            enter_mazadReuest = RequestBody.create(MediaType.parse(JSON_TYPE), enter_mazad);
        }
        MultPartPostMazadSale multiPartImage =new MultPartPostMazadSale() ;
        multiPartImage.pusherRequst = pusherRequst ;
        multiPartImage.cat_id = categoryIdRequest ;
        multiPartImage.keys = keyReuest ;
        multiPartImage.values = valuesRequest ;
        multiPartImage.general_description= general_descriptionRequest ;
        multiPartImage.band_rkm=band_rakamRequest;
        multiPartImage.price = priceRequest ;
        multiPartImage.add_time_state=add_time_stateReuest;
        multiPartImage.end_add_time=end_add_timeReuest;

        multiPartImage.require_price_enddate=require_price_enddateReuest;
        multiPartImage.right_back=right_backReuest;
        multiPartImage.raise=raiseReuest;
        multiPartImage.raise_rkm=raise_rkmReuest;
        multiPartImage.less_raise=less_raiseReuest;
        multiPartImage.enter_mazad=enter_mazadReuest;

        return multiPartImage;
    }

}
