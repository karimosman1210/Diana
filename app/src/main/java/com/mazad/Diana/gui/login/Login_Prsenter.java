package com.mazad.Diana.gui.login;

import android.content.Context;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.UserResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainApiBody;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.Validator;
import com.mazad.Diana.utels.prefs.PrefUtils;
import com.mazad.Diana.utels.utels.StaticMethods;

import org.json.JSONException;

import java.util.HashMap;

public class Login_Prsenter extends BasePresenter<LoginInterface> {
    void  loginData(String phone  , String password,Context context , CoordinatorLayout coordinatorLayout ) {
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {
            view.showNoNetworkConnectionBase(coordinatorLayout, context);
            return;
        } else if (Validator.isTextEmpty(phone)) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.emptyphone));
            return;
        } else if (Validator.isTextEmpty(password)) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.emptyPassword));
            return;
        } else if (!Validator.validPasswordLength(password)) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.invaildPasswordLenght));

            return;
        }
        HashMap<String, String> requestBody = null;
        try {
            requestBody = MainApiBody.LoginBoby(phone, password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        view.showloadingviewBase(context);
        MainApi.Loginapi(phone, password, new ConnectionListener<MainResponse<UserResponse>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<UserResponse>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {

                        view.showSuccessMessageBase(coordinatorLayout, context, connectionResponse.data.message);
                        view.sucessLogin(connectionResponse.data.data);
                    } else
                        view.showErrorMessageBase(coordinatorLayout, context, connectionResponse.data.message);
                } else {
                    view.showErrorMessageBase(coordinatorLayout, context, connectionResponse.data.message);
                }
            }

            @Override
            public void onFail(Throwable throwable) {
                view.hideloadingviewBase();
                StaticMethods.printJson("saddasd", throwable.getMessage());
                view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.tryagaing));
            }
        });
    }
}
