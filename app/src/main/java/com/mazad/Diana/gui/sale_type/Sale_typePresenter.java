package com.mazad.Diana.gui.sale_type;

import android.content.Context;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.Sale_typeResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.util.ArrayList;
import java.util.List;

public class Sale_typePresenter extends BasePresenter<Sale_typeView> {
    List<Sale_typeResponse> mazadList;
    List<Sale_typeResponse> DirectList;

    public void MyCliantsData(Context context) {
        mazadList = new ArrayList<>();
        DirectList = new ArrayList<>();
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {
            {
                view.showErrorMessageBase(context, context.getString(R.string.noconnection));
                return;
            }
        }
        view.showloadingviewBase(context);

        MainApi.saleType(new ConnectionListener<MainResponse<List<Sale_typeResponse>>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<List<Sale_typeResponse>>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        DirectList.add(connectionResponse.data.data.get(2));
                        DirectList.add(connectionResponse.data.data.get(3));

                        mazadList.add(connectionResponse.data.data.get(4));
                        mazadList.add(connectionResponse.data.data.get(5));

                        view.listDirect(DirectList);
                        view.listMazad(mazadList);
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
