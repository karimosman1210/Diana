package com.mazad.Diana.gui.upload_mazad;

import android.content.Context;

import com.mazad.Diana.R;
import com.mazad.Diana.base_class.BasePresenter;
import com.mazad.Diana.data.DropDownResponse;
import com.mazad.Diana.data.MultPartPostMazadSale;
import com.mazad.Diana.data.StatusResponse;
import com.mazad.Diana.data.network.ConnectionListener;
import com.mazad.Diana.data.network.ConnectionResponse;
import com.mazad.Diana.data.network.MainApi;
import com.mazad.Diana.data.network.MainApiBody;
import com.mazad.Diana.data.network.MainResponse;
import com.mazad.Diana.utels.Validator;
import com.mazad.Diana.utels.utels.StaticMethods;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class UploadMazadPresenter extends BasePresenter<UploadMazadView> {
    public void dropList(Context context, int catId) {
        boolean internetAvailable = StaticMethods.isConnectingToInternet(context);
        if (!internetAvailable) {
            {
                view.showErrorMessageBase(context, context.getString(R.string.noconnection));
                return;
            }
        }
        view.showloadingviewBase(context);

        MainApi.getDropDownApi(catId, new ConnectionListener<MainResponse<List<DropDownResponse>>>() {
            @Override
            public void onSuccess(ConnectionResponse<MainResponse<List<DropDownResponse>>> connectionResponse) {
                view.hideloadingviewBase();
                if (connectionResponse.data.success) {
                    if (connectionResponse.data.data != null) {
                        view.dorpDown(connectionResponse.data.data);
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

    void PostDirectSale(int categoryId, Context context, String band_rakam, String general_description, String listkey, String listValue, String price, File image1, File image2, File image3, Integer publisherId,
                        int add_time_state, int end_add_time,
                        String require_price_enddate, int avilbleRight_back,
                        int raf3aState, String raf3aNumber,
                        String raf3aless_raise, int enter_mazad) {

        if (Validator.isTextEmpty(band_rakam)) {
            view.showErrorMessageBase(context, context.getString(R.string.band_rakam));
            return;
        } else if (Validator.isTextEmpty(general_description)) {
            view.showErrorMessageBase(context, context.getString(R.string.desception));
            return;
        } else if (Validator.isTextEmpty(price)) {
            view.showErrorMessageBase(context, context.getString(R.string.price));
            return;
        }

        sendPostDirectSale(String.valueOf(categoryId), context, band_rakam, general_description, listkey, listValue, price, image1, image2,
                image3, String.valueOf(publisherId),String.valueOf(add_time_state),String.valueOf(end_add_time)
                ,require_price_enddate,String.valueOf(avilbleRight_back),String.valueOf(raf3aState),
                raf3aNumber,raf3aless_raise,String.valueOf(enter_mazad));

    }

    private void sendPostDirectSale(String categoryId, Context mContext, String band_rakam, String general_description,
                                    String listKey, String listValue, String price, File image1, File image2, File image3, String publisher_id,
                                    String add_time_state, String end_add_time,
                                    String require_price_enddate, String right_back,
                                    String raise, String raise_rkm,
                                    String less_raise, String enter_mazad) {
        MultPartPostMazadSale multPartPostDirectSale = null;
        multPartPostDirectSale = MainApiBody.PostMazadBody(categoryId, band_rakam, general_description, price, publisher_id, listKey, listValue
        ,add_time_state,end_add_time,require_price_enddate,right_back,raise,raise_rkm,less_raise,enter_mazad);
        MultipartBody.Part im1 = null;
        MultipartBody.Part im2 = null;
        MultipartBody.Part im3 = null;
        if (image1 != null) {
            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), image1);
            im1 = MultipartBody.Part.createFormData("img1", image1.getName(), reqFile);
        }

        if (image2 != null) {
            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), image2);
            im2 = MultipartBody.Part.createFormData("img2", image2.getName(), reqFile);
        }
        if (image3 != null) {
            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), image3);
            im3 = MultipartBody.Part.createFormData("img3", image3.getName(), reqFile);
        }
        view.showloadingviewBase(mContext);
        MainApi.MazadSalePost(im1, im2, im3, multPartPostDirectSale.cat_id, multPartPostDirectSale.band_rkm, multPartPostDirectSale.general_description, multPartPostDirectSale.values,
                multPartPostDirectSale.keys, multPartPostDirectSale.price, multPartPostDirectSale.pusherRequst,multPartPostDirectSale.add_time_state,
                multPartPostDirectSale.end_add_time,multPartPostDirectSale.require_price_enddate,multPartPostDirectSale.right_back,multPartPostDirectSale.raise,
                multPartPostDirectSale.raise_rkm,multPartPostDirectSale.less_raise,multPartPostDirectSale.enter_mazad, new ConnectionListener<MainResponse<StatusResponse>>() {
                    @Override
                    public void onSuccess(ConnectionResponse<MainResponse<StatusResponse>> connectionResponse) {
                        view.hideloadingviewBase();
                        StaticMethods.printJson("connectionResponse",connectionResponse);
                        if (connectionResponse.data.data != null) {
                            if (connectionResponse.data.success){
                                view.successAdded();
                                view.showSuccessMessageBase(mContext,connectionResponse.data.message);
                            }else {
                                view.showErrorMessageBase(mContext,connectionResponse.data.message);

                            }
                        }
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        view.hideloadingviewBase();
                        StaticMethods.printJson("saddasd", throwable.getMessage());
                        view.showErrorMessageBase(mContext, mContext.getString(R.string.tryagaing));
                    }
                });

    }

}
