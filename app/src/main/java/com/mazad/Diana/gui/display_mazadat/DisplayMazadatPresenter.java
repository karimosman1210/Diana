package com.mazad.Diana.gui.display_mazadat;

import android.content.Context;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.DirectAddResponse;
import com.mazad.Diana.data.MazadResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.util.List;

public class DisplayMazadatPresenter extends BasePresenter<DisplayMazadatView> {
    void directAdds(Context context, int saleTypeId, int catId){
        view.showloadingviewBase(context);
        MainApi.listMazadAddsApi(saleTypeId,catId,new ConnectionListener<MainResponse<List<MazadResponse>>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<List<MazadResponse>>> connectionResponse) {
                StaticMethods.printJson("connectionResponsedd",connectionResponse);
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.MazadPostsList(connectionResponse.data.data);
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
