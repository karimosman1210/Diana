package com.mazad.Diana.gui.mazad_details;

import android.content.Context;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.StatusResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.Validator;
import com.mazad.Diana.utels.utels.StaticMethods;

public class MazadDetailsPrsenter  extends BasePresenter<MazadDetailsView> {
    public void rePublishAdd(int add_id ,String price,int publisher_id,int cate_id, Context context) {
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {

            view.showErrorMessageBase(context, context.getString(R.string.noconnection));
            return;

        }else if (Validator.isTextEmpty(price)) {
            view.showErrorMessageBase(context, context.getString(R.string.price));
            return;

        }
        view.showloadingviewBase(context);

        MainApi.enterMazad(add_id,cate_id ,Double.parseDouble(price),publisher_id, new ConnectionListener<MainResponse<StatusResponse>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<StatusResponse>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.showSuccessMessageBase(context, connectionResponse.data.message);
                        view.bookedSuccess();
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
