package com.mazad.Diana.gui.category;

import android.content.Context;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.CategoriesResponse;
import com.mazad.Diana.data.Sale_typeResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.util.ArrayList;
import java.util.List;

public class CategoryPresenter extends BasePresenter<CategoryView> {
    public void MyCliantsData(Context context) {
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {
            {
                view.showErrorMessageBase(context, context.getString(R.string.noconnection));
                return;
            }
        }
        view.showloadingviewBase(context);

        MainApi.categoryApi(new ConnectionListener<MainResponse<List<CategoriesResponse>>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<List<CategoriesResponse>>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                       view.categoryList(connectionResponse.data.data);
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
