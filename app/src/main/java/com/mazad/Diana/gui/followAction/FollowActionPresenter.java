package com.mazad.Diana.gui.followAction;

import android.content.Context;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.BookListResponse;
import com.mazad.Diana.data.FollowMazadResponse;
import com.mazad.Diana.data.HogozatyResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.util.List;

public class FollowActionPresenter extends BasePresenter<FollowActionView> {
    public void addDetails(int addId, Context context) {
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {
            {
                view.showErrorMessageBase(context, context.getString(R.string.noconnection));
                return;
            }
        }
        view.showloadingviewBase(context);

        MainApi.allmazadbooked(addId, new ConnectionListener<MainResponse<List<FollowMazadResponse>>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<List<FollowMazadResponse>>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.userEnterList(connectionResponse.data.data);
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
}
