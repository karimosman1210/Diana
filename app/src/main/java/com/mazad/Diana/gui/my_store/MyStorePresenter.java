package com.mazad.Diana.gui.my_store;

import android.content.Context;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.data.StatusResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.Validator;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.util.List;

public class MyStorePresenter extends BasePresenter<MyStoreView> {
    void storeAdd(Context context, int userId){
        view.showloadingviewBase(context);
        MainApi.mySoreApi(userId,new ConnectionListener<MainResponse<List<DirectAddResponse>>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<List<DirectAddResponse>>> connectionResponse) {
                StaticMethods.printJson("connectionResponsedd",connectionResponse);
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.storeList(connectionResponse.data.data);
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
    public void rePublishAdd(int add_id ,String price, Context context) {
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {

                view.showErrorMessageBase(context, context.getString(R.string.noconnection));
                return;

        }else if (Validator.isTextEmpty(price)) {
            view.showErrorMessageBase(context, context.getString(R.string.price));
            return;

        }
        view.showloadingviewBase(context);

        MainApi.rePublishAdd(add_id ,Double.parseDouble(price), new ConnectionListener<MainResponse<StatusResponse>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<StatusResponse>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.showSuccessMessageBase(context, connectionResponse.data.message);
                        view.rebublishSuccess();
                    }
                } else {
                    view.showErrorMessageBase(context, connectionResponse.data.message);
                }
            }

            @Override
            public void onFail(Throwable throwable) {
                view.hideloadingviewBase();
                view.showErrorMessageBase(context, context.getString(R.string.tryagaing));
            }
        });
    }
}
