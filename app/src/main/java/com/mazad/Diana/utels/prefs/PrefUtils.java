package com.mazad.Diana.utels.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mazad.Diana.data.UserResponse;
import com.mazad.Diana.utels.AppConstant;

import java.lang.reflect.Type;
import java.util.List;


import static com.mazad.Diana.utels.prefs.PrefKeys.App_Name;

public class PrefUtils {
    public static final int  User_Singin = 1 ,
            User_Singout = 0 ,  User_Verify = 2 ;

    public static final String Is_First_open = "firstopen",
                User_data = "Userdata", USER_TYPE = "status_user",
            Language_List = "languagelist", Language_Selected = "languageselected",
            Token = "token", Country_Selected = "Countryselected" , Language_Selectedobj = "languageselectedobj", PREF="mPreference";;


    public static void saveObjectToSharedPreference(Context context, String preferenceFileName, String serializedObjectKey, Object object) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName, 0);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        final Gson gson = new Gson();
        String serializedObject = gson.toJson(object);
        sharedPreferencesEditor.putString(serializedObjectKey, serializedObject);
        sharedPreferencesEditor.apply();
    }


    public static <GenericClass> GenericClass getSavedObjectFromPreference(Context context, String preferenceFileName, String preferenceKey, Class<GenericClass> classType) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceFileName, 0);
        if (sharedPreferences.contains(preferenceKey)) {
            final Gson gson = new Gson();
            return gson.fromJson(sharedPreferences.getString(preferenceKey, ""), classType);
        }
        return null;
    }

    public static void logout(Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences(App_Name, Context.MODE_PRIVATE);
        sharedpreferences.edit().clear().commit();
    }



    public static Boolean getUserformation(Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(App_Name, Context.MODE_PRIVATE);
        if (sharedpreferences.getInt(USER_TYPE, User_Singout) != User_Singout){
            AppConstant.userResponse=new UserResponse();
            String userdatavalue = sharedpreferences.getString(User_data, null);
            AppConstant.userResponse =  new Gson().fromJson(userdatavalue, UserResponse.class);
            AppConstant.Tokenbar = sharedpreferences.getString(Token, null);
            return  true;
        }else {
            return  false;
        }
    }

    public static boolean getUser(Context context){
            SharedPreferences sharedpreferences = context.getSharedPreferences(App_Name, Context.MODE_PRIVATE);
            Gson gson = new Gson();
        String json = sharedpreferences.getString(User_data, "");
        if (json!=null){
            UserResponse obj = gson.fromJson(json, UserResponse.class);
//            AppConstant.USER_TYPE = sharedpreferences.getInt(USER_TYPE,1);
            AppConstant.userResponse =obj;
            return true;
        }else
        return false;
    }

    public static void saveUserinformation(Context context, UserResponse consumerResponse , int status ) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(App_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        Gson gson = new Gson();
        String Userdatavalue = gson.toJson(consumerResponse);
        editor.putString(User_data, Userdatavalue);
        //editor.putString(Token,token);
        editor.commit();
    }
    public static void saveToken(Context context,String token  ) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(App_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(Token,token);
        editor.commit();
    }

}
