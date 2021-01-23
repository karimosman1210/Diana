package com.mazad.Diana.gui.signup;

import android.content.Context;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.Countrys;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.data.MultPartSignUp;
import com.mazad.Diana.data.UserResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainApiBody;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.Validator;
import com.mazad.Diana.utels.utels.StaticMethods;

import org.json.JSONException;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class SignUpPresenter extends BasePresenter<SignUpInterface> {
    public void  signUpData(String phone  , String password, String firstName, String neckName
            , String email, String conPass, Context context, File image,int countryiD, CoordinatorLayout coordinatorLayout ) {
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {
            view.showNoNetworkConnectionBase(coordinatorLayout, context);
            return;
        } else if (image==null) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.emptyImage));
            return;
        }
        else if (Validator.isTextEmpty(firstName)) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.emptyName));
            return;
        }  else if (Validator.isTextEmpty(neckName)) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.emptyNickname));
            return;
        }else if (Validator.isTextEmpty(email)) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.emptyEmail));
            return;
        }else if (Validator.isTextEmpty(password)) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.emptyPassword));
            return;
        } else if (!Validator.validPasswordLength(password)) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.invaildPasswordLenght));

            return;
        }
        else if (Validator.isTextEmpty(conPass)) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.confirm_password));
            return;
        }else if (Validator.isTextEmpty(phone)) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.emptyphone));
            return;
        }  else if (countryiD==-1) {
            view.showErrorMessageBase(coordinatorLayout, context, context.getString(R.string.emptyCountry));
            return;
        }

        MultPartSignUp multPartSignUp =null;
        multPartSignUp =MainApiBody.multPartSignUp(phone,password,firstName,neckName,email,image,String.valueOf(countryiD));

        view.showloadingviewBase(context);
        MainApi.Registerapi(multPartSignUp.profile_image,multPartSignUp.name,multPartSignUp.email,multPartSignUp.fame,
                multPartSignUp.mobile,multPartSignUp.password,multPartSignUp.governorate, new ConnectionListener<MainResponse<UserResponse>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<UserResponse>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {

                        view.showSuccessMessageBase(context,context.getString(R.string.newAccount));
                        view.sucessSignUp(connectionResponse.data.data);
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
    void getCountries(Context context){
        view.showloadingviewBase(context);
        MainApi.countriesApi(new ConnectionListener<MainResponse<List<Countrys>>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<List<Countrys>>> connectionResponse) {
                StaticMethods.printJson("connectionResponsedd",connectionResponse);
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.listCountry(connectionResponse.data.data);
                    } else
                        view.showSuccessMessageBase( context, connectionResponse.data.message);
                } else {
                    view.showSuccessMessageBase( context, connectionResponse.data.message);

                }
            }

            @Override
            public void onFail(Throwable throwable) {
                view.hideloadingviewBase();
                StaticMethods.printJson("saddasd", throwable.getMessage());
                view.showSuccessMessageBase( context, context.getString(R.string.tryagaing));

            }
        });
    }
}
