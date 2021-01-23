package com.mazad.Diana.utels;

import com.mazad.Diana.data.CategoriesResponse;
import com.mazad.Diana.data.Sale_typeResponse;
import com.mazad.Diana.data.UserResponse;

import java.util.List;

public class AppConstant {
    public static final String ACCEPT_LANG = "Accept-Language";
    public static final String CONTENT_JSON = "content-type: application/json";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BASE_URL = "https://seammme.com/diana/api/";
    public static UserResponse userResponse = null;
    public static String Tokenbar = null;
    public static final String BASE_IMAGE = "https://seammme.com/diana/public/uploads/user_images/";
    //static list

    public static List<CategoriesResponse> catList = null;
    public static List<Sale_typeResponse> mazadatList = null;
    public static List<Sale_typeResponse> directList = null;


    public static int  saleTypeId;
    public static int catId ;

    //
    public static final int UPLOAD_ADDS = 1,
            LIST_DIRECT_ADD_FRAGMENT = 2,
                ADDS_DETAILS_PAGE = 3,
            MY_BOOK_FRAGMENT = 4,
            MY_STORE_FRAGMENT=5,
            UPLOAD_MAZAD_FRAGMENT=6,
            DISPLAY_MAZAD_FRAGMENT=7,
            MY_ADDS_FRAGMENT=8,
            HOGAZATY_FRAGMENT=9;
}
