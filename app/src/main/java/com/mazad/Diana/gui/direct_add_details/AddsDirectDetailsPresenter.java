package com.mazad.Diana.gui.direct_add_details;

import android.content.Context;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.AddDetails;
import com.mazad.Diana.data.CategoriesResponse;
import com.mazad.Diana.data.StatusResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.util.List;

public class AddsDirectDetailsPresenter extends BasePresenter<AddsDirectDetailsView> {

    public void addDetails(int addId, Context context) {
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {
            {
                view.showErrorMessageBase(context, context.getString(R.string.noconnection));
                return;
            }
        }
        view.showloadingviewBase(context);

        MainApi.AddDetailsApi(addId, new ConnectionListener<MainResponse<AddDetails>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<AddDetails>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.currentAddDetails(connectionResponse.data.data);
                    }
                }
            }

            @Override
            public void onFail(Throwable throwable) {
                view.hideloadingviewBase();
                view.showErrorMessageBase(context, context.getString(R.string.tryagaing));
            }
        });

    }

    public void bookAdd(int add_id, int cate_id,
                        int number_products,
                        int publisher_id, Context context) {
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {
            {
                view.showErrorMessageBase(context, context.getString(R.string.noconnection));
                return;
            }
        }
        view.showloadingviewBase(context);

        MainApi.BookAddAPi(add_id, cate_id, number_products, publisher_id, new ConnectionListener<MainResponse<StatusResponse>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<StatusResponse>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.successBooked();
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
