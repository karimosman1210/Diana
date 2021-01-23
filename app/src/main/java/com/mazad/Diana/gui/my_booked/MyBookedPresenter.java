package com.mazad.Diana.gui.my_booked;

import android.content.Context;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.BookListResponse;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.data.StatusResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.AppConstant;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.util.List;

public class MyBookedPresenter extends BasePresenter<MyBookedView> {
    public void getMyAddsData(int idAdd, Context context) {
        view.showloadingviewBase(context);
        MainApi.BookPostAp(idAdd,new ConnectionListener<MainResponse<List<BookListResponse>>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<List<BookListResponse>>> connectionResponse) {
                StaticMethods.printJson("connectionResponsedd",connectionResponse);
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.listUserBooked(connectionResponse.data.data);
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

    public void acceptBookedData(int add_id , int publisherId, Context context) {
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {
            {
                view.showErrorMessageBase(context, context.getString(R.string.noconnection));
                return;
            }
        }
        view.showloadingviewBase(context);

        MainApi.AcceptBookedApi(add_id,publisherId, new ConnectionListener<MainResponse<StatusResponse>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<StatusResponse>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.showSuccessMessageBase(context, connectionResponse.data.message);
                        view.acceptBookedSuccess();
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
