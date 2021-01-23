package com.mazad.Diana.gui.splash;

import android.content.Context;
import android.content.SharedPreferences;

import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.UserResponse;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.prefs.PrefUtils;

import static com.mazad.Diana.utels.prefs.PrefKeys.App_Name;
import static com.mazad.Diana.utels.prefs.PrefUtils.PREF;
import static com.mazad.Diana.utels.prefs.PrefUtils.Token;
import static com.mazad.Diana.utels.prefs.PrefUtils.User_data;

public class SplashPresenter extends BasePresenter<SplashView> {
    void activityFinishedSplashTimer(Context context, UserResponse userResponse) {
        userResponse = PrefUtils.getSavedObjectFromPreference(context, PREF, User_data, UserResponse.class);
        SharedPreferences sharedpreferences = context.getSharedPreferences(App_Name, Context.MODE_PRIVATE);
        if (userResponse != null) {
            AppConstant.userResponse = userResponse;
            view.openHomeUserActivity();

        } else {
            view.openIntro();
        }

    }

}
